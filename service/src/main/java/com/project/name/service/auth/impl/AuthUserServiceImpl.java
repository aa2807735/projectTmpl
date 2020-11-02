package com.project.name.service.auth.impl;

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
        if (true){
            throw new LogicException(ErrorCode.SERVER_BUSY_CODE);
        }
        AuthUserListDTO queryParam = pageParam.getQueryParam();
        Page<AuthUserListDTO> page =  pageParam.getPage();
        authUserMapper.pageGetAllUser(page,queryParam);
        return PageDTO.getResult(page);
    }


}
