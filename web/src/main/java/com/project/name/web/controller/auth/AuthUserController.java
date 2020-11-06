package com.project.name.web.controller.auth;


import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.IAuthUserService;
import com.project.name.service.auth.dto.AuthUserDTO;
import com.project.name.service.auth.dto.AuthUserListDTO;
import com.project.name.service.page.dto.PageDTO;
import com.project.name.web.ResultView;
import com.project.name.web.vo.auth.request.page.AuthUserPageParam;
import com.project.name.web.vo.auth.request.param.add.AuthUserAddParam;
import com.project.name.web.vo.auth.request.param.update.AuthUserUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth/authUser")
@Api(tags = "用户控制器")
public class AuthUserController {

    @Autowired
    private IAuthUserService authUserService;

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    @ApiOperation(value = "通过ID获取用户信息")
    public ResultView<AuthUserDTO> getUserById(@PathVariable @RequestParam(value = "id")  @ApiParam(value = "用户ID") Long userId) {
        return ResultView.ok(authUserService.getById(userId));
    }

    @GetMapping(value = "page")
    @PreAuthorize("hasAuthority('auth:authUser:view')")
    @ApiOperation(value = "分页获取用户信息")
    public ResultView<PageDTO<AuthUserListDTO>> pageList(@RequestBody @ApiParam(value = "分页参数") AuthUserPageParam pageParam) {
        return ResultView.ok(authUserService.pageList(pageParam));
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "用户登陆")
    public ResultView<String> login(@RequestBody @ApiParam(value = "登陆用户") AuthUser authUser) {
        String login = authUserService.login(authUser);
        return ResultView.ok(login);
    }


    @DeleteMapping(value = "delete")
    @ApiOperation("根据id删除")
    public ResultView<String> delete(@RequestParam("id") @ApiParam("主键ID") Long id){
        return ResultView.ok();
    }


    @PutMapping(value = "update")
    @ApiOperation("修改方法")
    public ResultView<String> update(@RequestBody @ApiParam("修改实体") AuthUserUpdateParam param ){
        return ResultView.ok();
    }

    @PostMapping(value = "add")
    @ApiOperation("修改方法")
    public ResultView<String> add(@RequestBody @ApiParam("添加实体") AuthUserAddParam param ){
        return ResultView.ok();
    }

}
