package com.jxm.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用相应对象定义</h1>
 * {
 *     "code": 0,
 *     "message": "",
 *     "data": {}
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 泛型响应数据
     */
    private T data;

    /**
     * 不需要 data 的返回
     */
    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
