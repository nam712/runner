package com.sCore.modules.upload.bean;

import lombok.Data;

@Data
public class FileUploadResult {
    private boolean isSuccess;
    private String message;
    private String link;
}
