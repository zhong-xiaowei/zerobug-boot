package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.module.impl.system.service.ISysRoleService;
import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;
import cn.com.zerobug.module.impl.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/user")
public class SysUserController {

    private final ISysUserService sysUserService;
    private final ISysRoleService sysRoleService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysUserDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysUserDO>> getListPage(PageQuery<SysUserDO> pageQuery) {
        return ApiResult.ok(sysUserService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysUserDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysUserDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysUserService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysUserDO
     * @return SysUserDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysUserDO sysUserDO) {
        return ApiResult.ok(sysUserService.updateById(sysUserDO));
    }

    /**
     * 新增
     *
     * @param sysUserDO
     * @return SysUserDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysUserDO sysUserDO) {
        return ApiResult.ok(sysUserService.save(sysUserDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysUserDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysUserService.removeById(id));
    }

}
