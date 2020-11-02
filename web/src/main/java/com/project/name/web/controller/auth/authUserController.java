package com.project.name.web.controller.auth;


import com.project.name.page.PageParam;
import com.project.name.service.auth.IAuthUserService;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.service.auth.dto.AuthUserListDTO;
import com.project.name.service.page.dto.PageDTO;
import com.project.name.web.ResultView;
import com.project.name.web.vo.auth.request.page.AuthUserPageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/auth/authUser")
public class authUserController {

    @Autowired
    private IAuthUserService authUserService;

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    public ResultView<AuthUserDTO> getUserById(@PathVariable Long userId){
        return ResultView.ok( authUserService.getById(userId));
    }

    @GetMapping(value = "page")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    public ResultView<PageDTO<AuthUserListDTO>>  pageList(AuthUserPageParam pageParam){
        return ResultView.ok(authUserService.pageList(pageParam));
    }

}
