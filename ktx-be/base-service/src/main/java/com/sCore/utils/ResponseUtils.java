package com.sCore.utils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.sCore.core.dto.BaseResponse;
import com.sCore.core.dto.ServiceHeaderDTO;
import com.sCore.core.utils.Utils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author Admin
 */
public class ResponseUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    
    private ResponseUtils() {
        throw new IllegalStateException("ResponseUtils class");
    }

    private static final Gson gson = new Gson();

    private static void addRequestInfo(BaseResponse baseResponse) {
        try {
            String str = ThreadContext.get("serviceHeader");
            ServiceHeaderDTO serviceHeader = gson.fromJson(str, ServiceHeaderDTO.class);
            if (serviceHeader != null) {
                baseResponse.setClientMessageId(serviceHeader.getClientMessageId());
                baseResponse.setTransactionId(serviceHeader.getTransactionId());
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }

    public static ResponseEntity<Object> getResponseSucessEntity(Object itemObject) {
        BaseResponse baseResponse = new BaseResponse();
        if (itemObject != null) {
            baseResponse.setData(itemObject);
        }
        baseResponse.setCode(ErrorApp.SUCCESS.getCode());
        baseResponse.setMessage(ErrorApp.SUCCESS.getDescription());
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> getResponseEntity(ErrorApp errorApp, Object itemObject) {
        BaseResponse baseResponse = new BaseResponse();
        if (itemObject != null) {
            baseResponse.setData(itemObject);
        }
        baseResponse.setCode(errorApp.getCode());
        baseResponse.setMessage(errorApp.getDescription());
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> getResponseEntity(int code, String description, Object itemObject) {
        BaseResponse baseResponse = new BaseResponse();
        if (itemObject != null) {
            baseResponse.setData(itemObject);
        }
        baseResponse.setCode(code);
        baseResponse.setMessage(description);
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> getResponseEntity(int code, String description) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMessage(description);
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> getResponseEntity(ErrorApp errorApp) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(errorApp.getCode());
        baseResponse.setMessage(errorApp.getDescription());
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> getResponseEntity(ErrorApp errorApp, Object itemObject, HttpStatus httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        if (itemObject != null) {
            baseResponse.setData(itemObject);
        }
        baseResponse.setCode(errorApp.getCode());
        baseResponse.setMessage(errorApp.getDescription());
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    public static ResponseEntity<Object> getResponseEntity(int code, String description, Object itemObject, HttpStatus httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        if (itemObject != null) {
            baseResponse.setData(itemObject);
        }
        baseResponse.setCode(code);
        baseResponse.setMessage(description);
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    public static ResponseEntity<Object> getResponseEntity(int code, String description, HttpStatus httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMessage(description);
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    public static ResponseEntity<Object> getResponseEntity(ErrorApp errorApp, HttpStatus httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(errorApp.getCode());
        baseResponse.setMessage(errorApp.getDescription());
        addRequestInfo(baseResponse);
        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    public static ResponseEntity<Object> getResponseFileEntity(String filePath) throws IOException {
        File file = new File(filePath);
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        HttpHeaders headers = new HttpHeaders();
        String encodedFileName = URLEncoder.encode(filePath, StandardCharsets.UTF_8.name()).replace("+", "%20");
        String arr[] = encodedFileName.split("%2F");
        encodedFileName = arr[arr.length - 1];
        headers.add("Content-Disposition", String.format("attachment; inline; filename*=UTF-8''%1$s; filename=%1$s", encodedFileName));
        headers.add("Access-Control-Expose-Headers", "Content-Disposition");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    public static ResponseEntity<Object> getResponseFileEntity(byte[] fileBytes, String fileName) throws IOException {
        ByteArrayResource resource = new ByteArrayResource(fileBytes);
        HttpHeaders headers = new HttpHeaders();
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()).replace("+", "%20");
        headers.add("Content-Disposition", String.format("attachment; inline; filename*=UTF-8''%1$s; filename=%1$s", encodedFileName));
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileBytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
