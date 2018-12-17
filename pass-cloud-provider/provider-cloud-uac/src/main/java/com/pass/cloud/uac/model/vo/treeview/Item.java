package com.pass.cloud.uac.model.vo.treeview;

import lombok.Data;

/**
 * @author takesi
 */
@Data
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
