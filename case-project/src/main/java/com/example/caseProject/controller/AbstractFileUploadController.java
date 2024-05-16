package com.example.caseProject.controller;

import com.example.caseProject.entity.AttachmentMediaEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 * User: monkey
 * Date: 2018-10-24 18:22
 */
@Slf4j
public abstract class AbstractFileUploadController{

	@Autowired
	private FileUploadConfig fileUploadConfig;

	public Map<String, String> upload(MultipartFile file, String backValue) {
		//响应结果
		Map<String, String> resultMap = new HashMap<>();

		String contentType = file.getContentType();

		String mediaType;
		//判断文件类型
		if (contentType.contains(AttachmentMediaEnum.IMAGE.getDescription())) {
			mediaType = AttachmentMediaEnum.IMAGE.name();
		} else if (contentType.contains(AttachmentMediaEnum.PDF.getDescription())) {
			mediaType = AttachmentMediaEnum.PDF.name();
		} else {
			mediaType = contentType;
		}

		//获取上传文件的原始名称
		String originFileName = file.getOriginalFilename();

		//获取上传文件的后缀
		String suffix = originFileName.substring(originFileName.indexOf("."));

		//保存路径
		String folder = fileUploadConfig.getUploadPath();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());

		//需要保存的文件名字
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String saveFileName = fileName + suffix;

		//文件相对路径
		String abstractPath = "upload/" + date + "/" + saveFileName;
		//本地文件
		File localFile = new File(folder + File.separator + date, saveFileName);

		//判断目录是否存在，如果不存在就全部创建
		if (!localFile.getParentFile().exists()) {
			localFile.getParentFile().mkdirs();
		}

		//上传
		try {

			// 图片压缩
//			if (contentType.contains(AttachmentMediaEnum.IMAGE.getDescription())) {
//				//压缩
//				Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.25f).toFile(localFile);
//				String url = OSSFactory.build().upload(FileUtil.readBytes(localFile), abstractPath);
//				log.info("上传图片至OSS {}", url);
//			} else {
//				String url = OSSFactory.build().upload(file.getBytes(), abstractPath);
//				log.info("上传OSS {}", url);
//			}


			//保存至本地
			file.transferTo(localFile);

			resultMap.put("realityName", originFileName);
//			resultMap.put("fileUrl", "upload" + File.separator + date + File.separator + saveFileName);

			resultMap.put("fileUrl",   File.separator + date + File.separator + saveFileName);
			resultMap.put("fileName", saveFileName);
			resultMap.put("fileType", mediaType);
			resultMap.put("code", "0");
			resultMap.put("backValue", backValue);
		} catch (Exception e) {
			resultMap.put("originFileName", originFileName);
			resultMap.put("filePath", "");
			resultMap.put("code", "500");
			log.error("上传附件失败", e);
		}

		return resultMap;
	}

	public Map<String, String> upload(MultipartFile file) {
		return upload(file, null);
	}

	/**
	 * 上传excel
	 *
	 * @param file
	 * @return
	 */
	public Map<String, String> uploadExcel(MultipartFile file) {
		//响应结果
		Map<String, String> resultMap = new HashMap<>();

		String contentType = file.getContentType();
		// image/jpeg
		// application/pdf
		log.info("contentType : {}", contentType);

//        String mediaType;
//        //判断文件类型
//        if (contentType.contains(AttachmentMediaEnum.IMAGE.getDescription())) {
//            mediaType = AttachmentMediaEnum.IMAGE.name();
//        } else {
//            throw new RRException("文件类型Excel");
//        }

		//获取上传文件的原始名称
		String originFileName = file.getOriginalFilename();

		//获取上传文件的后缀
		String suffix = originFileName.substring(originFileName.indexOf("."));

		//保存路径
		String folder = fileUploadConfig.getUploadPath();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());

		//需要保存的文件名字
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String saveFileName = fileName + suffix;

		//本地文件
		File localFile = new File(folder + File.separator + date, saveFileName);

		//判断目录是否存在，如果不存在就全部创建
		if (!localFile.getParentFile().exists()) {
			localFile.getParentFile().mkdirs();
		}

		//上传
		try {
			file.transferTo(localFile);


			//文件相对路径
//			String abstractPath = "upload/" + date + "/" + saveFileName;
//			String url = OSSFactory.build().upload(file.getBytes(), abstractPath);
////			String url = OSSFactory.build().upload(bytes, abstractPath);
//			log.info("上传OSS {}", url);

			resultMap.put("realityName", originFileName);
//			resultMap.put("fileUrl", File.separator + "upload" + File.separator + date + File.separator + saveFileName);

			resultMap.put("fileUrl", File.separator + date + File.separator + saveFileName);
			resultMap.put("fileName", saveFileName);
//            resultMap.put("fileType", mediaType);
			resultMap.put("code", "0");
		} catch (IOException e) {
			resultMap.put("originFileName", originFileName);
			resultMap.put("filePath", "");
			resultMap.put("code", "500");
			log.error("上传附件失败", e);
		}

		return resultMap;
	}
}
