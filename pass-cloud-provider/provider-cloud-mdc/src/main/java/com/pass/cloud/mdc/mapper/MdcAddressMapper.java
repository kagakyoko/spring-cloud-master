package com.pass.cloud.mdc.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.mdc.model.domain.MdcAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface MdcAddressMapper extends MyMapper<MdcAddress> {

    /**
     * Select mdc address list.
     *
     * @param address the address
     * @return the list
     */
    List<MdcAddress> selectMdcAddress(MdcAddress address);

    /**
     * Select address by pid list.
     *
     * @param pid the pid
     * @return the list
     */
    List<MdcAddress> selectAddressByPid(Long pid);

}
