package com.ease.admin.common.exception;

import com.ease.admin.common.constant.Constant;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter/exception")
public class FilterExceptionController {
    @Hidden
    @RequestMapping("/" + Constant.MY_EXCEPTION)
    public void myException(HttpServletRequest request) throws CustomException {
        throw ((CustomException) request.getAttribute(Constant.MY_EXCEPTION));
    }
}
