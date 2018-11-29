package com.pass.cloud.opc.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class PcSendSmsRequest implements Serializable {

    private static final long serialVersionUID = 8391763073747981998L;

    private String phoneNumbers;

    private String templateCode;

    private String templateParam;

    private String outId;

}
