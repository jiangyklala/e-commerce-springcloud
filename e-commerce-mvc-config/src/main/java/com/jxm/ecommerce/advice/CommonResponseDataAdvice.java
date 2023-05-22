package com.jxm.ecommerce.advice;

import com.jxm.ecommerce.annotation.IgnoreResponseAdvice;
import com.jxm.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应</h1>
 * 对 response body 的内容进行统一拦截和处理
 */
@RestControllerAdvice(value = "com.jxm.ecommerce")
@SuppressWarnings("all")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * <h2>判断是否需要对响应进行处理</h2>
     */
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {

        // 判断可能被标注 IgnoreResponseAdvice 的 Element.Type
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 判断可能被标注 IgnoreResponseAdvice 的 Element.Method
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        if (null == o) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
        } else {
            response.setData(0);
        }

        return response;
    }
}
