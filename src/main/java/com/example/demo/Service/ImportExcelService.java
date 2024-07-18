package com.example.demo.Service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportExcelService {
    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
