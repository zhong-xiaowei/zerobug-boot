package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.module.impl.system.service.ISysDictDataService;
import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysDictDataMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysDictDataDO;
import org.springframework.stereotype.Service;

/**
 * 字典数据表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysDictDataServiceImpl extends ServiceImplPro<SysDictDataMapper, SysDictDataDO> implements ISysDictDataService {

}
