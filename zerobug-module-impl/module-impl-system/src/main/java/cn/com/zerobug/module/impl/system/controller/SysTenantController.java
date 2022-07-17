package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysTenantDO;
import cn.com.zerobug.module.impl.system.service.ISysTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 租户管理
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/tenant")
public class SysTenantController {

    private final ISysTenantService sysTenantService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysTenantDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysTenantDO>> getListPage(PageQuery<SysTenantDO> pageQuery) {
        return ApiResult.ok(sysTenantService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysTenantDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysTenantDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysTenantService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysTenantDO
     * @return SysTenantDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysTenantDO sysTenantDO) {
        return ApiResult.ok(sysTenantService.updateById(sysTenantDO));
    }

    /**
     * 新增
     *
     * @param sysTenantDO
     * @return SysTenantDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysTenantDO sysTenantDO) {
        return ApiResult.ok(sysTenantService.save(sysTenantDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysTenantDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysTenantService.removeById(id));
    }

}
