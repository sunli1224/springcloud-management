package com.manager.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import java.io.Serializable;


/**
 * 自定义返回类
 * @author sunli
 * @date 2020/3/18 11:44
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class JsonResponse implements Serializable {


    private static final long serialVersionUID = 4309812936208307985L;

    private int code;
    private String message;
    private Object data;



}
