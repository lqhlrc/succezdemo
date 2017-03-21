package com.succez.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 实现文件的读取，并将数据转化为byte数组
 * <p>Copyright: Copyright (c) 2017<p>
 * <p>succez<p>
 * @author candy
 * @createdate 2017年3月21日
 */
public class File2buf {
	private static final Logger log =  LoggerFactory.getLogger(File2buf.class);
	/**
	 * 传入的fobj是所访问的文件对象
	 * 文件内容转换成byte数组返回，如果文件不存在或者读入错误则返回null;
	 */
	public static byte[] file2buf(File fobj){
		byte[] f = null;//存储文件数据的字节数组
		//读取文件并存入到输入流中
		FileInputStream fis = null;
		//创建字节数组输出流
		ByteArrayOutputStream bos = null;
		String str ;
		/*
		 * 判断fobj对象是否为文件，是否存在
		 * 不存在则返回null，否则进行读取操作
		 */
		if(!fobj.isFile()&&!fobj.isFile()){
			log.info("沒有該文件");
			return null;
		}else{
			try {
				fis = new FileInputStream(fobj);
				bos = new ByteArrayOutputStream(1000);
				byte[] b = new byte[1024];
				int n=0;
				while((n = fis.read(b)) != -1) {
					//写入字节数组输出流
				    bos.write(b, 0, n);
				}
				//获取缓冲字节数组流的数据
				f = bos.toByteArray();
				//读取txt文件里面的内容编码类型是gbk
				str = new String(f,"gbk");
				System.out.println(str);
			} catch (IOException e) {
				//log4j打印错误信息
				log.info("文件讀取出錯");  
			}finally{
			//判断流是否为空，关闭流，节省空间				 
				if(fis!=null){
					try {
						fis.close();
					} catch (IOException e) {
						//log4j打印错误信息
						log.info("文件操作出錯");  
					}
				}
				if(bos!=null){
					try {
						bos.close();
					} catch (IOException e) {
						//log4j打印错误信息
						log.info("操作出現錯誤");  
					}
				}
			}
		}
		return f;
	}
}

