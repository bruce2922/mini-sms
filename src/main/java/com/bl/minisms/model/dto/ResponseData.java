package com.bl.minisms.model.dto;

import org.springframework.http.HttpStatus;

public class ResponseData<T> {

    private int status;
    private String message;
    private T data;
    private static String MSG_SUCCESS = "success";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static  ResponseData success(){
        ResponseData responseData=new ResponseData();
        responseData.setStatus(HttpStatus.OK.value());
        responseData.setMessage(MSG_SUCCESS);
        return responseData;
    }

    public static  <T> ResponseData<T> success(T data){
        ResponseData<T> responseData=new ResponseData<>();
        responseData.setStatus(HttpStatus.OK.value());
        responseData.setMessage(MSG_SUCCESS);
        responseData.setData(data);
        return responseData;
    }

    public static <T> ResponseData<T> fail(int code, String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus(code);
        responseData.setMessage(message);
        return responseData;
    }

}
