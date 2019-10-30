package com.ley.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObj {
    private int code;
    private String message;
    private Object data;

    public static ResponseObj success() {
        return new ResponseObj(0, null, null);
    }

    public static ResponseObj success(Object data) {
        return new ResponseObj(0, null, data);
    }

    public static ResponseObj error(int code, String message) {
        return new ResponseObj(code, null, message);
    }

    public static ResponseObj error(Exception ex) {
        return new ResponseObj(1, ex.toString(), null);
    }

}
