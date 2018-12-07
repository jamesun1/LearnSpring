package com.sunxu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.sunxu.dao.DataSourceMapper;
import com.sunxu.entity.DataResult;
import com.sunxu.entity.DataSource;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetHttpUtil {

	Logger logger = LoggerFactory.getLogger(getClass());
	OkHttpClient okHttpClient = SpringContextUtil.getBean(OkHttpClient.class);

	public void getHttpUtil(DataSourceMapper dataSourceMapper) {
		String url = "http://www.mdjcom.com/Datacrud/updates?category=tencent";
		final Request request = new Request.Builder().addHeader("X-Requested-With", "XMLHttpRequest").url(url).get()// 默认就是GET请求，可以不写
				.build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				logger.info("aaa");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String str = response.body().string();
				logger.info("onResponse: " + str);

				Date date = new Date();

				JSONObject jsonObject = JSONObject.parseObject(str);
				DataSource dataSource = JSONObject.toJavaObject(jsonObject, DataSource.class);
				int publishTime = jsonObject.getInteger("publish_time");
				int currentTime = jsonObject.getInteger("currentTime");
				int nextTime = jsonObject.getInteger("nextTime");
				dataSource.setPublishTime(DataUtils.getInstance().TimestampToDate(publishTime));
				dataSource.setCurrenttime(DataUtils.getInstance().TimestampToDate(currentTime));
				dataSource.setNexttime(DataUtils.getInstance().TimestampToDate(nextTime));
				dataSource.setCreatetime(date);
				String result = dataSource.getResult();
				String[] resultList = result.split(",");
				dataSource.setFirst(resultList[4]);
				dataSource.setSecond(resultList[3]);
				dataSource.setThird(resultList[2]);
				dataSource.setForth(resultList[1]);
				dataSource.setFifth(resultList[0]);
				dataSourceMapper.insert(dataSource);
				logger.info("成功");
			}
		});
	}
}
