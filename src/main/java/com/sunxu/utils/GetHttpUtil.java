package com.sunxu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sunxu.dao.DataSourceMapper;
import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.dao.HistoryInfoMapper;
import com.sunxu.entity.DataResult;
import com.sunxu.entity.DataSource;
import com.sunxu.entity.DataSourcePro;
import com.sunxu.entity.HistoryInfo;
import com.sunxu.vo.DataSourceVo;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetHttpUtil {

	Logger logger = LoggerFactory.getLogger(getClass());
	OkHttpClient okHttpClient = SpringContextUtil.getBean(OkHttpClient.class);

	public void getHttpUtil(DataSourceProMapper dataSourceProMapper, DataSourceMapper dataSourceMapper,
			HistoryInfoMapper historyInfoMapper) {
		String url = "https://hengyaowin.com/api/lottery/28/bonus-numbers?limit=1";
		final Request request = new Request.Builder().addHeader("Content-Type", "application/vnd.sc-api.v1.json")
				.addHeader("Authorization",
						"bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC96aG9uZzloZS5uZXRcL2FwaVwvYXV0aFwvbG9naW4iLCJpYXQiOjE1NDQ0OTQ3OTYsImV4cCI6MTU0NTA5OTU5NiwibmJmIjoxNTQ0NDk0Nzk2LCJqdGkiOiJaZm9ueUNRY1Y1UmczOUhBIiwic3ViIjoiMjgyNDYiLCJwcnYiOiJmY2M0OTUzZmVkMTM5YTgxN2I5OTM0YTY3NjQyMzliZDQwNWRjMGUxIiwidXNlcm5hbWUiOiJnZW5nYzE5ODYiLCJzZXNzaWQiOiJmMTA4NDRhNzUyYjc5YTQ5ZDg5NGJmMGM1NTYyYWE4NmJmMDAyZGJmIn0.Njg5ODk4YzdhYWQxMjg2OTQzZWQxOGZkMGJiZTc0Y2U1MzMzYjQwNjJhNDc0ODdhZmIwZWMwMGE5ZDk0YTA4OQ")
				.url(url).get()// 默认就是GET请求，可以不写
				.build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				logger.info("aaa");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				DataSourceVo dataSourceVo = new DataSourceVo();
				List<List<String>> dataSourceVoList = dataSourceMapper.getAllCurrentNotCon("300");
				dataSourceVo.setZero(dataSourceVoList.get(0).get(0));
				dataSourceVo.setOne(dataSourceVoList.get(1).get(0));
				dataSourceVo.setTwo(dataSourceVoList.get(2).get(0));
				dataSourceVo.setThree(dataSourceVoList.get(3).get(0));
				dataSourceVo.setFour(dataSourceVoList.get(4).get(0));
				dataSourceVo.setFive(dataSourceVoList.get(5).get(0));
				dataSourceVo.setSix(dataSourceVoList.get(6).get(0));
				dataSourceVo.setSeven(dataSourceVoList.get(7).get(0));
				dataSourceVo.setEight(dataSourceVoList.get(8).get(0));
				dataSourceVo.setNine(dataSourceVoList.get(9).get(0));
				List<DataSourceVo> dtList = Utils.listSort(dataSourceVo);
				List<DataSourceVo> fourMax = dtList.subList(0, 4);
				List<DataSourceVo> fiveMax = dtList.subList(0, 5);
				List<DataSourceVo> sixMax = dtList.subList(0, 6);

				String str = response.body().string();
				logger.info("onResponse: " + str);

				Date date = new Date();

				JSONObject jsonObject = JSONObject.parseObject(str);
				DataSourcePro dataSourcePro = JSONObject.toJavaObject(jsonObject.getJSONArray("data").getJSONObject(0),
						DataSourcePro.class);

				String[] resultList = dataSourcePro.getSplitCode();
				dataSourcePro.setFirst(resultList[4]);
				dataSourcePro.setSecond(resultList[3]);
				dataSourcePro.setThird(resultList[2]);
				dataSourcePro.setForth(resultList[1]);
				dataSourcePro.setFivth(resultList[0]);
				dataSourcePro.setCreateDate(new Date());
				dataSourcePro.setTimestamp(DataUtils.getInstance().TimestampToDate(jsonObject.getInteger("timestamp")));
				dataSourceProMapper.insert(dataSourcePro);

				for (int i = 1; i <= 3; i++) {
					HistoryInfo historyInfo = new HistoryInfo();
					historyInfo.setIssue(dataSourcePro.getIssue());
					String adviceNum = "";
					if (i == 1) {
						adviceNum = Utils.dataToString(fourMax);
					} else if (i == 2) {
						adviceNum = Utils.dataToString(fiveMax);
					} else if (i == 3) {
						adviceNum = Utils.dataToString(sixMax);
					}
					historyInfo.setAdviceNum(adviceNum);
					historyInfo.setType(String.valueOf(i));
					historyInfo.setWinNum(dataSourcePro.getFirst());
					historyInfo.setWin(findIndexOf(adviceNum, dataSourcePro.getFirst()));
					historyInfo.setCreateTime(date);
					historyInfoMapper.insert(historyInfo);
				}

				logger.info("成功");
			}
		});
	}

	private String findIndexOf(String adviceNum, String num) {
		if (adviceNum.indexOf(num) > -1) {
			return "0";
		} else {
			return "1";
		}
	}
}
