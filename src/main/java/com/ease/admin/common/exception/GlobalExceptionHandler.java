package com.ease.admin.common.exception;

import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.bean.vo.response.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义校验异常
     */
    @ExceptionHandler(value = CustomException.class)
    public BaseResp<ResultEnum> businessExceptionHandler(CustomException e) {
        log.error("CustomException", e);
        return new BaseResp<>(e.getErrorCode(), e.getMessage());
    }

    /**
     * 参数为空异常
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public BaseResp<ResultEnum> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException", e);
        return new BaseResp<>(ResultEnum.PARAMETER_IS_EMPTY_EXCEPTION);
    }

    /**
     * 方法参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResp<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException:", e);
        Map<String, Object> map = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new BaseResp<>(ResultEnum.PARAMETER_VERIFICATION_EXCEPTION, map);
    }

    @ExceptionHandler(value = Exception.class)
    public BaseResp<ResultEnum> exceptionHandler(Exception e) {
        log.error("Exception", e);
        return new BaseResp<>(ResultEnum.UNKNOWN_EXCEPTION);
    }

}
