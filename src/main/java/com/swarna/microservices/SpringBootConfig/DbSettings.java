package com.swarna.microservices.SpringBootConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration // to create as a Spring Bean
@ConfigurationProperties("db") // it will search in properties and pick those which starts with db
public class DbSettings {

	private String connection;
	private String host;
	private int port;
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
