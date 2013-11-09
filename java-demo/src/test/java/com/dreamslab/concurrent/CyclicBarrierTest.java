/**
 * 
 */
package com.dreamslab.concurrent;

import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Frank
 *
 */
public class CyclicBarrierTest {

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
	 * Test method for {@link java.util.concurrent.CyclicBarrier#getParties()}.
	 */
	@Test
	public final void testGetParties() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.CyclicBarrier#await()}.
	 */
	@Test
	public final void testAwait() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.CyclicBarrier#await(long, java.util.concurrent.TimeUnit)}.
	 */
	@Test
	public final void testAwaitLongTimeUnit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.CyclicBarrier#isBroken()}.
	 */
	@Test
	public final void testIsBroken() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.CyclicBarrier#reset()}.
	 */
	@Test
	public final void testReset() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.util.concurrent.CyclicBarrier#getNumberWaiting()}.
	 */
	@Test
	public final void testGetNumberWaiting() {
		fail("Not yet implemented"); // TODO
	}
	
	// 徒步需要的时间: Shenzhen, Guangzhou, Shaoguan, Changsha, Wuhan 
		private static int[] timeWalk = { 5, 8, 15, 15, 10 }; 
		// 自驾游 
		private static int[] timeSelf = { 1, 3, 4, 4, 5 }; 
		// 旅游大巴 
		private static int[] timeBus = { 2, 4, 6, 6, 7 }; 
		
	@Test
	public final void testTourCyclicBarrier() throws InterruptedException, BrokenBarrierException {
		
//		SelfTour reached SZ at 2013-11-05 11:35:42
//		BusTour reached SZ at 2013-11-05 11:35:43
//		WalkTour reached SZ at 2013-11-05 11:35:46
		
//		SelfTour reached GZ at 2013-11-05 11:35:49
//		BusTour reached GZ at 2013-11-05 11:35:50
//		WalkTour reached GZ at 2013-11-05 11:35:54
		
//		SelfTour reached CS at 2013-11-05 11:35:58
//		BusTour reached CS at 2013-11-05 11:36:00
//		WalkTour reached CS at 2013-11-05 11:36:09
		
//		SelfTour reached WH at 2013-11-05 11:36:13
//		BusTour reached WH at 2013-11-05 11:36:15
//		WalkTour reached WH at 2013-11-05 11:36:24
		
	
		
		CyclicBarrier barrier = new CyclicBarrier(3); 
		ExecutorService exec = Executors.newFixedThreadPool(3); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = sdf.format(new Date());
		System.out.println("========Start at "+start+"========");
		
		exec.submit(new Tour(barrier, "WalkTour", timeWalk)); 
		exec.submit(new Tour(barrier, "SelfTour", timeSelf)); 
		exec.submit(new Tour(barrier, "BusTour", timeBus)); 
		
		
		Thread.sleep(60*1000);
		
		String end = sdf.format(new Date());
		
		System.out.println("========End at "+end+"========");
	
		exec.shutdown(); 
	}
	
	
	

}


class Tour implements Runnable{
	
	/**
	 * @param cb
	 * @param name
	 * @param times
	 */
	public Tour(CyclicBarrier cb, String name, int[] times) {
		super();
		this.cb = cb;
		this.name = name;
		this.times = times;
	}

	private CyclicBarrier cb = null;
	private String name;
	private int[] times;
	
	private String now(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(times[0]*1000);
			System.out.println(name+" reached SZ at "+now());
			cb.await();

			Thread.sleep(times[1]*1000);
			System.out.println(name+" reached GZ at "+now());
			cb.await();

			Thread.sleep(times[2]*1000);
			System.out.println(name+" reached CS at "+now());
			cb.await();

			Thread.sleep(times[3]*1000);
			System.out.println(name+" reached WH at "+now());
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}


