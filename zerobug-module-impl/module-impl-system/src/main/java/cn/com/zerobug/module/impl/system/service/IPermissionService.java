package cn.com.zerobug.module.impl.system.service;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
public interface IPermissionService {

    /**
     * 根据用户id查询权限
     *
     * @param userId
     * @return
     */
    Set<String> getPermissionsByUserId(Long userId);

}
