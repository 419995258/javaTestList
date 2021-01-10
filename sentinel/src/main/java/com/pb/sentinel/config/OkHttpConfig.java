package com.pb.sentinel.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

/**
 * @Description okhttp3相关配置
 *
 */
@Configuration
@ConditionalOnProperty(value = "okhttp.enabled", havingValue = "true")
public class OkHttpConfig {

    /**
     * 最大连接数
     */
    @Value("${okhttp.pool.maxIdleConnections:200}")
    private Integer maxIdleConnections;

    /**
     * 连接池中空闲连接的保活时间（秒）
     */
    @Value("${okhttp.pool.keepAliveDuration:300}")
    private Integer keepAliveDuration;

    /**
     * 是否自动重连（毫秒）
     */
    @Value("${okhttp.retryOnConnectionFailure:false}")
    private boolean retryOnConnectionFailure;

    /**
     * 连接超时时间（毫秒）
     */
    @Value("${okhttp.connectTimeout:5000}")
    private long connectTimeout;

    /**
     * 读取超时时间（毫秒）
     */
    @Value("${okhttp.readTimeout:6000}")
    private long readTimeout;

    /**
     * 写超时时间（毫秒）
     */
    @Value("${okhttp.writeTimeout:3000}")
    private long writeTimeout;

    /**
     * 是否允许重定向
     */
    @Value("${okhttp.followRedirects:true}")
    private boolean followRedirects;

    /**
     * 连接池配置
     * @return
     */
    @Bean
    public ConnectionPool pool() {
        return new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS);
    }

    @Bean("okHttpClient")
    public OkHttpClient okHttpClient(@Qualifier("pool") ConnectionPool connectionPool) {
        return new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .followRedirects(followRedirects)
                .retryOnConnectionFailure(retryOnConnectionFailure)
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .build();
    }

}
