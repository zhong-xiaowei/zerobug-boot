package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysLogOperateDO;
import cn.com.zerobug.module.impl.system.service.ISysLogOperateService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 操作日志记录
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/log-operate")
public class SysLogOperateController {

    private final ISysLogOperateService sysLogOperateService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysLogOperateDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysLogOperateDO>> getListPage(PageQuery<SysLogOperateDO> pageQuery) {
        return ApiResult.ok(sysLogOperateService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysLogOperateDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysLogOperateDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysLogOperateService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysLogOperateDO
     * @return SysLogOperateDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysLogOperateDO sysLogOperateDO) {
        return ApiResult.ok(sysLogOperateService.updateById(sysLogOperateDO));
    }

    /**
     * 新增
     *
     * @param sysLogOperateDO
     * @return SysLogOperateDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysLogOperateDO sysLogOperateDO) {
        return ApiResult.ok(sysLogOperateService.save(sysLogOperateDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysLogOperateDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysLogOperateService.removeById(id));
    }

}
