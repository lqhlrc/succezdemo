package com.succez.wgetdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.succez.demo.File2buf;
import com.sun.jndi.toolkit.url.Uri;

/**
 * 日志打印错误信息
 * 创建类似wget工具
 * 实现支持接收http的url功能
 * @author candy
 * @createdate 2017-3-21
 */
public class WgetDemo {
	private static final Logger log = LoggerFactory.getLogger(File2buf.class);

	CloseableHttpClient httpClient = HttpClients.createDefault();

	private static String filepath = "D:\\Download\\13t58PICsap.jpg";

	/**
	 * 请求响应
	 * 文件存在返回HttpEntity
	 */
	public void downfile(String url) throws Exception {
		//get方式请求
		HttpGet httpGet = new HttpGet(url);
		//执行请求
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);;
		//得到响应后的实体对象
		HttpEntity entity = httpResponse.getEntity();
		//判断下载文件是否存在
		if (entity.getContentLength() <= 0) {
			log.info("下载的文件不存在");
			return;
		}
		/*Header h1 = httpResponse.getFirstHeader("Set-Cookie");
		Header headers[] = httpResponse.getAllHeaders();  
		Header head = httpResponse.getFirstHeader("Content-Disposition");
		String filename = null;
		if(head!=null){
			 HeaderElement[] values = head.getElements();
			 if(values.length == 1){
				 NameValuePair parm = values[0].getParameterByName("filename");
				 if(parm != null){
					 filename = parm.getValue();
				 }
			 }
		}
		log.info("该文件名是:"+filename);
		log.info("该文件的大小是"+entity.getContentLength());	
		*/
		//转化为输入流
		InputStream in = entity.getContent();
		//通过输出流输出到创建的文件夹中
		OutputStream out = new FileOutputStream(new File(filepath));
		savefile(in, out);
		//关闭流
		in.close();
		out.close();
		
		log.info("文件下载完成");
		//释放链接
		httpResponse.close();
		httpClient.close();
	}

	/**
	 * 保存文件信息
	 * 传递输入流
	 */
	public void savefile(InputStream in, OutputStream out) throws Exception {
		//接收文件
		byte[] data = new byte[1024];
		int index = 0;
		while ((index = in.read(data)) != -1) {
			out.write(data, 0, index);
		}
	}
}
