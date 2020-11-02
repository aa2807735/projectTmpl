package com.project.name.service.auth.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.name.error.ErrorCode;
import com.project.name.exception.LogicException;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.repository.auth.mapper.AuthUserMapper;
import com.project.name.service.auth.IAuthUserService;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.utils.BeanCopierUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUserDTO getById(Long userId) {
        return authUserMapper.getById(userId);
    }

    @Override
    public List<AuthUserDTO> pageList() {


        Page<AuthUser> page = new Page<>(1,10);
        IPage<AuthUser> authUserIPage = authUserMapper.pageGetAllUser(page);
        //当前页数
        System.out.println(authUserIPage.getCurrent());
        //所有记录数
        System.out.println(authUserIPage.getTotal());
        List<AuthUser> records = authUserIPage.getRecords();
        if (true){
            throw new LogicException(ErrorCode.FAIL_CODE);
        }

        return BeanCopierUtils.copyList(records, AuthUserDTO.class);
    }


}
