package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/23 17:19
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class HostelException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 7507302209531324097L;

    private Integer code;

    private String Message;
}
