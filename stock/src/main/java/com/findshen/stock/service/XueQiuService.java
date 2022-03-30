package com.findshen.stock.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.findshen.stock.dao.XueQiuDao;
import com.findshen.stock.entity.XueQiuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class XueQiuService {
    @Autowired
    private XueQiuDao xueQiuDao;

    @Scheduled(cron = "0/5 * * * * ?")
    public void realData() {
        log.info("start");
        String url = "https://xueqiu.com/v4/statuses/user_timeline.json?page=1&user_id=4284663015";
//        String url = "https://xueqiu.com/v4/statuses/user_timeline.json?page=1&user_id=3678176363";
        String cookie = "__utmz=1.1599651771.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); device_id=957a335ce550e5532f7e6525141f53b5; s=cc113ycaik; __utma=1.955937507.1599651771.1623323289.1633866945.11; cookiesu=961647419793662; xq_a_token=d9e55dabd156b1ce81e221878e2d9897ccea8920; xqat=d9e55dabd156b1ce81e221878e2d9897ccea8920; xq_r_token=4c9782badf4b8b872e58fbcf752a91048464a2f4; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTY1MDE1MTU5MiwiY3RtIjoxNjQ4NTYyMzc1NjkzLCJjaWQiOiJkOWQwbjRBWnVwIn0.rBYIEVZHF8mCEAb-MeZy-5pSzaQtp5mMX62CfpLeCqvSHyM1kg7WDPdo4ELDnrP61WStsYnzFqXTujn_PWrOiAJm0MWqiie8Gkx8rgyXfd9FunSb9oFDJdFgvE5hBwy33tHby4KiX5EEpGqxbBnyC4nfFJXscEy4njCzXxicT16IOKo7dlzAcrAeAKUTgKs_YDXe6g9A39bNqKwnCW1UXbCPsFhVwKBN-EgVjFEAa6UV8jmjPmJiAmhEZfruxH1GJfpnGfvAKMtCMbqN3PcQHANSn1eceNfHeuD31__rJ3OnT96U5VS5zjQ8YTBUCoM94gFhUnbdggDjXCbHr7M1Zg; u=121648562377188; Hm_lvt_1db88642e346389874251b5a1eded6e3=1647352591,1647419794,1648562379; acw_tc=276077a316486404025674639e974e5153e16d9003a62febcdc14cbfb95de5; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1648640636; _dd_s=logs=1&id=540ff586-d1e7-4511-8982-bc76d9f0b689&created=1648640403520&expire=1648641551865";
        String body = HttpUtil.createGet(url).cookie(cookie).execute().body();

        Object statuses = JSON.parseObject(body).get("statuses");
        List<XueQiuVo> xueQiuVos = JSON.parseArray(statuses.toString(), XueQiuVo.class);

        XueQiuVo xueQiuVo = xueQiuVos.get(0);
        XueQiuVo dbData = xueQiuDao.selectOne(new LambdaQueryWrapper<XueQiuVo>()
                .eq(XueQiuVo::getCreated_at, xueQiuVo.getCreated_at()));

        if (dbData == null) {

            log.info(String.valueOf(123));
            xueQiuDao.insert(xueQiuVo);

            String postUrl = "http://wxpusher.zjiecode.com/api/send/message";
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("appToken", "AT_BvWJkRs82qMworrIBikBH7rs06uOux6i");

            String summary = "";
            String content = xueQiuVo.getText();
            if (content.length() > 100) {
                summary = content.substring(0, 99);
            } else {
                summary = content;
            }

            jsonObject.set("content", content);
            jsonObject.set("summary", summary);
            jsonObject.set("contentType", "1");

            List<String> uids = new ArrayList<>();
            uids.add("UID_b1B7O0xsvBLT9jx4C72eGT6Mv2UW");
            jsonObject.set("uids", uids);
            jsonObject.set("url", "https://xueqiu.com/u/4284663015");
            String body1 = HttpUtil.createPost(postUrl).contentType("application/json").body(jsonObject.toString()).execute().body();
            log.info(body1);

        }

        log.info("end");
    }
}
