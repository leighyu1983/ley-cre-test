package com.ley.enums;

public enum EnumStatus {
    NEW(1, "new"), DIALING(2, "dialing");

    private String status;
    private int code;
    private EnumStatus(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public static EnumStatus findByCode(int code) {
        EnumStatus[] status = values();
        for( EnumStatus state : status) {
            if(state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}