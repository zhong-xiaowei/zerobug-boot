package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysRoleMenuMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleMenuDO;
import cn.com.zerobug.module.impl.system.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色和菜单关联表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImplPro<SysRoleMenuMapper, SysRoleMenuDO> implements ISysRoleMenuService {

}
