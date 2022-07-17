package cn.com.zerobug.module.impl.system.api;

import cn.com.zerobug.module.api.system.api.RoleApi;
import cn.com.zerobug.module.api.system.dto.SysRoleDTO;
import cn.com.zerobug.module.impl.system.dao.SysRoleMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import cn.com.zerobug.module.impl.system.manager.convert.SysRoleConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Service
@RequiredArgsConstructor
public class RoleApiImpl implements RoleApi {

    private final SysRoleMapper roleMapper;

    @Override
    public List<SysRoleDTO> getRoleByUserId(Long userId) {
        List<SysRoleDO> sysRoles = roleMapper.selectByUserId(userId);
        return sysRoles.stream().map(m -> SysRoleConvert.INSTANCE.convertDTO(m)).collect(Collectors.toList());
    }
}
