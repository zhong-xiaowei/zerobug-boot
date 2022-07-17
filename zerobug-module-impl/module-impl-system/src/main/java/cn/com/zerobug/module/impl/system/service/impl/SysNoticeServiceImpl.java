package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysNoticeMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysNoticeDO;
import cn.com.zerobug.module.impl.system.service.ISysNoticeService;
import org.springframework.stereotype.Service;

/**
 * 通知公告表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
public class SysNoticeServiceImpl extends ServiceImplPro<SysNoticeMapper, SysNoticeDO> implements ISysNoticeService {

}
