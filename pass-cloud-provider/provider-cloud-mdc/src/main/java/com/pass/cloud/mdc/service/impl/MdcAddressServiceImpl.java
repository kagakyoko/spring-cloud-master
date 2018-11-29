package com.pass.cloud.mdc.service.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.pass.cloud.RecursionTreeUtil;
import com.pass.cloud.TreeNode;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.mdc.mapper.MdcAddressMapper;
import com.pass.cloud.mdc.model.domain.MdcAddress;
import com.pass.cloud.mdc.service.MdcAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class MdcAddressServiceImpl extends BaseService<MdcAddress> implements MdcAddressService {

    @Autowired
    private MdcAddressMapper mdcAddressMapper;

    @Override
    public List<MdcAddress> listByPid(Long pid) {
        return mdcAddressMapper.selectAddressByPid(pid);
    }

    @Override
    public MdcAddress getById(Long id) {
        return mdcAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TreeNode> get4City() {
        List<MdcAddress> mdcAddresses = mdcAddressMapper.selectAll();
        List<TreeNode> treeNodeList = buildGroupTree(mdcAddresses);
        return treeNodeList;
    }

    private List<TreeNode> buildGroupTree(List<MdcAddress> mdcAddressesList) {
        List<TreeNode> list = Lists.newArrayList();
        TreeNode node;
        for (MdcAddress group : mdcAddressesList) {
            node = new TreeNode();
            node.setId(group.getId());
            node.setPid(group.getPid());
            node.setNodeCode(group.getAdCode());
            node.setNodeName(group.getName());
            list.add(node);
        }

        return RecursionTreeUtil.getChildTreeNodes(list, 368100107951677440L);
    }
}
