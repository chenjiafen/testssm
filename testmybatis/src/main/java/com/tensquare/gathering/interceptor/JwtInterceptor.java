//package com.tensquare.gathering.interceptor;
//
//import com.tensquare.gathering.utils.JwtUtil;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author chenjiafeng2
// * @create 2021-07-05 20:01
// * @desc 请求头拦截器
// **/
//public class JwtInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        //1 . 获得 Authorization 头内容(token)
//        String header = request.getHeader("Authorization");
//        if (!StringUtils.isEmpty(header) && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//            Claims claims = jwtUtil.parseToken(token);
//            if (claims != null) { //解析出用户信息
//                //将用户信息放入request域
//                String role = (String) claims.get("role");
//                //claims_admin 管理员
//                //claims_user 普通游客
//                request.setAttribute("claims_" + role, claims);
//                System.out.println("将Jwt的载荷信息放入request域:claims_" + role);
//            }
//        }
//        return true;
//    }
//
//}
