package com.manager.auth.userexception;

import com.manager.commons.JsonResponse;
import com.manager.exception.userException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 *
 * 全局异常处理器
 * @author sunli
 * @date 2020/3/30 17:37
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = userException.class)
    public JsonResponse businessExceptionHandler(HttpServletRequest httpServletRequest, userException e) {
        return JsonResponse.builder()
                .code(Integer.parseInt(e.getCode()))
                .message(e.getMsg())
                .data(e.getLogo())
                .build();
    }

}
