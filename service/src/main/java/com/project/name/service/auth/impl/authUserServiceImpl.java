package com.project.name.service.auth.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.repository.auth.mapper.AuthUserMapper;
import com.project.name.service.auth.IAuthUserService;
import org.springframework.stereotype.Service;


@Service
public class authUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {


}
