package cn.com.zerobug.module.impl.auth.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.module.impl.auth.domain.vo.req.LoginActionReqVO;
import cn.com.zerobug.module.impl.auth.domain.vo.res.LoginResultResVO;
import cn.com.zerobug.module.impl.auth.service.IAuthService;
import cn.com.zerobug.component.security.model.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证管理
 *
 * @author zhongxiaowei
 * @date 2022/3/13
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    /**
     * 登录操作
     *
     * @param loginActionReqVO
     * @return
     */
    @PostMapping("/login")
    public ApiResult<LoginResultResVO> loginAction(@RequestBody @Validated LoginActionReqVO loginActionReqVO) {
        AuthenticatedUser authenticatedUser = authService.loginByUsernamePassword(loginActionReqVO);
        return ApiResult.ok(authService.generateLoginResultVO(authenticatedUser));
    }

}
