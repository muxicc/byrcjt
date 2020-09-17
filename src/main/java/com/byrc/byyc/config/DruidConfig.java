package com.byrc.byyc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控:相当于web.xml
    //因为springboot内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //后台需要有人登录
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");//登录key是固定的，loginUsername   loginPassword
        initParameters.put("loginPassword","123456");

        //允许谁能访问
        initParameters.put("allow","");//为空则代表所有人能访问

        //禁止谁能访问
        initParameters.put("admin","http://localhost:8081/");

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //Filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParameters=new HashMap<>();


        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        return bean;

    }

}
