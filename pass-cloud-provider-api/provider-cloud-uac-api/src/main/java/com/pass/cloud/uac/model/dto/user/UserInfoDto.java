package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息Dto
 *
 * @author takesi
 */
@Data
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = -889913964833331690L;

    private Long id;

    private String userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 盐,用于shiro加密, 字段停用
     */
    private String salt;

    /**
     * 工号
     */
    private String userCode;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 状态
     */
    private String status;

    /**
     * 用户来源
     */
    private String userSource;

    /**
     * 操作员类型（）
     */
    private String type;

    /**
     * 最后登录IP地址
     */
    private String lastLoginIp;

    /**
     * 描述
     */
    private String remark;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户所属的组织ID
     */
    private Long groupId;

    /**
     * 用户所属的组织名称
     */
    private String groupName;

}
