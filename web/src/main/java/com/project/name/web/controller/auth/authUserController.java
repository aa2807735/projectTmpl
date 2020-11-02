package com.project.name.web.controller.auth;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/authUser")
public class authUserController {

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    public String getUserById(@PathVariable Long userId){
        return "123";
    }

}
