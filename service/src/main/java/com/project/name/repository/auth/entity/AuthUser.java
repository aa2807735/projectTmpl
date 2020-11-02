package com.project.name.repository.auth.entity;

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
@Slf4j
public class AuthUser {

    private Long userId;
    private String userName;
    private String userPassword;
    private LocalDateTime createTime;
    private Long createId;
    private LocalDateTime updateTime;
    private Long updateId;

}
