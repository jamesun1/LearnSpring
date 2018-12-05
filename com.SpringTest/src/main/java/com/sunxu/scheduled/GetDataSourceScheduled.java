package com.sunxu.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sunxu.service.DataSourceService;
import com.sunxu.utils.LogicException;

@Component
public class GetDataSourceScheduled {

	private Logger log = LoggerFactory.getLogger(getClass());
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private DataSourceService dataSourceService;

	@Scheduled(fixedRate = 1000 * 2)
	public void getDataSourceScheduled() {
		try {
//			log.info("当前时间" + dateFormat.format(new Date()));
			dataSourceService.getDataSource();
		} catch (LogicException e) {
			log.info("当前时间" + e.toString());
			e.printStackTrace();
		}
	}
}
