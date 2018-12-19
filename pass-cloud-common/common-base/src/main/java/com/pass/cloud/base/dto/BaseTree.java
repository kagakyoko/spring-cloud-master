package com.pass.cloud.base.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @param <E>
 * @param <ID>
 * @author takesi
 */
@Data
public class BaseTree<E, ID> implements Serializable {

    private static final long serialVersionUID = -5703964834600572016L;

    /**
     * ID
     */
    private ID id;

    /**
     * 父ID
     */
    private ID pid;

    /**
     * 是否含有子节点
     */
    private boolean hasChild = false;

    /**
     * 子节点集合
     */
    private List<E> children;

}
