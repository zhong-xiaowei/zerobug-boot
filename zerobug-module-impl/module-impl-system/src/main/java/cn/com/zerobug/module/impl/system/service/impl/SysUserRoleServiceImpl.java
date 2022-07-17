package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysUserRoleMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserRoleDO;
import cn.com.zerobug.module.impl.system.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户和角色关联表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImplPro<SysUserRoleMapper, SysUserRoleDO> implements ISysUserRoleService {

}
