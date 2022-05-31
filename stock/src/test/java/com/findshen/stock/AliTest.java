package com.findshen.stock;

import cn.hutool.http.HttpUtil;

/**
 * Created by shenxuan on 2021/12/28 8:49
 */
public class AliTest {
	public static void main(String[] args){
	    String url="https://bj29.cn-beijing.data.alicloudccp.com/ifTfN2nN%2F781050%2F60b8444f15d1d745330f49628bea57f47d64b490%2F60b8444f62ca606aba0d4902ab24d4ffbe5c68da?di=bj29&dr=1158238&f=61b8097b051efee459424869bb4bf57665deca65&u=e933d6706e284cf8906f88b3efd8fec3&x-oss-access-key-id=LTAIsE5mAn2F493Q&x-oss-expires=1640666869&x-oss-signature=bdqMvcUPq9bYfgsFHBlsdlexSXesG82YQCjZW3v4sPY%3D&x-oss-signature-version=OSS2";
		HttpUtil.downloadFile(url,"D:/a.mp4");

	}
}
