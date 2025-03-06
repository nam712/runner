package com.sCore.modules.upload.controller;

import com.sCore.modules.upload.bean.FileUploadResult;
import com.sCore.modules.upload.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadApiController {

    @Autowired
    FileStorageService storageService;

    @PostMapping("/upload-image")
    public FileUploadResult uploadImage(
            @RequestParam("file") MultipartFile file) {
        String message = "";
        FileUploadResult result = new FileUploadResult();
        try {
            String newFilename = storageService.store(file);
            message = "You successfully uploaded " +
                    file.getOriginalFilename() + "!";
            result.setMessage(message);
            result.setSuccess(true);
            result.setLink("/link/" +
                    newFilename);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("")
    public FileUploadResult uploadFile(
            @RequestParam("file") MultipartFile file) {
        String message = "";
        FileUploadResult result = new FileUploadResult();
        try {
            String newFilename = storageService.store(file);
            message = "You successfully uploaded " +
                    file.getOriginalFilename() + "!";
            result.setMessage(message);
            result.setSuccess(true);
            result.setLink("/link/" +
                    newFilename);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
