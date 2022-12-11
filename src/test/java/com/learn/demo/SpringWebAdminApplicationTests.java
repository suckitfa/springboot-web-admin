package com.learn.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringWebAdminApplicationTests {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {
		long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl",long.class);
		log.info("记录总数 = {}",aLong);
		log.info("数据源={}",dataSource.getClass());
	}

}
