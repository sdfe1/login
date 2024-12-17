package com.it.demo5.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    public static <T> ApiResponse<T> success(T data,String message){
        return new ApiResponse<>("200",message,data);
    }
    public static <T> ApiResponse<T> success(T data) {
        return success(data, "操作成功");
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>("error", message, null);
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>("error", message, data);
    }



}
