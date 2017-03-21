package com.succez.wgetdemo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.succez.demo.File2buf;

/**
 * 
 * 创建类似wget工具
 * 实现支持接收http的url功能
 * @author candy
 * @createdate 2017-3-21
 */
public class WgetDemo{
	private static final Logger log =  LoggerFactory.getLogger(File2buf.class);
	
	String h1 = null;
	
    HttpClient httpClient = new DefaultHttpClient();  

    /**
     * 请求响应
     * 文件存在返回HttpEntity
     */
    public String downfile(String url) {  
    	HttpGet httpGet;
    	HttpResponse httpResponse;
    	HttpEntity entity;
    	try {  
          	//通过get方式提交请求
            httpGet = new HttpGet(url);  
            //执行请求
            httpResponse = httpClient.execute(httpGet);  
            //得到响应后的实体对象
            entity = httpResponse.getEntity();   
            //通过获取实体的长度判断下载文件是否存在
            if(entity.getContentLength() <= 0){  
            	log.info("下载的文件不存在"); 
                return null;  
            }  
            h1 = httpResponse.toString();
            System.out.println(h1); 
            } catch (Exception e) {  
            	log.info("您输入的地址有误！");
            }  
    	return h1;
        }  

 }  
