package cn.com.zerobug.module.impl.system.domain.vo.res;

import cn.com.zerobug.common.base.dataobject.TreeNodeDO;
import lombok.Data;

/**
 * @author zhongxiaowei
 * @date 2022/3/25
 */
@Data
public class RouterTreeResVO extends TreeNodeDO<RouterTreeResVO> {

    private static final long serialVersionUID = -5058326489560862193L;

    /**
     * 菜单名
     */
    private String      name;
    /**
     * 路由地址
     */
    private String      path;
    /**
     * 组件路径
     */
    private String      component;
    /**
     * 重定向
     */
    private String      redirect;
    /**
     * 是否区分大小写
     */
    private Boolean        caseSensitive;
    /**
     * 路由元数据
     */
    private RouteMetaResVO meta;

}
