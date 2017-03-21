package com.succez.test;


import org.junit.Before;
import org.junit.Test;

import com.succez.demo.TreeDemo;


public class TreeDemoTests {
	TreeDemo tree;
	
	@Before
	public void dobefore(){
		char[] input = {'A', 'B','D','G','H','C','F'};
		tree = new TreeDemo(input);
	}
	@Test
	public void test3() {
		tree.treeLevel(tree.getRoot(), 3);
	}
	@Test
	public void test2() {
		tree.treeLevel(tree.getRoot(), 2);
	}
	@Test
	public void test1() {
		tree.treeLevel(tree.getRoot(), 1);
	}
	@Test
	public void test0() {
		tree.treeLevel(tree.getRoot(), 0);
	}
	@Test
	public void test4() {
		tree.treeLevel(tree.getRoot(), 4);
	}
}
