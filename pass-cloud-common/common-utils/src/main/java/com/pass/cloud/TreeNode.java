package com.pass.cloud;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
public class TreeNode {

    /**
     * 节点编码
     */
    @ApiModelProperty(value = "节点编码")
    private String nodeCode;
    /**
     * 节点名称
     */
    @ApiModelProperty(value = "节点名称")
    private String nodeName;
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long pid;
    /**
     * 孩子节点信息
     */
    @ApiModelProperty(value = "子节点信息")
    private List<TreeNode> children;

}
