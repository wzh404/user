package com.example.user.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultObject {
    private static final  String RESULT_OK = "OK";

    private String code;
    private String error;
    private Object result;

    public ResultObject(String code, String error, Object result){
        this.code = code;
        this.error = error;
        this.result = result;
    }

    public static ResultObject ok(){
        return new ResultObject(ResultObject.RESULT_OK, null, null);
    }

    public static ResultObject ok(Object r){
        return new ResultObject(ResultObject.RESULT_OK, null, r);
    }

    public static ResultObject fail(String code){
        return new ResultObject(code, null, null);
    }

    public static ResultObject fail(String code, String error){
        return new ResultObject(code, error, null);
    }
}
