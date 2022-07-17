package cn.com.zerobug.module.impl.system.api;

import cn.com.zerobug.module.api.system.api.UserApi;
import cn.com.zerobug.module.api.system.dto.SysUserDTO;
import cn.com.zerobug.module.impl.system.manager.convert.SysUserConvert;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;
import cn.com.zerobug.module.impl.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhongxiaowei
 * @date 2022/3/18
 */
@Service
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final ISysUserService sysUserService;

    @Override
    public SysUserDTO getSysUserById(Long id) {
        SysUserDO sysUserDO = sysUserService.getById(id);
        return SysUserConvert.INSTANCE.convertDTO(sysUserDO);
    }

    @Override
    public SysUserDTO getSysUserByUsername(String username) {
        SysUserDTO userDTO = Optional.ofNullable(sysUserService.getByUsername(username))
                .map(m -> SysUserConvert.INSTANCE.convertDTO(m)).orElse(null);
        return userDTO;
    }
}
