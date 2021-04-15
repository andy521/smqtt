package com.github.smqtt.cluster.base;

import java.util.List;
import java.util.Map;

/**
 * @author luxurong
 * @date 2021/4/8 14:42
 * @description
 */
public interface ClusterConfig {


    /**
     * 获取地址
     *
     * @return String
     */
    String getAddress();


    /**
     * 获取端口
     *
     * @return Integer
     */
    Integer getPort();


    /**
     * 获取节点名称
     *
     * @return String
     */
    String getNodeName();


    /**
     * 获取集群配置信息
     *
     * @return Map
     */
    Map<String, Object> getOptions();


    /**
     * 获取集群Url
     *
     * @return Map
     */
    List<String> getClusterUrl();

}