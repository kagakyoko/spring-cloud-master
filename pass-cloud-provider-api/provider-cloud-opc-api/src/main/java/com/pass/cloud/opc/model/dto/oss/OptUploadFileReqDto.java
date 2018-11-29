package com.pass.cloud.opc.model.dto.oss;

import java.io.Serializable;

import com.pass.cloud.opc.model.dto.attachment.OptUploadFileByteInfoReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "OptUploadFileReqDto")
public class OptUploadFileReqDto implements Serializable {

    private static final long serialVersionUID = -8008720269972450739L;
    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    /**
     * 文件服务器根目录
     */
    @ApiModelProperty(value = "文件服务器根目录")
    private String bucketName;
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    private OptUploadFileByteInfoReqDto uploadFileByteInfoReqDto;

}
