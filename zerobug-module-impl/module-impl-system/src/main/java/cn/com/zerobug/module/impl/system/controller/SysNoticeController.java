package cn.com.zerobug.module.impl.system.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.common.base.api.PageQuery;
import cn.com.zerobug.common.base.api.PageResult;
import cn.com.zerobug.common.base.dataobject.BaseDO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysNoticeDO;
import cn.com.zerobug.module.impl.system.service.ISysNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 通知公告
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/notice")
public class SysNoticeController {

    private final ISysNoticeService sysNoticeService;

    /**
     * 查询列表 分页
     *
     * @param pageQuery 分页参数
     * @return ApiResult#PageResult<SysNoticeDO>
     */
    @GetMapping("/list-page")
    public ApiResult<PageResult<SysNoticeDO>> getListPage(PageQuery<SysNoticeDO> pageQuery) {
        return ApiResult.ok(sysNoticeService.queryPage(pageQuery));
    }

    /**
     * 根据id获取信息
     *
     * @param id 数据id
     * @return SysNoticeDO
     */
    @GetMapping(value = "{id}")
    public ApiResult<SysNoticeDO> get(@PathVariable Long id) {
        return ApiResult.ok(sysNoticeService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysNoticeDO
     * @return SysNoticeDO
     */
    @PutMapping
    public ApiResult<Boolean> update(@Validated(BaseDO.UpdateGroup.class) @RequestBody SysNoticeDO sysNoticeDO) {
        return ApiResult.ok(sysNoticeService.updateById(sysNoticeDO));
    }

    /**
     * 新增
     *
     * @param sysNoticeDO
     * @return SysNoticeDO
     */
    @PostMapping
    public ApiResult<Boolean> create(@Validated(BaseDO.CreateGroup.class) @RequestBody SysNoticeDO sysNoticeDO) {
        return ApiResult.ok(sysNoticeService.save(sysNoticeDO));
    }

    /**
     * 删除
     *
     * @param id
     * @return SysNoticeDO
     */
    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.ok(sysNoticeService.removeById(id));
    }

}
