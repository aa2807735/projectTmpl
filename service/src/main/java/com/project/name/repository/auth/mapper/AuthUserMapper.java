package com.project.name.repository.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.dto.AuthUserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    /**
     * 根據用戶ID獲取用戶
     * @param userId 用戶ID
     * @return 結果
     */
    AuthUserDTO getById(@Param("userId") Long userId);


    /**
     * 分页获取所有的用户
     * @param page 分页
     * @return 结果
     */
    IPage<AuthUser> pageGetAllUser(IPage<AuthUser> page);


}
