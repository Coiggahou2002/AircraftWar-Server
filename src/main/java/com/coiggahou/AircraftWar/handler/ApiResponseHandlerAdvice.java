package com.coiggahou.AircraftWar.handler;

import com.coiggahou.AircraftWar.entity.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 接口切面 - 返回体包装
 * @author coiggahou
 */
@ControllerAdvice
public class ApiResponseHandlerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResponse) {
            return body;
        } else {
            ApiResponse apiResponse = new ApiResponse(
                    200,
                    "good",
                    body
            );
            return apiResponse;
        }
    }
}
