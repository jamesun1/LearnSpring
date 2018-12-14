package com.sunxu.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sunxu.dao.DataSourceMapper;
import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.dao.HistoryInfoMapper;
import com.sunxu.entity.DataSource;
import com.sunxu.entity.HistoryInfo;
import com.sunxu.entity.PageBean;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.GetHttpUtil;
import com.sunxu.utils.LogicException;
import com.sunxu.utils.Utils;
import com.sunxu.vo.DataSourceVo;

@Service
public class DataSourceServiceImp implements DataSourceService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSourceMapper dataSourceMapper;
	@Autowired
	private HistoryInfoMapper historyInfoMapper;

	@Override
	public void getDataSource(DataSourceProMapper dataSourceProMapper, DataSourceMapper dataSourceMapper,
			HistoryInfoMapper historyInfoMapper) throws LogicException {
		try {
			GetHttpUtil getHttpUtil = new GetHttpUtil();
			getHttpUtil.getHttpUtil(dataSourceProMapper, dataSourceMapper, historyInfoMapper);
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
				if (Utils.findStr(number, first)) {
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

			double winningRate = Utils.formatDouble(win / Double.valueOf(dataSourceList.size()) * 100);

			dataSourceVo.setWinningRate(winningRate);
			dataSourceVo.setDataList(dataList);

			String str = Utils.dataToString(number);

			DataSourceVo dsv = new DataSourceVo();
			dsv = dataSourceMapper.getContinuousDataSource(issueNum, str);
			dataSourceVo.setMaxContinue(dsv.getTimes());

			dsv = dataSourceMapper.getNotContinuousDataSource(issueNum, str);
			dataSourceVo.setMaxNoContinue(dsv.getTimes());

			dsv = dataSourceMapper.getCurrentNotContinuousDataSource(issueNum, str);
			dataSourceVo.setCurrentNoContinue(dsv.getTimes());

			List<List<String>> dataSourceVoList = dataSourceMapper.getAllCurrentNotCon(issueNum);
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

			dataSourceVo.setFourMax(fourMax);
			dataSourceVo.setFiveMax(fiveMax);
			dataSourceVo.setSixMax(sixMax);

			String lastNum = dataSourceMapper.selectLastNum();
			dataSourceVo.setLastNum(lastNum);
			return ApiResult.success(dataSourceVo);
		} catch (Exception e) {
			logger.error("错误" + e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}
	}

	@Override
	public ApiResult getDataSourceByType(PageBean<String> params) throws LogicException {
		try {
			PageHelper.startPage(params.getStartIndex(), params.getPageSize());
			String type = params.getParmas();
			List<HistoryInfo> historyInfoList = historyInfoMapper.getDataSourceByType(type);
			Integer count = historyInfoMapper.selectCountByType(type);
			return ApiResult.success(
					new PageBean<HistoryInfo>(params.getStartIndex(), params.getPageSize(), count, historyInfoList));
		} catch (Exception e) {
			logger.error("错误" + e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}
	}

}
