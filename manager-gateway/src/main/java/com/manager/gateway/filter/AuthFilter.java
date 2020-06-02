package com.manager.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.manager.commons.HttpStatus;
import com.manager.commons.TokenUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 *
 * gateway拦截器
 * token检验全局Filter
 * @author sunli
 * @date 2020/3/24 0:19
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    // 排除过滤的 uri 地址
    private static final String[] WHITE_LIST = {
            "/**/auth/user/**"
    };

    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String uriPath = request.getPath().pathWithinApplication().value();

        boolean action = false;
        for (String url : WHITE_LIST) {
            if (antPathMatcher.match(url, uriPath)) {
                action = true;
                break;
            }
        }
        // 跳过不需要验证的路径
        if (action) {
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (null == token || token.isEmpty()) {
            ServerHttpResponse response = exchange.getResponse();
            //当请求不携带Token或者token为空时，直接设置请求状态码为401，返回
            InetSocketAddress remoteAddress = request.getRemoteAddress();
            String clientIp = Objects.requireNonNull(remoteAddress).getAddress().getHostAddress();
            JSONObject message = new JSONObject();
            // 非法请求
            message.put("code", HttpStatus.ILLEGAL_REQUEST);
            message.put("msg", "非法请求");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));

        }
        if (TokenUtils.parseJwtToken(token)) {
            return chain.filter(exchange);
        } else {
            ServerHttpResponse response = exchange.getResponse();
            //当请求不携带Token或者token为空时，直接设置请求状态码为401，返回
            InetSocketAddress remoteAddress = request.getRemoteAddress();
            String clientIp = Objects.requireNonNull(remoteAddress).getAddress().getHostAddress();
            JSONObject message = new JSONObject();
            // 非法请求
            message.put("code", HttpStatus.TP_FAILED_TOKEN);
            message.put("msg", "token无效");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(org.springframework.http.HttpStatus.OK);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
//        ServerHttpRequest authorization = request.mutate().headers(httpHeaders -> {
//            httpHeaders.add("Authorization", token);
//        }).build();
//        ServerWebExchange serverWebExchange = exchange.mutate().request(authorization).build();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
