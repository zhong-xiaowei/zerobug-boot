package cn.com.zerobug.module.api.system.api;

import cn.com.zerobug.module.api.system.dto.SysUserDTO;

/**
 * @author zhongxiaowei
 * @date 2022/3/18
 */
public interface UserApi {

    /**
     * 通过用户id 查询用户
     *
     * @param id
     * @return
     */
    SysUserDTO getSysUserById(Long id);

    /**
     * 通过用户名 查询用户
     *
     * @param username
     * @return
     */
    SysUserDTO getSysUserByUsername(String username);

}
