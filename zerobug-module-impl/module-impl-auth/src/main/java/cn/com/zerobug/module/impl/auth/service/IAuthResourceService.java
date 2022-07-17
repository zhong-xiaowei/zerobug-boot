package cn.com.zerobug.module.impl.auth.service;

import cn.com.zerobug.module.impl.auth.domain.vo.SysUserInfoVO;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
public interface IAuthResourceService {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    SysUserInfoVO getUserInfo(Long userId);

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    Set<String> getUserPermission(Long userId);
}
