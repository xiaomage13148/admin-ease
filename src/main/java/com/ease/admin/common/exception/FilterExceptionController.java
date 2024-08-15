package com.ease.admin.common.exception;

import com.ease.admin.common.constant.Constant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO 忽略 knife4j 扫描
@RestController
public class FilterExceptionController {
    @RequestMapping("/" + Constant.MY_EXCEPTION)
    public void myException(HttpServletRequest request) throws CustomException {
        throw ((CustomException) request.getAttribute(Constant.MY_EXCEPTION));
    }
}
