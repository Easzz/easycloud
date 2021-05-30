package com.example.demo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fileupload")
@Data
public class FileUploadConfig {
    
    /**
     * 上传路径
     */
    private String uploadPath;
    private String apiUrl;
    private String fileServerUrl;


}
