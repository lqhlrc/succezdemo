package com.succez.wgetdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
*@author
*@2017年3月22日
*类说明
*/
public class Download{  
    private String workPath = null;  
    private String downLoadUrl = null;  
    private DefaultHttpClient httpClient = new DefaultHttpClient();  
  
    public void downLoad(String url, String dst) {  
        try {  
        	System.out.println("aaa");
            HttpGet httpGet = new HttpGet(url);  
            HttpResponse httpResponse = httpClient.execute(httpGet);  
            HttpEntity entity = httpResponse.getEntity();  
            InputStream in = entity.getContent();  
            long length=entity.getContentLength();  
            if(length<=0){  
                System.out.println("下载文件不存在！");  
                return;  
            }  
            System.out.println("aaa");
            OutputStream out = new FileOutputStream(new File(dst));  
            saveTo(in, out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void saveTo(InputStream in, OutputStream out) throws Exception {  
        byte[] data = new byte[1024*1024];  
        int index =0;  
        while ((index=in.read(data) )!= -1) {  
            out.write(data,0,index);  
        }  
        in.close();  
        out.close();  
    }  
  
    public static void main(String args[]) {  
        Download downLoad = new Download();  
        String url = "http://www.gjt.org/download/time/java/tar/javatar-2.5.tar.gz";  
        downLoad.downLoad(url, "E:\\javatar-2.5.tar.gz");  
    }  
}  