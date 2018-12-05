package com.sunxu.service.img;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sunxu.service.DataSourceService;
import com.sunxu.utils.LogicException;

@Service
public class DataSourceServiceImp implements DataSourceService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void getDataSource() throws LogicException {
		try {
			logger.info("调用成功");
		} catch (Exception e) {
			logger.error("错误"+e.getMessage().toString());
			throw new LogicException("查询数据报错");
		}

	}

}
