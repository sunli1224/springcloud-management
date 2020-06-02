package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/5/12 3:44
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class AuthException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 3948805058432957571L;
    private Integer code;

    private String Message;
}
