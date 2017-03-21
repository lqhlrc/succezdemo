package com.succez.wgettest;



import org.junit.Test;

import com.succez.wgetdemo.WgetDemo;

public class WgetDemoTest{
	WgetDemo w = new WgetDemo(); 
	//存在文件
	@Test
	public void fileexist() {
		w.downfile("http://www.gjt.org/download/time/java/tar/javatar-2.5.tar.gz");
	}
	
	//不存在的情况
	@Test
	public void filenotexist(){
		w.downfile("http://www.bb.com");
	}
	//输入地址有误
	@Test
	public void urlerror(){
		w.downfile("ftp:ftp");
	}

}

