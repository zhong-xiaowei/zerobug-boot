package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysTenantMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysTenantDO;
import cn.com.zerobug.module.impl.system.service.ISysTenantService;
import org.springframework.stereotype.Service;

/**
 * 租户表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysTenantServiceImpl extends ServiceImplPro<SysTenantMapper, SysTenantDO> implements ISysTenantService {

}
