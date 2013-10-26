/**
 * 
 */
package com.dreamslab.concurrent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Frank Zhang
 *
 */
public class ExecutorsTest {

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

	/**
	 * Test method for {@link java.util.concurrent.Executors#newFixedThreadPool(int)}.
	 */
	@Test
	public void testNewFixedThreadPoolInt() {
		java.util.concurrent.ExecutorService es =  java.util.concurrent.Executors.newFixedThreadPool(10);
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newFixedThreadPool(int, java.util.concurrent.ThreadFactory)}.
	 */
	@Test
	public void testNewFixedThreadPoolIntThreadFactory() {
		////fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newSingleThreadExecutor()}.
	 */
	@Test
	public void testNewSingleThreadExecutor() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newSingleThreadExecutor(java.util.concurrent.ThreadFactory)}.
	 */
	@Test
	public void testNewSingleThreadExecutorThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newCachedThreadPool()}.
	 */
	@Test
	public void testNewCachedThreadPool() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newCachedThreadPool(java.util.concurrent.ThreadFactory)}.
	 */
	@Test
	public void testNewCachedThreadPoolThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newSingleThreadScheduledExecutor()}.
	 */
	@Test
	public void testNewSingleThreadScheduledExecutor() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newSingleThreadScheduledExecutor(java.util.concurrent.ThreadFactory)}.
	 */
	@Test
	public void testNewSingleThreadScheduledExecutorThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newScheduledThreadPool(int)}.
	 */
	@Test
	public void testNewScheduledThreadPoolInt() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#newScheduledThreadPool(int, java.util.concurrent.ThreadFactory)}.
	 */
	@Test
	public void testNewScheduledThreadPoolIntThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#unconfigurableExecutorService(java.util.concurrent.ExecutorService)}.
	 */
	@Test
	public void testUnconfigurableExecutorService() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#unconfigurableScheduledExecutorService(java.util.concurrent.ScheduledExecutorService)}.
	 */
	@Test
	public void testUnconfigurableScheduledExecutorService() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#defaultThreadFactory()}.
	 */
	@Test
	public void testDefaultThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#privilegedThreadFactory()}.
	 */
	@Test
	public void testPrivilegedThreadFactory() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#callable(java.lang.Runnable, java.lang.Object)}.
	 */
	@Test
	public void testCallableRunnableT() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#callable(java.lang.Runnable)}.
	 */
	@Test
	public void testCallableRunnable() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#callable(java.security.PrivilegedAction)}.
	 */
	@Test
	public void testCallablePrivilegedActionOfQ() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#callable(java.security.PrivilegedExceptionAction)}.
	 */
	@Test
	public void testCallablePrivilegedExceptionActionOfQ() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#privilegedCallable(java.util.concurrent.Callable)}.
	 */
	@Test
	public void testPrivilegedCallable() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.Executors#privilegedCallableUsingCurrentClassLoader(java.util.concurrent.Callable)}.
	 */
	@Test
	public void testPrivilegedCallableUsingCurrentClassLoader() {
		//fail("Not yet implemented"); // TODO
	}

}
