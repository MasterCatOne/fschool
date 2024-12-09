package com.example.fschool.handler;

import com.example.fschool.model.bo.StudentLoginBo;
import com.example.fschool.utils.BusinessException;
import com.example.fschool.utils.JWTUtil;
import com.example.fschool.utils.ResponseEnum;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 登录拦截器
 * @Author novel
 * @Version 1.0
 **/

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    public static ThreadLocal<StudentLoginBo> threadLocal = new ThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessToken = request.getHeader("token");
        if (accessToken == null) {
            accessToken = request.getParameter("token");
        }

        if (StringUtils.isNotBlank(accessToken)) {
            //校验token
            Claims claims = JWTUtil.checkJWT(accessToken);
            if (claims == null) {
                //用户未登录
                throw new BusinessException(ResponseEnum.ACCOUNT_UNLOGIN);
                //return false;
            }

            long userId = Long.valueOf(claims.get("student_id").toString());
            String username = (String) claims.get("student_name");
            String account = (String) claims.get("account");


            StudentLoginBo studentLoginBo = StudentLoginBo
                    .builder()
                    .studentID(String.valueOf(userId))
                    .studentName(username)
                    .account(account)
                    .build();

            threadLocal.set(studentLoginBo);
            return true;

        }
        throw new BusinessException(ResponseEnum.ACCOUNT_UNLOGIN);
        //未登录返回false
        //return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清理
        threadLocal.remove();
    }
}