package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.module.impl.system.service.ISysMenuService;
import cn.com.zerobug.module.impl.system.service.ISysRoleService;
import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysMenuMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysMenuDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImplPro<SysMenuMapper, SysMenuDO> implements ISysMenuService {

    private final ISysRoleService roleService;

    @Override
    public List<SysMenuDO> getRoute(Long userId) {
        List<String> roleCodes = roleService.getByUserId(userId)
                .stream().map(SysRoleDO::getCode).collect(Collectors.toList());
        List<SysMenuDO> menus;
        if (roleService.hasAnyAdmin(roleCodes)) {
            menus = list();
        } else {
            menus = baseMapper.selectByUserId(userId);
        }
        return menus.stream()
                .filter(sysMenuDO -> sysMenuDO.getMenuType() == 1 || sysMenuDO.getMenuType() == 2)
                .collect(Collectors.toList());
    }
}
