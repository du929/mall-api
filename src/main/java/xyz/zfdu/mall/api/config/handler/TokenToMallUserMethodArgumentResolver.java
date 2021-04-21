package xyz.zfdu.mall.api.config.handler;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import xyz.zfdu.mall.api.common.Constants;
import xyz.zfdu.mall.api.common.MallException;
import xyz.zfdu.mall.api.common.ServiceResultEnum;
import xyz.zfdu.mall.api.config.annotation.TokenToMallUser;
import xyz.zfdu.mall.api.entity.MallUser;
import xyz.zfdu.mall.api.entity.MallUserToken;
import xyz.zfdu.mall.api.mapper.MallUserMapper;
import xyz.zfdu.mall.api.mapper.MallUserTokenMapper;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zfdu
 * @description Token解析
 * @data 2021-04-21
 */
@Component
public class TokenToMallUserMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Resource
    private MallUserMapper mallUserMapper;

    @Resource
    private MallUserTokenMapper mallUserTokenMapper;
    public TokenToMallUserMethodArgumentResolver() {

    }
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TokenToMallUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToMallUser.class) != null) {
            MallUser mallUser;
            String token = webRequest.getHeader("token");
            if (null != token && !"".equals(token) && token.length() == Constants.TOKEN_LENGTH) {
                MallUserToken mallUserToken = mallUserTokenMapper.selectByToken(token);
                if (mallUserToken == null || mallUserToken.getExpireTime().getTime() <= System.currentTimeMillis()) {
                    MallException.fail(ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult());

                }
                mallUser = mallUserMapper.selectByPrimaryKey(mallUserToken.getUserId());
                if (mallUser == null) {
                    MallException.fail(ServiceResultEnum.USER_NULL_ERROR.getResult());
                }
                if (mallUser.getLockedFlag().intValue() == 1) {
                    MallException.fail(ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult());
                }
                return mallUser;
            } else {
                MallException.fail(ServiceResultEnum.NOT_LOGIN_ERROR.getResult());
            }
        }
        return null;
    }
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int len = request.getInputStream().read(buffer, i, contentLength - i);
            if (len == -1) {
                break;
            }
            i += len;
        }
        return buffer;
    }
}
