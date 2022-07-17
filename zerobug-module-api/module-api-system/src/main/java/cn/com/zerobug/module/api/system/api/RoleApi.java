package cn.com.zerobug.module.api.system.api;

import cn.com.zerobug.module.api.system.dto.SysRoleDTO;

import java.util.List;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
public interface RoleApi {

    /**
     * 获取角色根据用户id
     *
     * @param userId
     * @return
     */
    List<SysRoleDTO> getRoleByUserId(Long userId);

}
