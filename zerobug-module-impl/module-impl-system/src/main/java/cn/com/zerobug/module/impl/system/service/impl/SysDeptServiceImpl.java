package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.module.impl.system.service.ISysDeptService;
import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysDeptMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysDeptDO;
import org.springframework.stereotype.Service;

/**
 * 部门表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysDeptServiceImpl extends ServiceImplPro<SysDeptMapper, SysDeptDO> implements ISysDeptService {

}
