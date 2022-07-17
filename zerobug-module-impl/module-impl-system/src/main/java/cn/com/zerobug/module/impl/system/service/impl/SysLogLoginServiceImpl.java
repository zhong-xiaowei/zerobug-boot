package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysLogLoginMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysLogLoginDO;
import cn.com.zerobug.module.impl.system.service.ISysLogLoginService;
import org.springframework.stereotype.Service;

/**
 * 系统访问记录 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysLogLoginServiceImpl extends ServiceImplPro<SysLogLoginMapper, SysLogLoginDO> implements ISysLogLoginService {

}
