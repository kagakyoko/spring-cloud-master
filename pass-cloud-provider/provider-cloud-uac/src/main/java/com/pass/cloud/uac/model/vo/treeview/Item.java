package com.pass.cloud.uac.model.vo.treeview;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class Item {

    private Long id;
    /**
     * 节点的名字
     */
    private String text;

    /**
     * 节点的类型："item":文件 "folder":目录
     */
    private String type;

    /**
     * 子节点的信息
     */
    private AdditionalParameters additionalParameters;

}
