package com.manager.search.exception;

import com.manager.commons.JsonResponse;
import com.manager.exception.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunli
 * @date 2020/5/2 14:12
 */
@RestController
public class SearchGolbalException {

    /**
     * 缺勤记录异常处理器
     * @param e validate
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = RecordException.class)
    public JsonResponse RecordInfoController(RecordException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }



    /**
     * 宿舍调换记录异常处理器
     * @param e validate
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = DormitoryexchangerecordException.class)
    public JsonResponse DormitoryexchangerecordController(DormitoryexchangerecordException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }


    /**
     * 宿舍管理异常处理器
     * @param e 宿舍管理异常
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = HostelException.class)
    public JsonResponse HostelController(HostelException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }


    /**
     * 分页全局异常处理器
     * @param e 分页自定义异常
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = PageHelperException.class)
    public JsonResponse pageHelperController(PageHelperException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    /**
     * 学生模块自定义异常处理器
     * @param e 学生管理模块自定义异常
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = studetException.class)
    public JsonResponse studetExceptionController(studetException e) {
        return JsonResponse
                .builder()
                .code(Integer.parseInt(e.getCode()))
                .message(e.getMessage())
                .build();
    }

    /**
     * 员工管理模块自定义异常处理器
     * @param e 员工管理模块自定义异常
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = EmployeeException.class)
    public JsonResponse employeeExceptionController(EmployeeException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    /**
     * 楼宇管理自定义异常处理器
     * @param e 楼宇管理自定义异常
     * @return 异常数据包
     */
    @ResponseBody
    @ExceptionHandler(value = floorException.class)
    public JsonResponse floorExceptionController(floorException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = AuthException.class)
    public JsonResponse floorExceptionController(AuthException e) {
        return JsonResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }
}
