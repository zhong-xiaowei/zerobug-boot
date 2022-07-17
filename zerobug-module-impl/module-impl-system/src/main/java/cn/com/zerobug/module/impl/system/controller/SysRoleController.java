package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.module.impl.system.service.ISysRoleService;
import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 角色信息
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/role")
public class SysRoleController {

    private final ISysRoleService sysRoleService;

    /**
     * 查询列 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysRoleDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysRoleDO>> getListPage(PageQuery<SysRoleDO> pageQuery) {
        return ApiResult.ok(sysRoleService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysRoleDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysRoleDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysRoleService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysRoleDO
     * @return SysRoleDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysRoleDO sysRoleDO) {
        return ApiResult.ok(sysRoleService.updateById(sysRoleDO));
    }

    /**
     * 新增
     *
     * @param sysRoleDO
     * @return SysRoleDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysRoleDO sysRoleDO) {
        return ApiResult.ok(sysRoleService.save(sysRoleDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysRoleDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysRoleService.removeById(id));
    }

}
