package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/5/6 16:17
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class RecordException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -3830308614589525509L;

    private Integer code;

    private String Message;
}
