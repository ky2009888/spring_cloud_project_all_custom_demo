package org.jliang.apps.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公共的展示类
 *
 * @author Lenovo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    /**
     * 请求响应编码.
     */
    private Integer code;
    /**
     * 请求响应提示.
     */
    private String messge;
    /**
     * 实际的展示数据.
     */
    private T data;

    /**
     * 构造函数
     *
     * @param code   请求响应编码
     * @param messge 请求响应提示
     */
    public CommonResult(Integer code, String messge) {
        this(code, messge, null);
    }
}
