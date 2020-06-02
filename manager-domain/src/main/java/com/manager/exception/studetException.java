package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/20 15:45
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class studetException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6858160771346486684L;

    private String code;

    private String msg;
}
