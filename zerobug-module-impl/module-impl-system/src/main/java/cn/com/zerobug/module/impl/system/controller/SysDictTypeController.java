package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysDictTypeDO;
import cn.com.zerobug.module.impl.system.service.ISysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 字典类型
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/dict-type")
public class SysDictTypeController {

    private final ISysDictTypeService sysDictTypeService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysDictTypeDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysDictTypeDO>> getListPage(PageQuery<SysDictTypeDO> pageQuery) {
        return ApiResult.ok(sysDictTypeService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysDictTypeDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysDictTypeDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysDictTypeService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysDictTypeDO
     * @return SysDictTypeDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysDictTypeDO sysDictTypeDO) {
        return ApiResult.ok(sysDictTypeService.updateById(sysDictTypeDO));
    }

    /**
     * 新增
     *
     * @param sysDictTypeDO
     * @return SysDictTypeDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysDictTypeDO sysDictTypeDO) {
        return ApiResult.ok(sysDictTypeService.save(sysDictTypeDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysDictTypeDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysDictTypeService.removeById(id));
    }

}
