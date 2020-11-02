package com.project.name.web.controller.auth;


import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.IAuthUserService;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.utils.BeanCopierUtils;
import com.project.name.web.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/auth/authUser")
public class authUserController {


    @Autowired
    private IAuthUserService authUserService;

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    public ResultView<AuthUserDTO> getUserById(@PathVariable Long userId){
        AuthUser authUser = authUserService.selectById(userId);
        AuthUserDTO authUserDTO = BeanCopierUtils.copy(authUser, AuthUserDTO.class);
        return ResultView.ok(authUserDTO);
    }

}
