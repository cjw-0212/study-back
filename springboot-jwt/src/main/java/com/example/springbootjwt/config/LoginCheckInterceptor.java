package com.example.springbootjwt.config;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootjwt.utils.JwtUtils;
import com.example.springbootjwt.utils.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器对象
 *
 * @author CJW
 * @since 2023/9/20
 */
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 请求执行前
     *
     * @param request
     * @param response
     * @param handler
     * @return true表示放行false表示拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //获取请求头中的token
        String token = request.getHeader("token");
        System.out.println("请求中的token：" + token);
        if (token == null) {
            Result result = Result.error("请先登录");
            String json = JSONObject.toJSONString(result);
            //设置响应头，响应数据为json类型，数据编码为utf-8
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            //不放行请求
            return false;
        }
        //token存在，对其进行解析
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            System.out.println("token解析失败");
            Result result = Result.error("请先登录");
            String json = JSONObject.toJSONString(result);
            //设置响应头，响应数据为json类型，数据编码为utf-8
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            //不放行请求
            return false;
        }
        //token存在且解析成功，放行该请求
        return true;
    }

    /**
     * 请求执行后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 视图渲染完成后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
