package com.succez.test;


import org.junit.Test;

import com.succez.demo.IntToHexDemo;


public class IntToHexDemoTest {
	
	IntToHexDemo ithd = new IntToHexDemo();
	@Test
	public void test18() {
		ithd.inttohex(18);
	}
	@Test 
	public void test10(){
		ithd.inttohex(10);
	}
	@Test
	public void test8(){
		ithd.inttohex(8);
	}
	@Test
	public void test15(){
		ithd.inttohex(15);
	}
	@Test
	public void test16(){
		ithd.inttohex(16);
	}
}
