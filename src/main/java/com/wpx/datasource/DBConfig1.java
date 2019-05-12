package com.wpx.datasource;
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

/**
 * 将application.properties配置文件中配置自动封装到实体类字段中
 * @author Administrator
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.test1") // 注意这个前缀要和application.properties文件的前缀一样
public class DBConfig1 {
 
	private String url;
	private String username;
	private String password;
	private int minPoolSize;
	private int maxPoolSize;
	private int maxLifetime;
	private int borrowConnectionTimeout;
	private int loginTimeout;
	private int maintenanceInterval;
	private int maxIdleTime;
	private String testQuery;

}