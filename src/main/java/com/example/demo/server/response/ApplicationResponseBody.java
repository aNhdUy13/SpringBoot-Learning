/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.server.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationResponseBody {

    public static final ApplicationResponseBody SUCCESS_RESPONSE = new ApplicationResponseBody(ResponseCode.SUCCESS);
    public static final ApplicationResponseBody WRONG_DATA_FORMAT_RESPONSE = new ApplicationResponseBody(ResponseCode.WRONG_DATA_FORMAT);
    
    protected int code;
    private Object data;

    public ApplicationResponseBody(int code) {
        this.code = code;
    }

    public ApplicationResponseBody(Object data) {
        this.code = ErrorCode.SUCCESS;
        this.data = data;
    }
}
