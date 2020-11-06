package com.project.name.web.vo.auth.request.page;

import com.project.name.page.PageParam;
import com.project.name.service.auth.dto.AuthUserListDTO;
import io.swagger.annotations.ApiModel;


@ApiModel("用户分页参数实体")
public class AuthUserPageParam extends PageParam<AuthUserListDTO> {
}
