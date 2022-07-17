package cn.com.zerobug.module.impl.system.dao;

import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import cn.com.zerobug.component.orm.MapperPro;

import java.util.List;

/**
 * 角色信息表 Mapper 接口
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface SysRoleMapper extends MapperPro<SysRoleDO> {

    /**
     * 根据用户id 查询角色信息
     *
     * @param userId
     * @return
     */
    List<SysRoleDO> selectByUserId(Long userId);
}
