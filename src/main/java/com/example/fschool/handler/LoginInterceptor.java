    package com.example.fschool.handler;

    //import com.example.fschool.model.bo.StudentLoginBo;
    import com.example.fschool.model.bo.ManagerLoginBo;
    import com.example.fschool.model.bo.ParentLoginBo;
    import com.example.fschool.model.bo.StudentLoginBo;
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
     * @Description 登录拦截器
     * @Author novel
     * @Version 1.0
     **/

    @Slf4j
    public class LoginInterceptor implements HandlerInterceptor {
//        学生
        public static ThreadLocal<StudentLoginBo> studentLocal = new ThreadLocal<>();
//        管理员
        public static ThreadLocal<ManagerLoginBo> managerLocal= new ThreadLocal<>();
//        教师
        public static ThreadLocal<TeacherLoginBo> teacherLocal = new ThreadLocal<>();
//        家长
        public static ThreadLocal<ParentLoginBo> parentLocal = new ThreadLocal<>();



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
                if("student".equals(role)){
                    long userId = Long.valueOf(claims.get("student_id").toString());
                    String username = (String) claims.get("student_name");
                    String xuehao = (String) claims.get("xuehao");
                    StudentLoginBo studentLoginBo = StudentLoginBo
                            .builder()
                            .studentID(String.valueOf(userId))
                            .studentName(username)
                            .xuehao(xuehao)
                            .build();
                    studentLocal.set(studentLoginBo);
                    if (requestURI.startsWith("/api/managers/list") || requestURI.startsWith("/api/teachers/list")||requestURI.startsWith("/api/parents/list")) {
                        // 拒绝访问
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
                        throw new BusinessException(ResponseEnum.ACCESS_DENIED);
                    }
                }
                if("manager".equals(role)){
                    long managerId = Long.valueOf(claims.get("manager_id").toString());
                    String managerName = (String) claims.get("manager_name");
                    String account = (String) claims.get("account");

                    ManagerLoginBo managerLoginBo = ManagerLoginBo
                            .builder()
                            .studentID(String.valueOf(managerId))
                            .studentName(managerName)
                            .account(account)
                            .build();
                    managerLocal.set(managerLoginBo);

                }
                if("parent".equals(role)){
                    long parentId = Long.valueOf(claims.get("parent_id").toString());
                    System.out.println("我是parentID"+parentId);
                    String parentName = (String) claims.get("parent_name");
                    String account = (String) claims.get("account");
                    ParentLoginBo parentLoginBo = ParentLoginBo
                            .builder()
                            .parentID(String.valueOf(parentId))
                            .parentName(parentName)
                            .account(account)
                            .build();
                    parentLocal.set(parentLoginBo);
                    if (requestURI.startsWith("/api/managers/list") || requestURI.startsWith("/api/teachers/list")) {
                        // 拒绝访问
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
                        throw new BusinessException(ResponseEnum.ACCESS_DENIED);
                    }

                }
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
                    teacherLocal.set(teacherLoginBo);
                    if (requestURI.startsWith("/api/managers/list")) {
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
            studentLocal.remove();
            managerLocal.remove();
            teacherLocal.remove();
            parentLocal.remove();
        }
    }