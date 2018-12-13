package com.tianci.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by tianci
 * 2018/11/21 16:11
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code,@RequestParam("state") String state) {
        log.info("进入auth的方法。。。");
        log.info("code={}", code);
        log.info("state={}",state);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx425947f54e41a408&secret=dc1a51b6ef532bc84f099c53057311e6&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
