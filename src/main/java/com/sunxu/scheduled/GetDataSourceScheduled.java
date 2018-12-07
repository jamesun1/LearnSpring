package com.sunxu.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sunxu.dao.DataSourceMapper;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.LogicException;

@Component
public class GetDataSourceScheduled {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSourceService dataSourceService;
	@Autowired
	private DataSourceMapper dataSourceMapper;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void getDataSourceScheduled() {
		try {
			dataSourceService.getDataSource(dataSourceMapper);
		} catch (LogicException e) {
			log.info("当前时间" + e.toString());
			e.printStackTrace();
		}
	}
}
