package cn.com.zerobug.module.impl.system.service;

import cn.com.zerobug.component.orm.IServicePro;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;

/**
 * 用户信息表 服务类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface ISysUserService extends IServicePro<SysUserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUserDO getByUsername(String username);
}
