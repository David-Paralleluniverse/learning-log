package com.example.better.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


public class Poster {
    public JSONObject CreateIssueBalanceDetail(){

        //请求路径
        String url = "https://www.wmj.com.cn/api/oplock";
        //使用Restemplate来发送HTTP请求
        RestTemplate restTemplate = new RestTemplate();
        // json对象
        JSONObject jsonObject = new JSONObject();

        // LinkedMultiValueMap 有点像JSON，用于传递post数据，网络上其他教程都使用
        // MultiValueMpat<>来传递post数据
        // 但传递的数据类型有限，不能像这个这么灵活，可以传递多种不同数据类型的参数
        LinkedMultiValueMap body=new LinkedMultiValueMap();
        body.add("appid","wmj_Ki0c87F2q9C");
        body.add("appsecret","Re2hZ2zrGedoMewS9T6xya9QTxEg7k7A");
        body.add("sn","W26AB5D370F");

        //设置请求header 为 APPLICATION_FORM_URLENCODED
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 请求体，包括请求数据 body 和 请求头 headers
        HttpEntity httpEntity = new HttpEntity(body,headers);


        try {
            //使用 exchange 发送请求，以String的类型接收返回的数据
            //ps，我请求的数据，其返回是一个json
            ResponseEntity<String> strbody = restTemplate.exchange(url,HttpMethod.POST,httpEntity,String.class);
            //解析返回的数据
            JSONObject jsTemp = JSONObject.parseObject(strbody.getBody());
            System.out.println(jsonObject.toJSONString());
            return jsTemp;

        }catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
}

