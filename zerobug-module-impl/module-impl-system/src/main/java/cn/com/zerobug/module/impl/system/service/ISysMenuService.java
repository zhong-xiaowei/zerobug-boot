package cn.com.zerobug.module.impl.system.service;

import cn.com.zerobug.component.orm.IServicePro;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysMenuDO;

import java.util.List;

/**
 * 菜单权限表 服务类
 *
 * @author zhongxiaowei
 * @since 2022-04-05
 */
public interface ISysMenuService extends IServicePro<SysMenuDO> {

    /**
     * 根据用户ID查询菜单路由
     *
     * @param userId
     * @return
     */
    List<SysMenuDO> getRoute(Long userId);


}
