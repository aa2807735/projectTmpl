package com.project.name.service.auth;


import com.baomidou.mybatisplus.extension.service.IService;
import com.project.name.page.PageParam;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.service.auth.dto.AuthUserListDTO;
import com.project.name.service.page.dto.PageDTO;


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
    PageDTO<AuthUserListDTO> pageList(PageParam<AuthUserListDTO> pageParam);
}
