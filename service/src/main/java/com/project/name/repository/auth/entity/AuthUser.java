package com.project.name.repository.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.ID_WORKER)       //雪花算法
    private String userName;
    private String userPassword;
    private LocalDateTime createTime;
    private Long createId;
    private LocalDateTime updateTime;
    private Long updateId;
}
