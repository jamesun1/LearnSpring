package com.sunxu.scheduled;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.LogicException;

@Component
public class GetDataSourceScheduled {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private DataSourceService dataSourceService;
	@Autowired
	private DataSourceProMapper dataSourceProMapper;
	

	@Scheduled(cron = "0 0/1 * * * ?")
	public void getDataSourceScheduled() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					dataSourceService.getDataSource(dataSourceProMapper);
				} catch (LogicException e) {
					log.warn(e.toString());
					e.printStackTrace();
				}
			}
		}, 300);
	}
}
