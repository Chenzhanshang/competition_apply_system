package com.nnxy.competition.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.nnxy.competition.utils.ErrorEnum;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转jsp界面的拦截方式
 *
 * @author :CZS
 * @date :2019/12/17 13:31
 * Email    :642125256@qq.com
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        //用户未登录返回未登录的json信息
        jsonObject.put("status", ErrorEnum.E_UNAUTHENTICATED.getErrorCode());
        jsonObject.put("msg", ErrorEnum.E_UNAUTHENTICATED.getErrorMsg());
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

    /**
     * 解决复杂请求，他们的contentType是application/json，方法类型type是post、patch、delete、put，
     * 这些请求在执行的时候，会先往服务器发送一个探测请求，而这个探测请求的方法类型就是OPTIONS，
     * 这个请求，默认是不会带上cookie的，而且也无法设置让他带上cookie。
     * 如果后端在接收到一个请求之后，判断没有携带cookie,或者携带的cookie已经过期，
     * 那么他会让这个请求返回错误，不会成功返回状态码200。
     * 这样，复杂请求的真正请求就不会到达服务端。
     * 所以复杂请求这里就永远也请求不到数据。
     * <p>
     * 此方法然所有复杂请求的探测请求都返回200
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return super.onPreHandle(request, response, mappedValue);
    }

    /**
     * 为response设置header，实现跨域
     */
    private void setHeader(HttpServletRequest request, HttpServletResponse response) {
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
    }

    @Bean
    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
