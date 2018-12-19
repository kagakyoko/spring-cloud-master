package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ForgetCheckAnswerDto implements Serializable {

    private static final long serialVersionUID = -4611532562847293450L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 问题
     */
    private String email;

    /**
     * 答案
     */
    private String answer;

}
