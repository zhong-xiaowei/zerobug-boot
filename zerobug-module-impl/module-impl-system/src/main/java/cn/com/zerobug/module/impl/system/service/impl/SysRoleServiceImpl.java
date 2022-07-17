package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysRoleMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import cn.com.zerobug.module.impl.system.enums.SysRoleCodeEnum;
import cn.com.zerobug.module.impl.system.service.ISysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImplPro<SysRoleMapper, SysRoleDO> implements ISysRoleService {

    private final SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleDO> getByUserId(Long userId) {
        return sysRoleMapper.selectByUserId(userId);
    }

    @Override
    public boolean hasAnyAdmin(List<String> roleCodes) {
        return roleCodes != null && roleCodes.stream().anyMatch(code -> SysRoleCodeEnum.ADMIN.getCode().equals(code));
    }
}
