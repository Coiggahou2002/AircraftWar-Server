package com.coiggahou.AircraftWar.handler;


import com.coiggahou.AircraftWar.entity.ApiResponse;
import com.coiggahou.AircraftWar.entity.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.annotation.Annotation;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse handleException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            log.error(
                    "[全局异常拦截] NoHandlerFoundException: Request method {}, Request path {}",
                    ((NoHandlerFoundException) e).getHttpMethod(),
                    ((NoHandlerFoundException) e).getRequestURL()
                    );
            return ApiResponse.ofStatus(ApiResponseStatus.REQUEST_NOT_FOUND);
        }
        log.error(
                "[全局异常拦截] 异常信息: {}",
                e.getMessage()
                );
        return ApiResponse.ofStatus(ApiResponseStatus.SERVER_ERROR);
    }

}
