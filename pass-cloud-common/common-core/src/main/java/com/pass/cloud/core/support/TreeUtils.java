package com.pass.cloud.core.support;

import java.io.Serializable;

import com.pass.cloud.base.dto.BaseTree;

/**
 * @param <T>
 * @param <ID>
 * @author takesi
 */
public class TreeUtils<T extends BaseTree<T, ID>, ID extends Serializable> extends AbstractTreeService<T, ID> {

}
