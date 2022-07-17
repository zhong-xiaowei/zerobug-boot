package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.module.impl.system.service.ISysDictDataService;
import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysDictDataDO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 字典数据
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/dict-data")
public class SysDictDataController {

    private final ISysDictDataService sysDictDataService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysDictDataDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysDictDataDO>> getListPage(PageQuery<SysDictDataDO> pageQuery) {
        return ApiResult.ok(sysDictDataService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysDictDataDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysDictDataDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysDictDataService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysDictDataDO
     * @return SysDictDataDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysDictDataDO sysDictDataDO) {
        return ApiResult.ok(sysDictDataService.updateById(sysDictDataDO));
    }

    /**
     * 新增
     *
     * @param sysDictDataDO
     * @return SysDictDataDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysDictDataDO sysDictDataDO) {
        return ApiResult.ok(sysDictDataService.save(sysDictDataDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysDictDataDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysDictDataService.removeById(id));
    }

}
