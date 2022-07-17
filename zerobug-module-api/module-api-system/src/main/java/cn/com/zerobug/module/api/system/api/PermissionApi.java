package cn.com.zerobug.module.api.system.api;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
public interface PermissionApi {

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    Set<String> getPermission(Long userId);

}
