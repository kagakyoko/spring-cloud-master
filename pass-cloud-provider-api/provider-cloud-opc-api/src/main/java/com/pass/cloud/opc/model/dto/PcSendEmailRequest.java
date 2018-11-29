package com.pass.cloud.opc.model.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class PcSendEmailRequest implements Serializable {

    private static final long serialVersionUID = 8391763073747981998L;

    private String text;

    private String subject;

    private Set<String> to;

}
