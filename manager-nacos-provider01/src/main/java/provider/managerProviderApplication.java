package provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunli
 * @date 2020/3/14 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class managerProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(managerProviderApplication.class,args);
    }
}
