package com.pass.cloud.page;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class Query implements Serializable {

    private static final long serialVersionUID = 8933019121780323520L;
    /**
     * 当前页
     */
    private int pageNum = 1;
    /**
     * 每页的数量
     */
    private int pageSize = 20;

}
