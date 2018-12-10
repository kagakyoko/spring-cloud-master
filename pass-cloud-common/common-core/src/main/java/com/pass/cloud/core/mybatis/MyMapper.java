package com.pass.cloud.core.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @param <T> the type parameter
 * @author takesi
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
