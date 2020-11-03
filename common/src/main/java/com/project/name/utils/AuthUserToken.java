package com.project.name.utils;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthUserToken {
    private Long userId;
    private String userName;
    private String primes;
    private String role;
    private LocalDateTime createTime;
}
