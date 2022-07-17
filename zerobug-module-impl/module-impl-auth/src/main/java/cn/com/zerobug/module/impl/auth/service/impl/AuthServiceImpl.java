package cn.com.zerobug.module.impl.auth.service.impl;

import cn.com.zerobug.module.impl.auth.domain.param.LoginActionParam;
import cn.com.zerobug.module.impl.auth.framework.security.SimpleUserdetailsServiceImpl;
import cn.com.zerobug.module.impl.auth.service.IAuthService;
import cn.com.zerobug.component.security.auth.MultipleLoginAuthenticationToken;
import cn.com.zerobug.component.security.model.AuthenticatedUser;
import cn.com.zerobug.component.security.token.AccessToken;
import cn.com.zerobug.component.security.token.provider.SecurityTokenProvider;
import cn.com.zerobug.module.impl.auth.domain.vo.LoginResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author zhongxiaowei
 * @date 2022/3/13
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final SecurityTokenProvider securityTokenProvider;

    @Override
    public LoginResultVO generateLoginResultVO(AuthenticatedUser authenticatedUser) {
        AccessToken   accessToken   = securityTokenProvider.createAccessToken(authenticatedUser);
        LoginResultVO loginResultVO = new LoginResultVO();
        loginResultVO.setAccessToken(accessToken.getValue());
        loginResultVO.setRefreshToken(accessToken.getRefreshToken().getValue());
        loginResultVO.setExpiresIn(accessToken.getExpiration().getTime());
        return loginResultVO;
    }

    @Override
    public AuthenticatedUser loginByUsernamePassword(LoginActionParam loginActionParam) {
        MultipleLoginAuthenticationToken authenticationToken =
                new MultipleLoginAuthenticationToken(
                        loginActionParam.getUsername(),
                        loginActionParam.getPassword(),
                        () -> SimpleUserdetailsServiceImpl.class
                );
        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            log.error("登录失败，用户名或密码错误", e);
        } catch (DisabledException e) {
            log.error("登录失败，用户已被禁用", e);
        } catch (AuthenticationException e) {
            log.error("登录失败，未知错误", e);
        }
        return (AuthenticatedUser) authenticate.getPrincipal();
    }

}
