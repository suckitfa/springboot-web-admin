package com.learn.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

// 配置自己的数据源 ,在这里使用Druid
@Configuration
public class MyDataSourceConfig {
    // 绑定配置文件中的属性
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource () {
        return new DruidDataSource();
    }

    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean(statViewServlet,"/druid/**");
        return registrationBean;
    }
}
