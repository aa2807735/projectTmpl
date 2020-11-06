package com.project.name.service.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@ApiModel("分页查询实体")
public class AuthUserListDTO {
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty(value = "用户名称", example = "2020-09.16 00:00:00")
    private String userName;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
