/**
 * @projectName jc-club
 * @package com.jingdianjichi.gateway.exception
 * @className com.jingdianjichi.gateway.exception.GatewayExceptionHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.gateway.exception;

import cn.dev33.satoken.exception.SaTokenException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jingdianjichi.gateway.entity.Result;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * GatewayExceptionHandler
 * @author zxf
 * @date 2024/7/1 23:08
 * @version 1.0
 */
@Component
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpResponse response = serverWebExchange.getResponse();
        Integer code = 200;
        String message = "成功";
        // 统一异常处理逻辑
        if (throwable instanceof SaTokenException){
            code = 401;
            message = "未登录/无权限";
        }else{
            code = 500;
            message = "系统异常";
        }

        Result<Object> result = Result.fail(code, message);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.fromSupplier(()->{
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            byte[] bytes;
            try {
                bytes = objectMapper.writeValueAsBytes(result);
                return dataBufferFactory.wrap(bytes);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }));
    }
}

