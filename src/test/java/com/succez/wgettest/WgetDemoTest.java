package com.succez.wgettest;



import org.junit.Test;

import com.succez.wgetdemo.WgetDemo;

public class WgetDemoTest{
	WgetDemo w = new WgetDemo(); 
	//存在文件
	@Test
	public void docDownload() throws Exception{
		w.downfile("http://pic.qiantucdn.com/58pic/11/79/85/13t58PICsap.jpg");
	}
	
	//不存在的情况
	@Test
	public void filenotexist() throws Exception{
		w.downfile("http://www.bb.com");
	}
	//输入地址有误
	@Test
	public void urlerror() throws Exception{
		w.downfile("ftp://ftp.succez.com");
	}

}

