package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysLogOperateMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysLogOperateDO;
import cn.com.zerobug.module.impl.system.service.ISysLogOperateService;
import org.springframework.stereotype.Service;

/**
 * 操作日志记录 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysLogOperateServiceImpl extends ServiceImplPro<SysLogOperateMapper, SysLogOperateDO> implements ISysLogOperateService {

}
