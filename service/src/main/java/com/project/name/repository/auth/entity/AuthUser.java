package com.project.name.repository.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * ClassName: AuthUser <br/>
 * Description: TODO
 * Date 2020/10/30 9:28
 *
 * @author Lenovo
 **/
@Data
@ToString
@ApiModel(value = "用户实体")
public class AuthUser {
    @ApiModelProperty(value = "用户ID")
    @TableId(type = IdType.ID_WORKER)       //雪花算法
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    private Long createId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "修改人")
    private Long updateId;
}
