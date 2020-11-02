package com.project.name.service.auth.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
public class AuthUserDTO {
    private Long userId;
    private String userName;
    private String userPassword;
    private LocalDateTime createTime;
    private Long createId;
    private LocalDateTime updateTime;
    private Long updateId;

}
