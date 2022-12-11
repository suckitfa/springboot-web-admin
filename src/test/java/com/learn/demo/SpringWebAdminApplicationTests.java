package com.learn.demo;

import com.learn.demo.bean.User;
import com.learn.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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
	UserMapper userMapper;
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {
		long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl",long.class);
		log.info("记录总数 = {}",aLong);
		log.info("数据源={}",dataSource.getClass());
	}

	@Test
	void testUserMapper() {
		User user = userMapper.selectById(1L);
		log.info("用户 = {}",user.toString());
		System.out.println(user.toString());

	}

}
