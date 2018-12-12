package com.pass.cloud.uac.mapper;

import java.util.List;
import java.util.Map;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacUserToken;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacUserTokenMapper extends MyMapper<UacUserToken> {

    /**
     * Select token list list.
     *
     * @param userToken the user token
     * @return the list
     */
    List<UacUserToken> selectTokenList(UacUserToken userToken);

    /**
     * 超时token更新为离线.
     *
     * @param map the map
     * @return the int
     */
    int batchUpdateTokenOffLine(Map<String, Object> map);

    /**
     * 查询超时token Id 集合.
     *
     * @return the list
     */
    List<Long> listOffLineTokenId();

}
