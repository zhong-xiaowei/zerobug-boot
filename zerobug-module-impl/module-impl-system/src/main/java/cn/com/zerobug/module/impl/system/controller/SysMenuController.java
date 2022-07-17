package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.module.impl.system.service.ISysMenuService;
import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.common.base.dataobject.TreeNodeDO;
import cn.com.zerobug.component.security.utils.SecurityContextUtils;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysMenuDO;
import cn.com.zerobug.module.impl.system.domain.vo.res.RouterTreeResVO;
import cn.com.zerobug.module.impl.system.manager.convert.SysMenuConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/menu")
public class SysMenuController {

    private final ISysMenuService sysMenuService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysMenuDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysMenuDO>> getListPage(PageQuery<SysMenuDO> pageQuery) {
        return ApiResult.ok(sysMenuService.queryPage(pageQuery));
    }

    /**
     * 获取路由树
     *
     * @return ApiResult<SysMenuTreeVo>
     */
    @GetMapping("/routers")
    public ApiResult<List<RouterTreeResVO>> getMenuTree() {
        List<SysMenuDO>       list = sysMenuService.getRoute(SecurityContextUtils.getLoginUserId());
        List<RouterTreeResVO> vo   = SysMenuConvert.INSTANCE.convertRoutingTreeVOList(list);
        return ApiResult.ok(TreeNodeDO.buildTree(vo)
                .stream()
                .sorted(Comparator.comparing(o -> o.getMeta().getOrderNo()))
                .collect(Collectors.toList()));
    }

    /**
     * 构建树
     *
     * @param treeNodes 树节点
     * @param parentId  父节点id
     * @return List<TreeNodeDO>
     */
    private List<RouterTreeResVO> buildTree(List<RouterTreeResVO> treeNodes, Long parentId) {
        List<RouterTreeResVO> trees = new ArrayList<>();
        for (RouterTreeResVO treeNode : treeNodes) {
            if (treeNode.getParentId().equals(parentId)) {
                treeNode.setChildren(buildTree(treeNodes, treeNode.getId()));
                trees.add(treeNode);
            }
        }
        return trees;
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysMenuDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysMenuDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysMenuService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysMenuDO
     * @return SysMenuDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysMenuDO sysMenuDO) {
        return ApiResult.ok(sysMenuService.updateById(sysMenuDO));
    }

    /**
     * 新增
     *
     * @param sysMenuDO
     * @return SysMenuDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysMenuDO sysMenuDO) {
        return ApiResult.ok(sysMenuService.save(sysMenuDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysMenuDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysMenuService.removeById(id));
    }

}
