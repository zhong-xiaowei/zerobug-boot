package cn.com.zerobug.module.impl.system.dao;

import cn.com.zerobug.component.orm.MapperPro;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 用户信息表 Mapper 接口
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface SysUserMapper extends MapperPro<SysUserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    default SysUserDO selectByUsername(String username) {
        return selectOne(
                Wrappers.<SysUserDO>lambdaQuery()
                        .eq(SysUserDO::getUsername, username)
        );
    }

}
