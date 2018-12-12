package com.pass.cloud.uac.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.pass.cloud.PublicUtil;
import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.uac.exception.UacBizException;
import com.pass.cloud.uac.mapper.UacGroupMapper;
import com.pass.cloud.uac.mapper.UacGroupUserMapper;
import com.pass.cloud.uac.mapper.UacRoleMapper;
import com.pass.cloud.uac.model.domain.UacGroup;
import com.pass.cloud.uac.model.domain.UacGroupUser;
import com.pass.cloud.uac.model.dto.group.GroupBindUserDto;
import com.pass.cloud.uac.model.dto.role.BindUserDto;
import com.pass.cloud.uac.model.enums.UacGroupStatusEnum;
import com.pass.cloud.uac.model.vo.GroupZtreeVo;
import com.pass.cloud.uac.model.vo.MenuVo;
import com.pass.cloud.uac.service.UacGroupService;
import com.pass.cloud.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author takesi
 */
@Service
public class UacGroupServiceImpl extends BaseService<UacGroup> implements UacGroupService {

    @Autowired
    private UacGroupMapper uacGroupMapper;

    @Autowired
    private UacGroupUserMapper uacGroupUserMapper;

    @Autowired
    private UacRoleMapper uacRoleMapper;

    @Override
    public int deleteUacGroupById(Long id) {
        Preconditions.checkArgument(id != null, "组织id为空");
        Preconditions.checkArgument(!Objects.equals(id, GlobalConstant.Sys.SUPER_MANAGER_GROUP_ID), "该组织不能删除");

        // 根据前台传入的组织参数校验该组织是否存在
        UacGroup uacGroup = uacGroupMapper.selectByPrimaryKey(id);
        if (PublicUtil.isEmpty(uacGroup)) {
            throw new UacBizException(ErrorCodeEnum.UAC10015004, id);
        }

        //判断该组织下是否存在子节点
        UacGroup childGroup = new UacGroup();
        childGroup.setPid(id);
        List<UacGroup> childGroupList = uacGroupMapper.select(childGroup);
        if (PublicUtil.isNotEmpty(childGroupList)) {
            throw new UacBizException(ErrorCodeEnum.UAC10015007, id);
        }

        //判断该组织下是否存在用户
        UacGroupUser uacGroupUser = new UacGroupUser();
        uacGroupUser.setGroupId(id);
        List<UacGroupUser> uacGroupUserList = uacGroupUserMapper.select(uacGroupUser);
        if (PublicUtil.isNotEmpty(uacGroupUserList)) {
            throw new UacBizException(ErrorCodeEnum.UAC10015008, id);
        }

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public UacGroup queryById(Long groupId) {
        Preconditions.checkArgument(PublicUtil.isNotEmpty(groupId), "组织Id不能为空");
        UacGroup query = new UacGroup();
        query.setId(groupId);
        return uacGroupMapper.selectOne(query);
    }

    @Override
    public List<GroupZtreeVo> getGroupTree(Long groupId) {
        // 1. 如果是仓库则 直接把仓库信息封装成ztreeVo返回
        List<GroupZtreeVo> tree = Lists.newArrayList();

        UacGroup uacGroup = uacGroupMapper.selectByPrimaryKey(groupId);

        GroupZtreeVo zTreeMenuVo = buildGroupZTreeVoByGroup(uacGroup);
        if (0L == uacGroup.getPid()) {
            zTreeMenuVo.setOpen(true);
        }
        tree.add(zTreeMenuVo);

        // 2.如果是组织id则遍历组织+仓库的树结构
        UacGroup uacGroupQuery = new UacGroup();
        uacGroupQuery.setPid(groupId);
        List<UacGroup> groupList = uacGroupMapper.select(uacGroupQuery);
        if (PublicUtil.isNotEmpty(groupList)) {
            tree = buildNode(groupList, tree);
        }

        return tree;
    }

    @Override
    public List<MenuVo> getGroupTreeListByUserId(Long userId) {
        UacGroupUser groupUser = uacGroupUserMapper.getByUserId(userId);
        Long groupId = groupUser.getGroupId();
        //查询当前登陆人所在的组织信息
        UacGroup currentUserUacGroup = uacGroupMapper.selectByPrimaryKey(groupId);
        //获取当前所选组织的所有子节点
        List<GroupZtreeVo> childUacGroupList = this.getGroupTree(currentUserUacGroup.getId());
        return this.buildGroupTree(childUacGroupList, groupId);
    }

    @Override
    public GroupBindUserDto getGroupBindUserDto(Long groupId, Long currentUserId) {
        GroupBindUserDto groupBindUserDto = new GroupBindUserDto();
        Set<Long> alreadyBindUserIdSet = Sets.newHashSet();
        UacGroup uacGroup = uacGroupMapper.selectByPrimaryKey(groupId);
        if (PublicUtil.isEmpty(uacGroup)) {
            logger.error("找不到uacGroup={}, 的组织", uacGroup);
            throw new UacBizException(ErrorCodeEnum.UAC10015001, groupId);
        }

        // 查询所有用户包括已禁用的用户
        List<BindUserDto> bindUserDtoList = uacRoleMapper.selectAllNeedBindUser(GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID, currentUserId);
        // 该组织已经绑定的用户
        List<UacGroupUser> setAlreadyBindUserSet = uacGroupUserMapper.listByGroupId(groupId);

        Set<BindUserDto> allUserSet = new HashSet<>(bindUserDtoList);

        for (UacGroupUser uacGroupUser : setAlreadyBindUserSet) {
            alreadyBindUserIdSet.add(uacGroupUser.getUserId());
        }

        groupBindUserDto.setAllUserSet(allUserSet);
        groupBindUserDto.setAlreadyBindUserIdSet(alreadyBindUserIdSet);

        return groupBindUserDto;
    }

    @Override
    public UacGroup getById(Long id) {
        UacGroup uacGroup = uacGroupMapper.selectByPrimaryKey(id);
        if (PublicUtil.isEmpty(uacGroup)) {
            throw new UacBizException(ErrorCodeEnum.UAC10015001, id);
        }
        UacGroup parentGroup = uacGroupMapper.selectByPrimaryKey(uacGroup.getPid());
        if (parentGroup != null) {
            uacGroup.setParentGroupCode(parentGroup.getGroupCode());
            uacGroup.setParentGroupName(parentGroup.getGroupName());
        }
        // 处理级联菜单回显地址
        Long provinceId = uacGroup.getProvinceId();
        Long cityId = uacGroup.getCityId();
        Long areaId = uacGroup.getAreaId();
        Long streetId = uacGroup.getStreetId();
        List<Long> addressList = Lists.newArrayList();
        if (provinceId != null) {
            addressList.add(provinceId);
        }
        if (cityId != null) {
            addressList.add(cityId);
        }
        if (areaId != null) {
            addressList.add(areaId);
        }
        if (streetId != null) {
            addressList.add(streetId);
        }
        uacGroup.setAddressList(addressList);
        return uacGroup;
    }

    private int addUacGroup(UacGroup group) {
        if (StringUtils.isEmpty(group.getStatus())) {
            group.setStatus(UacGroupStatusEnum.ENABLE.getStatus());
        }
        return uacGroupMapper.insertSelective(group);
    }

    private int editUacGroup(UacGroup group) {
        return uacGroupMapper.updateByPrimaryKeySelective(group);
    }

    private GroupZtreeVo buildGroupZTreeVoByGroup(UacGroup group) {
        GroupZtreeVo vo = new GroupZtreeVo();
        vo.setId(group.getId());
        vo.setpId(group.getPid());
        vo.setName(group.getGroupName());
        vo.setType(group.getType());
        vo.setStatus(group.getStatus());
        vo.setLeaf(group.getLevel());
        vo.setLevel(group.getLevel());
        vo.setGroupCode(group.getGroupCode());

        vo.setContact(group.getContact());
        vo.setContactPhone(group.getContactPhone());
        vo.setCreatedTime(group.getCreatedTime() == null ? new Date() : group.getCreatedTime());
        vo.setCreator(group.getCreator());
        vo.setGroupAddress(group.getGroupAddress());
        vo.setGroupName(group.getGroupName());

        return vo;
    }

    private List<GroupZtreeVo> buildNode(List<UacGroup> groupList, List<GroupZtreeVo> tree) {

        for (UacGroup group : groupList) {

            GroupZtreeVo groupZTreeVo = buildGroupZTreeVoByGroup(group);

            if (0L == group.getPid()) {
                groupZTreeVo.setOpen(true);
            }
            // 设置根节点
            tree.add(groupZTreeVo);

            UacGroup query = new UacGroup();
            query.setPid(group.getId());

            List<UacGroup> groupChildrenList = uacGroupMapper.select(query);
            // 有子节点 递归查询
            if (PublicUtil.isNotEmpty(groupChildrenList)) {
                buildNode(groupChildrenList, tree);
            }

        }
        return tree;
    }

    private List<MenuVo> buildGroupTree(List<GroupZtreeVo> childUacGroupList, Long currentGroupId) {
        List<MenuVo> listVo = Lists.newArrayList();
        MenuVo menuVo;
        for (GroupZtreeVo group : childUacGroupList) {
            menuVo = new MenuVo();
            menuVo.setId(group.getId());
            if (currentGroupId.equals(group.getId())) {
                menuVo.setPid(0L);
            } else {
                menuVo.setPid(group.getpId());
            }
            menuVo.setMenuCode(group.getGroupCode());
            menuVo.setMenuName(group.getGroupName());
            listVo.add(menuVo);
        }

        return TreeUtil.getChildMenuVos(listVo, 0L);
    }

}
