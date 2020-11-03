package com.project.name.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.name.error.ErrorCode;
import com.project.name.exception.LogicException;
import com.project.name.page.PageParam;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.repository.auth.mapper.AuthUserMapper;
import com.project.name.service.auth.IAuthUserService;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.service.auth.dto.AuthUserListDTO;
import com.project.name.service.page.dto.PageDTO;
import com.project.name.utils.JwtUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUserDTO getById(Long userId) {
        return authUserMapper.getById(userId);
    }

    @Override
    public PageDTO<AuthUserListDTO> pageList(PageParam<AuthUserListDTO> pageParam) {
        AuthUserListDTO queryParam = pageParam.getQueryParam();
        Page<AuthUserListDTO> page =  pageParam.getPage();
        authUserMapper.pageGetAllUser(page,queryParam);
        return PageDTO.getResult(page);
    }

    @Override
    public String login(AuthUser authUser) {

        AuthUser getAuthUser = this.getOne(
                new QueryWrapper<AuthUser>()
                        .lambda()
                        .eq(AuthUser::getUserName, authUser.getUserName())
                        .eq(AuthUser::getUserPassword, authUser.getUserPassword())
        );
        if (getAuthUser == null){
            throw new LogicException(ErrorCode.LOGIN_INFO_ERROR);
        }

        JwtUtils.generateJsonWebToken();


        return false;
    }


}
