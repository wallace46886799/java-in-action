/**
 * 
 */
package com.dreamslab.string;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Frank Zhang
 *
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "123";
		
		if(s=="123"){
			System.out.println(Boolean.TRUE);
		}
		
		if(s.substring(1)=="23"){
			System.out.println(Boolean.TRUE);
		}else{
			System.out.println(Boolean.FALSE);
		}
		//^���
		System.out.println(31^2);
		
//		int i = s.length();
//		
//		s.codePointAt(1);
	}
	
	

	
	@Test
	public void testConstantsTunning(){
		
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		
		char data[] = {'a', 'b', 'c'};
		String s4 = new String(data);
				
		
		Assert.assertTrue("s1 is same as s2", s1==s2);
				
		Assert.assertFalse("s1 is not same as s2", s1==s3);
		
		Assert.assertTrue("s1 is same as s2", s1==s3.intern());
		
		//Assert.assertTrue("s1 is same as s4", s1==s4);
	}
	
	
	
	/**
	 * String 的substring引起的OOM
	 */
	@Test
	@Ignore
	public void testSubString(){
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < 1000;i++){
			String s = new String(new char[1024*1024]);
			list.add(s.substring(10,15));
		}
	}
	
	
	/**
	 * 通过构造新的String，使substring返回的对象对应的原有对象失去强引用
	 */
	@Test
	@Ignore
	public void testSubString1(){
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < 1000;i++){
			String s = new String(new char[1024*1024]);
			list.add(new String(s.substring(10,15)));
		}
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	@Test
	public void testImmutable(){
		
	}

}
