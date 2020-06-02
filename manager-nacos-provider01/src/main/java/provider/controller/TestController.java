package provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sunli
 * @date 2020/3/14 16:41
 */
@RestController
@RefreshScope // 支持nacos的动态刷新
public class TestController {

    @Value(value = "${server.port}")
    Integer port;

    @Autowired
    private ConfigurableApplicationContext applicationContext;



    @GetMapping(value = "/echo/{id}")
    public String test(@PathVariable String id) {
        return "hello nacos id:"+ id + "-- port:" + port;
    }
}
