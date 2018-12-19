package com.pass.cloud;

import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class TreeNode {

    /**
     * 节点编码
     */
    private String nodeCode;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * ID
     */
    private Long id;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 子节点信息
     */
    private List<TreeNode> children;

}
