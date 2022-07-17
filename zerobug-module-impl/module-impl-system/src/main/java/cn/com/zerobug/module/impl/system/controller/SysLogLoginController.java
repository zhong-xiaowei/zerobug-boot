package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysLogLoginDO;
import cn.com.zerobug.module.impl.system.service.ISysLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统访问记录
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/log-login")
public class SysLogLoginController {

    private final ISysLogLoginService sysLogLoginService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysLogLoginDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysLogLoginDO>> getListPage(PageQuery<SysLogLoginDO> pageQuery) {
        return ApiResult.ok(sysLogLoginService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysLogLoginDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysLogLoginDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysLogLoginService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysLogLoginDO
     * @return SysLogLoginDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysLogLoginDO sysLogLoginDO) {
        return ApiResult.ok(sysLogLoginService.updateById(sysLogLoginDO));
    }

    /**
     * 新增
     *
     * @param sysLogLoginDO
     * @return SysLogLoginDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysLogLoginDO sysLogLoginDO) {
        return ApiResult.ok(sysLogLoginService.save(sysLogLoginDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysLogLoginDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysLogLoginService.removeById(id));
    }

}
