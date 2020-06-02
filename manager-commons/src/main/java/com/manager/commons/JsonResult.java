package com.manager.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/22 23:09
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -1908866160593815582L;

    private int code;
    private String message;
    private Object data;
}
