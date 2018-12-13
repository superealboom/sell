package com.tianci.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by tianci
 * 2018/11/27 16:05
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mchId;
    private String mchKey;
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;
}
