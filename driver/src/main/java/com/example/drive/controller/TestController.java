package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.alibaba.fastjson.JSONObject;
import com.example.drive.config.R;
import com.example.drive.entity.Terrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/kc")
@Slf4j
public class TestController {


	@PostMapping("/callback")
	public R<List<Terrace>> getTerraceAndProject(HttpServletRequest request) throws IOException {

		int contentLength = request.getContentLength();
		if (contentLength > 0) {
			byte[] buff = new byte[contentLength];
			for (int i = 0; i < contentLength; ) {
				int read = request.getInputStream().read(buff, i, contentLength - i);
				if (read == -1) {
					break;
				}
				i += read;
			}
			String s = new String(buff, StandardCharsets.UTF_8);
			log.info("消息{}", s);
			JSONObject resultJson = JSONObject.parseObject(s);

			//解析消息推送数据格式
			//解析消息推送数据格式
			JSONObject params = (JSONObject) resultJson.get("params");

		}
		return new R<>();
	}

}
