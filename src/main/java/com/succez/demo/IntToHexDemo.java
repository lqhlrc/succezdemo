package com.succez.demo;
/**
 * 十进制转化为十六进制
 * <p>Copyright: Copyright (c) 2017<p>
 * <p>succez<p>
 * @author candy
 * @createdate 2017年3月21日
 */
public class IntToHexDemo{
	/**
	 * 输入一个整形参数a时，讲a转化为十六进制的字符串
	 * @param a
	 */
	public void inttohex(int a){
		System.out.println("十进制整数"+a+"转化为十六进制后的结果是：");
		//转换为16进制后的字符串
		StringBuilder hex = new StringBuilder("");
		//字符数组为转化为16进制的取值集合
		char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		/*
		 * 循环取余判断传入的数字a转为16进制后的各位数字
		 * 循环取整判断传入的数字a转为16进制后的位数
		 */
		while(true){
			hex.insert(0,c[a%16]);
			a = a/16;
			if(a==0){
				break;
			}
		}
		System.out.println(hex);
	}
}