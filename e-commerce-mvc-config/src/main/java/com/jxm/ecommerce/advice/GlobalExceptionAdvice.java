package com.jxm.ecommerce.advice;

import com.jxm.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常捕获处理</h1>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 对所有 Exception 进行拦截
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(
            HttpServletRequest request,
            Exception exception
    ) {
        CommonResponse<String> commonResponse = new CommonResponse<>(-1, "business error");
        commonResponse.setData(exception.getMessage());
        log.error("commerce service has an error: [{}]", exception.getMessage(), exception);

        return commonResponse;
    }

}
