package cn.com.zerobug.module.impl.system.manager.convert;

import cn.com.zerobug.module.impl.system.domain.dataobject.SysMenuDO;
import cn.com.zerobug.module.impl.system.domain.vo.RouteMetaVO;
import cn.com.zerobug.module.impl.system.domain.vo.RouterTreeVO;
import cn.com.zerobug.module.impl.system.enums.SysMenuTypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static cn.com.zerobug.module.impl.system.enums.SysMenuTypeEnum.of;

/**
 * @author zhongxiaowei
 * @date 2022/4/9
 */
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);


    /**
     * 转换TreeVO
     *
     * @param sysMenu
     * @return
     */
    @Mapping(target = "children", ignore = true)
    RouterTreeVO convertRoutingTreeVO(SysMenuDO sysMenu);

    /**
     * 转换路由树 VO List
     *
     * @param sysMenuList
     * @return
     */
    default List<RouterTreeVO> convertRoutingTreeVOList(List<SysMenuDO> sysMenuList) {
        return Optional.ofNullable(sysMenuList).orElse(new ArrayList<>())
                .stream().map(item -> {
                    RouterTreeVO routerTreeVO = convertRoutingTreeVO(item);
                    routerTreeVO.setMeta(convertRouteMetaVO(item));
                    return routerTreeVO;
                }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    /**
     * 转换RouteMetaVO
     *
     * @param sysMenuDO
     * @return
     */
    default RouteMetaVO convertRouteMetaVO(SysMenuDO sysMenuDO) {
        RouteMetaVO routeMetaVO = new RouteMetaVO();
        routeMetaVO.setOrderNo(sysMenuDO.getSort());
        routeMetaVO.setTitle(sysMenuDO.getName());
        routeMetaVO.setIcon(sysMenuDO.getIcon());
        SysMenuTypeEnum typeEnum = of(sysMenuDO.getMenuType());
        if (typeEnum != null && typeEnum.isMenu()) {
            if (sysMenuDO.getIsCache() == 1) {
                routeMetaVO.setIgnoreKeepAlive(true);
            }
            if (sysMenuDO.getIsLink() == 1) {
                routeMetaVO.setIsLink(true);
                routeMetaVO.setFrameSrc(sysMenuDO.getPath());
            }
            if (sysMenuDO.getIsShow() == 0) {
                routeMetaVO.setHideMenu(true);
            }
        }
        return routeMetaVO;
    }

}
