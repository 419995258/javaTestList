package com.pb.sentinel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import feign.Client;
import feign.Contract;
import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

/**
 * @Description feign okhttp配置本质上是依赖于OkHttpConfig类中对okhttp的初始化以及feign.okhttp.OkHttpClient包的引入
 * @Description 必须开启okhttp.enabled以及feign.okhttp.enabled
 */
@Configuration
@ConditionalOnProperty(value = "feign.okhttp.enabled")
@ConditionalOnClass({feign.okhttp.OkHttpClient.class, OkHttpClient.class})
@ConditionalOnBean(OkHttpClient.class)
public class OkHttpFeignConfig {

    private OkHttpClient okHttpClient;

    public OkHttpFeignConfig(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @PreDestroy
    public void destroy() {
        if(okHttpClient != null) {
            okHttpClient.dispatcher().executorService().shutdown();
            okHttpClient.connectionPool().evictAll();
        }
    }

    @Bean
    @ConditionalOnMissingBean(Client.class)
    public Client feignClient() {
        return new feign.okhttp.OkHttpClient(this.okHttpClient);
    }

}
