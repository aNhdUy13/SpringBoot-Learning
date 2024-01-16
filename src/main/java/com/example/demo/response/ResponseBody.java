/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {

    public static final ResponseBody SUCCESS_RESPONSE = new ResponseBody(ResponseCode.SUCCESS);
    public static final ResponseBody WRONG_DATA_FORMAT_RESPONSE = new ResponseBody(ResponseCode.WRONG_DATA_FORMAT);
    
    protected int code;
    private Object data;

    public ResponseBody(int code) {
        this.code = code;
    }

    public ResponseBody(Object data) {
        this.code = ErrorCode.SUCCESS;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
