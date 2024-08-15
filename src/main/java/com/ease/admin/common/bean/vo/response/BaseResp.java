package com.ease.admin.common.bean.vo.response;

import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.utils.MDCUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "基础返回体")
public class BaseResp<T> implements Serializable {

    @Schema(title = "请求结果")
    private String status;

    @Schema(title = "描述信息")
    private String message;

    @Schema(title = "数据")
    private T data;

    public BaseResp(ResultEnum resultEnum, T data) {
        this.status = resultEnum.getState();
        this.message = resultEnum.getMsg();
        this.data = data;
    }

    public BaseResp(ResultEnum resultEnum) {
        this.status = resultEnum.getState();
        this.message = resultEnum.getMsg();
    }

    public BaseResp(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
