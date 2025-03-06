package com.sCore.utils;


public enum ErrorApp {
    SUCCESS(200, "msg.success"),
    BAD_REQUEST(400, "msg.bad.request"),
    UNAUTHORIZED(401, "msg.unauthorized"),
    ACCESS_DENIED(403, "msg.access.denied"),
    INTERNAL_SERVER(500, "msg.internal.server"),
    USER_EXISTS(1, "msg.user.exists"),
    USER_NOT_EXISTS(2, "msg.user.not.exists"),
    GET_FILE_ERROR(3,"get.file.error"),
    INVALID_FILE(4, "msg.file.invalid"),
    INVALID_BASE64(5, "msg.base64.invalid"),
    INVALID_PARAM(201, "");

    private final int code;
    private final String description;

    ErrorApp(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
