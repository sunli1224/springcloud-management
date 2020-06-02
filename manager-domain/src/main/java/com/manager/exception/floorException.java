package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/21 16:04
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class floorException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6675171322339066858L;

    private Integer code;

    private String Message;
}
