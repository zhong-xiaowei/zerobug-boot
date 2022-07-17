package cn.com.zerobug.module.impl.system.api;

import cn.com.zerobug.module.api.system.api.PermissionApi;
import cn.com.zerobug.module.impl.system.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Service
@RequiredArgsConstructor
public class PermissionApiImpl implements PermissionApi {

    private final IPermissionService permissionService;

    @Override
    public Set<String> getPermission(Long userId) {
        return permissionService.getPermissionsByUserId(userId);
    }
}
