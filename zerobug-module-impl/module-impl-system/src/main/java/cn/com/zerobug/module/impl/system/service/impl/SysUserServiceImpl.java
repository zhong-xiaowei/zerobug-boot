package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.component.orm.ServiceImplPro;
import cn.com.zerobug.module.impl.system.dao.SysUserMapper;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;
import cn.com.zerobug.module.impl.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务实现类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImplPro<SysUserMapper, SysUserDO> implements ISysUserService {

    private final SysUserMapper userMapper;

    @Override
    public SysUserDO getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


}
