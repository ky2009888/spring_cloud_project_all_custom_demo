package org.jliang.apps.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-03-13 10:24:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    /**
     * 序列化，序列号.
     */
    private static final long serialVersionUID = -39896329812848827L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 序列号.
     */
    private String serial;
}