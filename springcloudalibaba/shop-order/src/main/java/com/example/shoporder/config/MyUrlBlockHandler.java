package com.example.shoporder.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义流控异常返回
 *
 * @author CJW
 * @since 2023/10/16
 */
@Component
public class MyUrlBlockHandler implements BlockExceptionHandler {
    //BlockException 异常接口,包含Sentinel的五个异常
    // FlowException 限流异常
    // DegradeException 降级异常
    // ParamFlowException 参数限流异常
    // AuthorityException 授权异常
    // SystemBlockException 系统负载异常
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e)
            throws Exception {
        response.setContentType("application/json;charset=utf-8");
        String message = null;
        if (e instanceof FlowException) {
            message = "限流异常";
        } else if (e instanceof DegradeException) {
            message = "降级异常";
        } else if (e instanceof ParamFlowException) {
            message = "参数限流异常";
        } else if (e instanceof AuthorityException) {
            message = "授权异常";
        } else if (e instanceof SystemBlockException) {
            message = "系统负载异常";
        }
        response.getWriter().write(JSON.toJSONString(message));
    }
}
