package com.manager.download.config;
import feign.codec.Encoder;


import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author sunli
 * @date 2020/5/14 17:38
 */
@Configuration
public class FeignSpringFormEncoder  {
    /**
     * Feign Spring 表单编码器
     * @return 表单编码器
     */
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartEncoder(){
        return new SpringFormEncoder();
    }
}
