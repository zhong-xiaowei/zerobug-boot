package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysDeptDO;
import cn.com.zerobug.module.impl.system.service.ISysDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/dept")
public class SysDeptController {

    private final ISysDeptService sysDeptService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysDeptDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysDeptDO>> getListPage(PageQuery<SysDeptDO> pageQuery) {
        return ApiResult.ok(sysDeptService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysDeptDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysDeptDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysDeptService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysDeptDO
     * @return SysDeptDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysDeptDO sysDeptDO) {
        return ApiResult.ok(sysDeptService.updateById(sysDeptDO));
    }

    /**
     * 新增
     *
     * @param sysDeptDO
     * @return SysDeptDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysDeptDO sysDeptDO) {
        return ApiResult.ok(sysDeptService.save(sysDeptDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysDeptDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysDeptService.removeById(id));
    }

}
