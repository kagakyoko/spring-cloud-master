package com.pass.cloud.uac.service.impl;

import java.util.List;
import java.util.Objects;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.pass.cloud.PublicUtil;
import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.uac.exception.UacBizException;
import com.pass.cloud.uac.mapper.UacActionMapper;
import com.pass.cloud.uac.mapper.UacRoleActionMapper;
import com.pass.cloud.uac.model.domain.UacAction;
import com.pass.cloud.uac.model.domain.UacMenu;
import com.pass.cloud.uac.model.dto.action.ActionMainQueryDto;
import com.pass.cloud.uac.model.vo.ActionVo;
import com.pass.cloud.uac.model.vo.MenuVo;
import com.pass.cloud.uac.service.UacActionService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;

/**
 * @author takesi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacActionServiceImpl extends BaseService<UacAction> implements UacActionService {

    @Autowired
    private UacActionMapper uacActionMapper;

    @Autowired
    private UacRoleActionMapper uacRoleActionMapper;

    @Override
    public PageInfo<ActionVo> queryActionListWithPage(ActionMainQueryDto actionMainQueryDto) {
        List<Long> menuIdList = actionMainQueryDto.getMenuIdList();

        Long menuId = null;
        if (PublicUtil.isNotEmpty(menuIdList)) {
            menuId = menuIdList.get(menuIdList.size() - 1);
        }

        UacAction uacAction = new UacAction();
        uacAction.setMenuId(menuId);
        BeanUtils.copyProperties(actionMainQueryDto, uacAction);
        uacAction.setOrderBy("update_time desc");

        PageHelper.startPage(actionMainQueryDto.getPageNum(), actionMainQueryDto.getPageSize());
        List<ActionVo> actionList = uacActionMapper.queryActionListWithPage(uacAction);
        return new PageInfo<>(actionList);
    }

    @Override
    public int deleteActionById(Long actionId) {
        //查询该角色下是否有用户绑定, 有的话提醒不能删除
        Preconditions.checkArgument(actionId != null, "权限ID不能为空");

        UacAction uacAction = uacActionMapper.selectByPrimaryKey(actionId);
        if (uacAction == null) {
            logger.error("找不到权限信息 actionId={}", actionId);
            throw new UacBizException(ErrorCodeEnum.UAC10014001, actionId);
        }

        // 删除角色权限表数据  不查询 直接删除了
        uacRoleActionMapper.deleteByActionId(actionId);

        return uacActionMapper.deleteByPrimaryKey(actionId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDeleteByIdList(List<Long> deleteIdList) {
        Preconditions.checkArgument(PublicUtil.isNotEmpty(deleteIdList), "删除权限ID不能为空");

        int result = uacActionMapper.batchDeleteByIdList(deleteIdList);
        if (result < deleteIdList.size()) {
            throw new UacBizException(ErrorCodeEnum.UAC10014002, Joiner.on(GlobalConstant.Symbol.COMMA).join(deleteIdList));
        }
    }

    @Override
    public int deleteByMenuId(Long id) {
        Preconditions.checkArgument(id != null, "菜单ID不能为空");

        return uacActionMapper.deleteByMenuId(id);
    }

    @Override
    public List<Long> getCheckedActionList(Long roleId) {
        if (roleId == null) {
            throw new UacBizException(ErrorCodeEnum.UAC10012001);
        }
        return uacActionMapper.getCheckedActionList(roleId);
    }

    @Override
    public List<MenuVo> getOwnAuthList(Long userId) {
        return uacActionMapper.getOwnAuthList(userId);
    }

    @Override
    public List<Long> getCheckedMenuList(Long roleId) {
        if (roleId == null) {
            throw new UacBizException(ErrorCodeEnum.UAC10012001);
        }
        return uacActionMapper.getCheckedMenuList(roleId);
    }

    @Override
    public List<UacAction> getOwnActionListByUserId(Long userId) {
        if (userId == null) {
            throw new UacBizException(ErrorCodeEnum.UAC10011001);
        }

        List<UacAction> uacActionList;
        if (Objects.equals(userId, GlobalConstant.Sys.SUPER_MANAGER_USER_ID)) {
            // 获取全部权限信息
            uacActionList = uacActionMapper.selectAll();
        } else {
            uacActionList = uacActionMapper.getOwnUacActionListByUserId(userId);
        }

        return uacActionList;
    }

    @Override
    public List<UacAction> listActionListByRoleId(Long roleId) {
        return uacActionMapper.listActionListByRoleId(roleId);
    }

    @Override
    public List<UacAction> listActionList(List<UacMenu> uacMenus) {
        return uacActionMapper.listActionList(uacMenus);
    }

    @Override
    public UacAction matchesByUrl(String requestUrl) {
        List<UacAction> uacActionList = uacActionMapper.selectAll();
        final AntPathMatcher antPathMatcher = new AntPathMatcher();

        for (UacAction uacAction : uacActionList) {
            String url = uacAction.getUrl();
            if (StringUtils.isEmpty(url)) {
                continue;
            }

            if (antPathMatcher.match(url, requestUrl)) {
                return uacAction;
            }

        }
        return null;
    }
}
