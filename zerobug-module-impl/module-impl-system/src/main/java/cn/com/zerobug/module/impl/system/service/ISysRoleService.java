package cn.com.zerobug.module.impl.system.service;

import cn.com.zerobug.component.orm.IServicePro;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;

import java.util.List;

/**
 * 角色信息表 服务类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface ISysRoleService extends IServicePro<SysRoleDO> {

    /**
     * 根据用户id 获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRoleDO> getByUserId(Long userId);

    /**
     * 是否拥有管理员角色
     *
     * @param roleCodes
     * @return
     */
    boolean hasAnyAdmin(List<String> roleCodes);
}
