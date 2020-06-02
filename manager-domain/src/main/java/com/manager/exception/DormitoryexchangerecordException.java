package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/24 0:25
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class DormitoryexchangerecordException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 604367134433348998L;

    private Integer code;

    private String Message;
}
