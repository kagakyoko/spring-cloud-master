package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class Perm implements Serializable {

    private static final long serialVersionUID = 6578617729619284277L;

    private String resource;

    private String perm;

}
