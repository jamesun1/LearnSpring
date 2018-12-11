package com.sunxu.service.imp;

import java.util.ArrayList;
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
			String number = dataSourceVo.getNumber();
			String issueNum = dataSourceVo.getIssue();
			List<DataSource> dataSourceList = dataSourceMapper.getDataSource(issueNum);
			List<List<String>> dataList = new ArrayList<>();
			for (DataSource item : dataSourceList) {
				List<String> data = new ArrayList<>();
				String issue = item.getIssue();
				String first = item.getFirst();
				if (first.equals(number)) {
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

			double winningRate = win / Double.valueOf(issueNum) * 100;

			dataSourceVo.setWinningRate(winningRate);
			dataSourceVo.setDataList(dataList);

			return ApiResult.success(dataSourceVo);
		} catch (Exception e) {
			logger.error("错误" + e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}
	}

}
