package com.pass.cloud.uac.model.vo.treeview;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class AdditionalParameters {

    /**
     * 子节点列表
     */
    private Map<String, Item> children;

    /**
     * 节点的Id
     */
    private Long id;

    /**
     * 是否有选中属性
     */
    @JsonProperty("item-selected")
    private boolean itemSelected;

}
