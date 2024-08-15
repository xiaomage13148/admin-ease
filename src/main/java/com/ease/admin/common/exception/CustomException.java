package com.ease.admin.common.exception;

import com.ease.admin.common.bean.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    @Getter
    private ResultEnum resultEnum;

    public CustomException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getState();
        this.errorMsg = resultEnum.getMsg();
        this.resultEnum = resultEnum;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
