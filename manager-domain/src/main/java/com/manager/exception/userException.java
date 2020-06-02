package com.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *
 * 自定义用户异常类
 * @author sunli
 * @date 2020/3/30 17:39
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class userException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -5816442968580750040L;

    private String code;

    private String msg;

    private String logo;
}
