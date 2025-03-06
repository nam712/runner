package com.sCore.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationConfig {

    @Value("${report.exportFolder}")
    private String exportFolder;

    @Value("${common.upload.max-file-size}")
    private Integer maxFileSize;

//    @Value("${file.system.url.uploadMultiFile}")
//    private String urlUploadFile;
//
//    @Value("${file.system.url.donwloadFile}")
//    private String urlDownloadFile;

    @Value("${common.app.default-password}")
    private String defaultPassword;


}
