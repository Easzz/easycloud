package com.findshen.stock;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import com.findshen.stock.entity.DailyData;
import com.findshen.stock.service.DailyDataService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StockApplicationTests {
	@Autowired
	private DailyDataService dailyDataService;

	@Test
	public void contextLoads() {


		String firstHtml = HttpUtil.get("http://q.10jqka.com.cn/index/index/board/all/field/zdf/order/desc/page/1/ajax/1/");

		Document firstDoc = Jsoup.parse(firstHtml);

		int totalPage = Integer.parseInt(firstDoc.select("span.page_info").text().split("/")[1]);
		log.info("totalPage : {}", totalPage);

		List<DailyData> result = new ArrayList<>();

		for (int k = 1; k <= totalPage; k++) {

			String url = "http://q.10jqka.com.cn/index/index/board/all/field/zdf/order/desc/page/" + k + "/ajax/1/";
			log.info("url:{}", url);
			String html = HttpUtil.get(url);

			Document document = Jsoup.parse(html);

			Elements trs = document.select("tbody").select("tr");
			for (Element tr : trs) {
				DailyData dailyData = new DailyData();
				dailyData.setStockDate(DateUtil.date());
				Elements tds = tr.select("td");

//				String href = trs.get(i).select("td>a").attr("href");
				Elements td = tr.select("td>a");

				dailyData.setStockCode(td.get(0).select("a").text());
				dailyData.setStockName(td.get(1).select("a").text());
				dailyData.setXj(Double.parseDouble(tds.get(3).text()));
				dailyData.setZdf(Double.parseDouble(tds.get(4).text()));
				dailyData.setZd(Double.parseDouble(tds.get(5).text()));
				dailyData.setZs(Double.parseDouble(tds.get(6).text()));
				dailyData.setHs(Double.parseDouble(tds.get(7).text()));
				dailyData.setLb(Double.parseDouble(tds.get(8).text()));
				dailyData.setZf(tds.get(9).text());
				dailyData.setCje(tds.get(10).text());
				dailyData.setLtg(tds.get(11).text());
				dailyData.setLtsz(tds.get(12).text());
				dailyData.setSyl(tds.get(13).text());
				log.info(dailyData.toString());
				result.add(dailyData);
			}
		}
		log.info("size:{}", result.size());
		dailyDataService.saveBatch(result);
	}

	@Test
	public void getPage() {

		String html = HttpUtil.get("http://q.10jqka.com.cn/index/index/board/all/field/zdf/order/desc/page/1/ajax/1/");

		Document document = Jsoup.parse(html);

		String text = document.select("span.page_info").text().split("/")[1];
		System.out.println(text);

	}

	@Test
	public void test() throws IOException {


		String[] ua = {"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
				"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
				"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)",
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0)",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 BIDUBrowser/8.3 Safari/537.36",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.277.400 QQBrowser/9.4.7658.400",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.12150.8 Safari/537.36",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 TheWorld 7",
				"Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/60.0"};


		Random r = new Random();
		int i = r.nextInt(14);


		String url = "http://q.10jqka.com.cn/index/index/board/all/field/zdf/order/desc/page/5/ajax/1/";
		log.info("url:{}", url);
//		String html = HttpUtil.get(url);
//		Map<String, Object> head = new HashMap<>();
//		head.put("userAgent", ua[i]);


		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("117.95.192.64", 9999));

		String html = HttpUtil.createGet(url).header("userAgent", ua[i])
//				.setProxy(proxy)
				.execute().body();

		System.out.println(html);


//		Document document = Jsoup.connect(url)
//				.timeout(5000)
////				.proxy(ip, port, null)
////				.data(map)
////				.ignoreContentType(true)
////				.userAgent(ua[i])
////				.header("referer","http://trace.yto.net.cn:8022/gw/index/index.html")//这个来源记得换..
//				.get();

		Document document = Jsoup.parse(html);

		Elements trs = document.select("tbody").select("tr");
		for (Element tr : trs) {
			DailyData dailyData = new DailyData();
			dailyData.setStockDate(DateUtil.date());
			Elements tds = tr.select("td");

//				String href = trs.get(i).select("td>a").attr("href");
			Elements td = tr.select("td>a");

			dailyData.setStockCode(td.get(0).select("a").text());
			dailyData.setStockName(td.get(1).select("a").text());
			dailyData.setXj(Double.parseDouble(tds.get(3).text()));
			dailyData.setZdf(Double.parseDouble(tds.get(4).text()));
			dailyData.setZd(Double.parseDouble(tds.get(5).text()));
			dailyData.setZs(Double.parseDouble(tds.get(6).text()));
			dailyData.setHs(Double.parseDouble(tds.get(7).text()));
			dailyData.setLb(Double.parseDouble(tds.get(8).text()));
			dailyData.setZf(tds.get(9).text());
			dailyData.setCje(tds.get(10).text());
			dailyData.setLtg(tds.get(11).text());
			dailyData.setLtsz(tds.get(12).text());
			dailyData.setSyl(tds.get(13).text());
			log.info(dailyData.toString());
		}
	}

}
