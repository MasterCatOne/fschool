package com.example.fschool.handler;

import com.example.fschool.model.bo.ParentLoginBo;
import com.example.fschool.model.bo.TeacherLoginBo;
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
 * @Description 教师登录拦截器
 * @Author novel
 * @Version 1.0
 **/
@Slf4j
public class TeacherLoginInceptor implements HandlerInterceptor {

    public static ThreadLocal<TeacherLoginBo> threadLocal = new ThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

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
            String role = (String) claims.get("role");
            if("teacher".equals(role)){
                long teacherId = Long.valueOf(claims.get("teacher_id").toString());
                String teacherName = (String) claims.get("teacher_name");
                String gonghao = (String) claims.get("gonghao");
                TeacherLoginBo teacherLoginBo = TeacherLoginBo
                        .builder()
                        .teacherId(String.valueOf(teacherId))
                        .teacharName(teacherName)
                        .gonghao(gonghao)
                        .build();
                threadLocal.set(teacherLoginBo);
                if (requestURI.startsWith("/api/managers")) {
                    // 拒绝访问
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
                    throw new BusinessException(ResponseEnum.ACCESS_DENIED);
                }

            }
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
