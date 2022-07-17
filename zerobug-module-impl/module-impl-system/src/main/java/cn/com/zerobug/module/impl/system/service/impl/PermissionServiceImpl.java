package cn.com.zerobug.module.impl.system.service.impl;

import cn.com.zerobug.module.impl.system.service.IPermissionService;
import cn.com.zerobug.module.impl.system.dao.SysMenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {

    private final SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> getPermissionsByUserId(Long userId) {
        return sysMenuMapper.selectPermissionByUserId(userId);
    }
}
