package cn.com.zerobug.module.impl.system.domain.vo.res;

import lombok.Data;

/**
 * @author zhongxiaowei
 * @date 2022/4/9
 */
@Data
public class RouteMetaResVO {

    /**
     * 标签
     */
    private String  title;
    /**
     * 排序
     */
    private Integer orderNo;
    /**
     * 是否忽略KeepAlive缓存
     */
    private Boolean ignoreKeepAlive;
    /**
     * 是否固定
     */
    private Boolean affix;
    /**
     * 图标
     */
    private String  icon;
    /**
     * 内嵌frame地址
     */
    private String  frameSrc;
    /**
     * 当前页面的切换图名
     */
    private String  transitionName;
    /**
     * 隐藏子菜单
     */
    private Boolean hideChildrenInMenu;
    /**
     * 路由是否带参
     */
    private Boolean carryParam;
    /**
     * 当前激活的菜单
     */
    private String  currentActiveMenu;
    /**
     * 当前路由 是否隐藏 Tab
     */
    private Boolean hideTab;
    /**
     * 当前路由 是否隐藏 菜单显示
     */
    private Boolean hideMenu;
    /**
     * 是否链接
     */
    private Boolean isLink;

}
