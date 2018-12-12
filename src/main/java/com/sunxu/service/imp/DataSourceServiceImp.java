package com.sunxu.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunxu.dao.DataSourceMapper;
import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.entity.DataSource;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.GetHttpUtil;
import com.sunxu.utils.LogicException;
import com.sunxu.vo.DataSourceVo;

@Service
public class DataSourceServiceImp implements DataSourceService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSourceMapper dataSourceMapper;

	@Override
	public void getDataSource(DataSourceProMapper dataSourceProMapper) throws LogicException {
		try {
			GetHttpUtil getHttpUtil = new GetHttpUtil();
			getHttpUtil.getHttpUtil(dataSourceProMapper);
			logger.info("调用成功");
		} catch (Exception e) {
			logger.error("错误" + e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}

	}

	@Override
	public ApiResult getDataSource(DataSourceVo dataSourceVo) throws LogicException {
		try {
			int count = 0;
			double win = 0;
			String[] number = dataSourceVo.getNumber();
			String issueNum = dataSourceVo.getIssue();
			List<DataSource> dataSourceList = dataSourceMapper.getDataSource(issueNum);
			List<List<String>> dataList = new ArrayList<>();
			for (DataSource item : dataSourceList) {
				List<String> data = new ArrayList<>();
				String issue = item.getIssue();
				String first = item.getFirst();
				if (this.findStr(number, first)) {
					count++;
					win++;
				} else {
					count--;
				}
				data.add(issue);
				for (int i = 0; i < 4; i++) {
					data.add(String.valueOf(count));
				}
				dataList.add(data);
			}

			double winningRate = this.formatDouble(win / Double.valueOf(dataSourceList.size()) * 100);

			dataSourceVo.setWinningRate(winningRate);
			dataSourceVo.setDataList(dataList);

			String str = this.dataToString(number);

			DataSourceVo dsv = new DataSourceVo();
			dsv = dataSourceMapper.getMaxContinue(issueNum, str);
			dataSourceVo.setMaxContinue(dsv.getTimes());

			dsv = dataSourceMapper.getNoMaxContinue(issueNum, str);
			dataSourceVo.setMaxNoContinue(dsv.getTimes());

			return ApiResult.success(dataSourceVo);
		} catch (Exception e) {
			logger.error("错误" + e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}
	}

	private String dataToString(String[] dataList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dataList.length; i++) {
			if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
				sb.append(",");
			}
			sb.append(dataList[i]);
		}
		return sb.toString();
	}

	private boolean findStr(String[] args, String str) {
		for (String s : args) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}

	private double formatDouble(double d) {
		// 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
		BigDecimal bg = new BigDecimal(d).setScale(3, RoundingMode.UP);
		return bg.doubleValue();
	}

}
