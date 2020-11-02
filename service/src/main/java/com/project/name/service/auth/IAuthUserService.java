package com.project.name.service.auth;


import com.baomidou.mybatisplus.extension.service.IService;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.dto.AuthUserDTO;

import java.util.List;

public interface IAuthUserService  extends IService<AuthUser> {


    /**
     * 根据ID获取用户
     * @param userId
     * @return
     */
    AuthUserDTO getById(Long userId);


    /**
     * 分页获取所有用户
     * @return
     */
    List<AuthUserDTO> pageList();
}
