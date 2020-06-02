package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页全局异常
 * @author sunli
 * @date 2020/4/9 17:26
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class PageHelperException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 5779011835992282587L;

    private Integer code;

    private String Message;

}
