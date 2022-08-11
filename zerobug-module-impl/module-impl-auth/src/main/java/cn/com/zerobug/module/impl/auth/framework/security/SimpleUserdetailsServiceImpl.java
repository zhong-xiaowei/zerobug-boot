package cn.com.zerobug.module.impl.auth.framework.security;

import cn.com.zerobug.common.enums.GeneralStatusEnum;
import cn.com.zerobug.module.api.system.api.UserApi;
import cn.com.zerobug.module.api.system.dto.SysRoleDTO;
import cn.com.zerobug.module.api.system.dto.SysUserDTO;
import cn.hutool.core.lang.Assert;
import cn.com.zerobug.component.ss.model.AuthenticatedUser;
import cn.com.zerobug.module.api.system.api.RoleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author zhongxiaowei
 * @date 2022/3/20
 */
@Component
@RequiredArgsConstructor
public class SimpleUserdetailsServiceImpl implements UserDetailsService {

    private final UserApi userApi;
    private final RoleApi roleApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buildUser(checkUser(userApi.getSysUserByUsername(username)));
    }

    /**
     * 检查用户是否存在，状态是否异常
     *
     * @param sysUserDTO 用户信息
     * @return 用户信息
     */
    private SysUserDTO checkUser(SysUserDTO sysUserDTO) {
        Assert.notNull(sysUserDTO, () -> new UsernameNotFoundException("用户不存在"));
        Assert.isTrue(GeneralStatusEnum.ENABLE.ordinal() == sysUserDTO.getStatus(), () -> new DisabledException("用户已被禁用"));
        return sysUserDTO;
    }

    /**
     * 构建认证用户
     *
     * @param sysUserDTO
     * @return
     */
    private AuthenticatedUser buildUser(SysUserDTO sysUserDTO) {
        return AuthenticatedUser.builder()
                .id(sysUserDTO.getId())
                .username(sysUserDTO.getUsername())
                .deptId(sysUserDTO.getDeptId())
                .password(sysUserDTO.getPassword())
                .roleIds(roleApi.getRoleByUserId(sysUserDTO.getId()).stream().map(SysRoleDTO::getId).collect(Collectors.toSet()))
                .build();
    }

}
