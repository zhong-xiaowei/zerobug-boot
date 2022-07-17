package cn.com.zerobug.module.impl.auth.service.impl;

import cn.com.zerobug.module.api.system.api.UserApi;
import cn.com.zerobug.module.api.system.dto.SysUserDTO;
import cn.com.zerobug.module.impl.auth.manager.convert.SysUserConvert;
import cn.com.zerobug.module.impl.auth.service.IAuthResourceService;
import cn.com.zerobug.module.api.system.api.PermissionApi;
import cn.com.zerobug.module.api.system.api.RoleApi;
import cn.com.zerobug.module.impl.auth.domain.vo.SysUserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Service
@RequiredArgsConstructor
public class AuthResourceServiceImpl implements IAuthResourceService {

    private final UserApi       userApi;
    private final RoleApi       roleApi;
    private final PermissionApi permissionApi;

    @Override
    public SysUserInfoVO getUserInfo(Long userId) {
        SysUserDTO    userDTO = userApi.getSysUserById(userId);
        SysUserInfoVO result  = SysUserConvert.INSTANCE.convertInfoVO(userDTO);
        result.setRoles(roleApi.getRoleByUserId(userId));
        return result;
    }

    @Override
    public Set<String> getUserPermission(Long userId) {
        return permissionApi.getPermission(userId);
    }
}
