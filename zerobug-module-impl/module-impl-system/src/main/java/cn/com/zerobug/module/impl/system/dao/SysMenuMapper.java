package cn.com.zerobug.module.impl.system.dao;

import cn.com.zerobug.component.orm.MapperPro;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysMenuDO;

import java.util.List;
import java.util.Set;

/**
 * 菜单权限表 Mapper 接口
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface SysMenuMapper extends MapperPro<SysMenuDO> {

    /**
     * 查询权限资源 根据用户ID
     *
     * @param userId
     * @return
     */
    Set<String> selectPermissionByUserId(Long userId);

    /**
     * 查询查询菜单 根据用户ID
     *
     * @param userId
     * @return
     */
    List<SysMenuDO> selectByUserId(Long userId);

}
