package com.pasta.aglioeolio.config;

import com.pasta.aglioeolio.common.Login;
import com.pasta.aglioeolio.common.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    //private final JwtTokenFilter jwtTokenFilter;

    @Override
    public boolean supportsParameter(MethodParameter parameter){
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasMemberType = LoginUser.class.isAssignableFrom(parameter.getParameterType());

        return hasLoginAnnotation && hasMemberType;
    }

    //TODO: Jwt Token값을 이용해 로그인한 유저의 ID를 구한 후  LoginUser 객체 반환
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        String jwtToken = jwtTokenFilter.extractJwtToken(
//            Objects.requireNonNull((HttpServletRequest) webRequest.getNativeRequest()));
//        return oAuth2Service.findLoginUserByToken(jwtToken);
        return new LoginUser();
    }

}
