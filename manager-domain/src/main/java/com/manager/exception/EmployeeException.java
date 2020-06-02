package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/22 15:26
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class EmployeeException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -2433966357746854306L;

    private Integer code;

    private String Message;
}
