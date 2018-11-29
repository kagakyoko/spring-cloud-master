package com.pass.cloud.mdc.service;

import java.util.List;

import com.pass.cloud.TreeNode;
import com.pass.cloud.core.support.IService;
import com.pass.cloud.mdc.model.domain.MdcAddress;

/**
 * @author takesi
 */
public interface MdcAddressService extends IService<MdcAddress> {

    /**
     * 根据PID查询地址信息
     *
     * @param pid the pid
     * @return the list
     */
    List<MdcAddress> listByPid(Long pid);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    MdcAddress getById(Long id);

    /**
     * Gets 4 city.
     *
     * @return the 4 city
     */
    List<TreeNode> get4City();

}
