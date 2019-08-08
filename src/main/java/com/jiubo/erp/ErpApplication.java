package com.jiubo.erp;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.quicksand.push.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

<<<<<<< HEAD
import javax.sql.DataSource;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 2ab5291f6237c1027474381cf19c70c9073a1e0a

/* *
 * @desc:springboot程序入口
 * 当使用外部部署时（即打包成war时）需要继承SpringBootServletInitializer并重写configure方法
 * @author: dx
 * @date: 2019-08-01 14:17:57
 * @param null :
 * @return:
 * @throws:
 * @version: 1.0
 **/
@SpringBootApplication
//开启事务管理
@EnableTransactionManagement
//扫描mapper
@MapperScan("com.jiubo.erp.*.dao")
public class ErpApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
		//外部部署方式 需要将SpringApplication.run(ErpApplication.class, args);注释(可以直接使用上面的即可无需改变，原因不明)
		//new SpringApplicationBuilder(ErpApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

	//打包成war时需重写此方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(ErpApplication.class);
	}


	// 创建事务管理器1
//	@Bean(name = "txManager")  //给事务管理器命名
//	public PlatformTransactionManager txManager(DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}


	//分页插件
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		//List<ISqlParser> sqlParserList = new ArrayList<>();
		// 攻击 SQL 阻断解析器、加入解析链
		//sqlParserList.add(new BlockAttackSqlParser());
		//paginationInterceptor.setSqlParserList(sqlParserList);
		return paginationInterceptor;
	}

	//注册过滤器
	@Bean
	public FilterRegistrationBean registFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CorsFilter());
		registration.addUrlPatterns("/*");
		registration.setName("CorsFilter");
		registration.setOrder(1);
		return registration;
	}
}

//性能监控(打包发布时请将此注释)
//	@Bean
//@Profile({"dev","test"})// 设置 dev test 环境开启（由于没有设置开发，测试环境故此选项不适用）
//	public PerformanceInterceptor performanceInterceptor() {
//		return  new PerformanceInterceptor();
//	}
