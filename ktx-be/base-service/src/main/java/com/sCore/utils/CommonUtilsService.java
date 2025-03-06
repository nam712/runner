package com.sCore.utils;

import com.sCore.config.ApplicationConfig;
import com.sCore.core.config.I18n;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.ImportExcel;
import com.sCore.core.utils.UserUtil;
import com.sCore.core.utils.Utils;
import com.sCore.dto.ImportResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonUtilsService {
    private final ApplicationConfig applicationConfig;

    @Autowired
    private HttpServletRequest request;

    public String getFilePathExport(String fileName) {
        String userName = "";
        return applicationConfig.getExportFolder() + Utils.convertDateTimeToString(new Date()) + "_" + userName + "_" + fileName;
    }

    public Response validateFileImport(HttpServletRequest req, ImportExcel importExcel, MultipartFile file, List<Object[]> dataList) {
        try {
            String filePath = applicationConfig.getExportFolder() + UserUtil.getUserLoginName(req) + System.currentTimeMillis() + "_importFile";
            if (!importExcel.validateCommon(req, file.getBytes(), dataList, filePath)) {
                ImportResultDTO importResultDTO = new ImportResultDTO();
                importResultDTO.setErrorFile(importExcel.getFileErrorDescription(req, file, applicationConfig.getExportFolder()));
                importResultDTO.setErrorList(importExcel.getErrorList());

                Integer importResult = (Integer) req.getAttribute("importResult");
                String messageError = I18n.getMessage("common.import.importError" + importResult);
                return Response.warning(Constants.RESPONSE_CODE.IMPORT_ERROR).withData(importResultDTO).withMessage(messageError);
//                return ResponseUtils.getResponseEntity(ErrorApp.INVALID_FILE.getCode(), messageError, importResultDTO);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    public Response responseErrorImportFile(ImportExcel importExcel, MultipartFile file) {
        try {
            ImportResultDTO importResultBean = new ImportResultDTO();
            importResultBean.setErrorFile(importExcel.getFileErrorDescription(request, file, applicationConfig.getExportFolder()));
            importResultBean.setErrorList(importExcel.getErrorList());
//            return ResponseUtils.getResponseEntity(ErrorApp.INVALID_FILE, importResultBean);
            return Response.warning(Constants.RESPONSE_CODE.IMPORT_ERROR).withData(importResultBean);
        } catch (Exception e) {
        }
        return null;
    }
}
