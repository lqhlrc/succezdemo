package com.succez.test;



import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.succez.demo.File2buf;



public class File2bufTest {
	File2buf f;

	@Before
	public void dobefore(){
		f = new File2buf();
	}
	@Test
	public void testFile2bufexist() { 
		f.file2buf(new File("E:\\Test.txt"));
	}
	@Test
	public void testFile2bufnotexist() { 
		f.file2buf(new File("D:\\Test.txt"));
	}
	@Test
	public void testFile2bufnodata() { 
		f.file2buf(new File("E:\\Test1.txt"));
	}
	@Test
	public void testFile2bufhasdata() { 
		f.file2buf(new File("E:\\Test.txt"));
	}

}
