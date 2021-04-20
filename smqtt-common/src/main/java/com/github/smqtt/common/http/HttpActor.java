package com.github.smqtt.common.http;

import com.alibaba.fastjson.JSON;
import com.github.smqtt.common.spi.DynamicLoader;
import org.reactivestreams.Publisher;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author luxurong
 * @date 2021/4/16 20:47
 * @description
 */
@FunctionalInterface
public interface HttpActor {


    List<HttpActor> INSTANCE = DynamicLoader.findAll(HttpActor.class).collect(Collectors.toList());


    /**
     * 处理
     * 如何要处理GET请求query param reactor-netty是不支持的，需要自己去处理
     * QueryStringDecoder queryStringDecoder  = new QueryStringDecoder(request.uri());
     *
     * @param request  请求
     * @param response 响应
     * @return Object
     */
    Publisher<Void> doRequest(HttpServerRequest request, HttpServerResponse response);


    /**
     * json转换器
     *
     * @param tClass class
     * @return Function
     */
    default <T> Function<String, T> toJson(Class<T> tClass) {
        return message -> JSON.parseObject(message, tClass);
    }
}