package com.pass.cloud.uac.model.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ElementTreeVo implements Serializable {

    private static final long serialVersionUID = -7266614376023024646L;

    private String label;

    private List<ElementTreeVo> children;

}
