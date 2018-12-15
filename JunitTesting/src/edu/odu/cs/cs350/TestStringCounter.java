
package edu.odu.cs.cs350;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;



/**
 * @author zeil
 *
 */
public class TestStringCounter {
	
	
	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#StringCounter()}.
	 */
	@Test
	public void testStringCounter() {
		StringCounter sc = new StringCounter();
		assertEquals (0, sc.size());
		assertTrue (sc.isEmpty());
		assertFalse (sc.containsKey("abc"));
		assertEquals (0, sc.get("abc"));
		assertEquals (0, sc.keySet().size());
		assertFalse (sc.iterator().hasNext());
		assertEquals (new StringCounter(), sc);
		@SuppressWarnings("unused")
		int k = sc.hashCode(); // should not crash
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#add(java.lang.String, int)}.
	 */
	@Test
	public void testAdd() {
		StringCounter sc = new StringCounter();
		sc.add("abc", 5);
		sc.add("def", 4);
		sc.add("ABC", 3);
		sc.add("abc", -2);
		sc.add("ABC", -3);
		
		assertEquals (2, sc.size());
		assertFalse (sc.isEmpty());
		assertTrue (sc.containsKey("abc"));
		assertTrue (sc.containsKey("def"));
		assertFalse (sc.containsKey("ABC"));
		assertEquals (3, sc.get("abc"));
		assertEquals (4, sc.get("def"));
		assertEquals (0, sc.get("ABC"));
		Set<String> kset = sc.keySet();
		assertEquals (2, kset.size());
		assertTrue (kset.contains("abc"));
		assertTrue (kset.contains("def"));
		
		Iterator<String> it = sc.iterator();
		assertTrue (it.hasNext());
		assertEquals("abc", it.next());
		assertTrue (it.hasNext());
		assertEquals("def", it.next());
		assertFalse (it.hasNext());

		assertNotEquals (new StringCounter(), sc);
		assertNotEquals (new StringCounter().hashCode(), sc.hashCode());
		
		StringCounter other = new StringCounter();
		other.add ("abc", 3);
		other.add ("def", 4);
		assertEquals (other, sc);
		
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#increment(java.lang.String)}.
	 */
	@Test
	public void testIncrement() {
		StringCounter sc = new StringCounter();
		sc.increment("def");
		sc.increment("abc");
		sc.increment("abc");
		
		assertEquals (2, sc.size());
		assertFalse (sc.isEmpty());
		assertTrue (sc.containsKey("abc"));
		assertTrue (sc.containsKey("def"));
		assertFalse (sc.containsKey("ABC"));
		assertEquals (2, sc.get("abc"));
		assertEquals (1, sc.get("def"));
		assertEquals (0, sc.get("ABC"));
		Set<String> kset = sc.keySet();
		assertEquals (2, kset.size());
		assertTrue (kset.contains("abc"));
		assertTrue (kset.contains("def"));
		
		Iterator<String> it = sc.iterator();
		assertTrue (it.hasNext());
		assertEquals("abc", it.next());
		assertTrue (it.hasNext());
		assertEquals("def", it.next());
		assertFalse (it.hasNext());

		assertNotEquals (new StringCounter(), sc);
		assertNotEquals (new StringCounter().hashCode(), sc.hashCode());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#decrement(java.lang.String)}.
	 */
	@Test
	public void testDecrement() {
		StringCounter sc = new StringCounter();
		sc.increment("abc");
		sc.decrement("def");
		sc.decrement("abc");
		
		assertEquals (1, sc.size());
		assertFalse (sc.isEmpty());
		assertFalse (sc.containsKey("abc"));
		assertTrue (sc.containsKey("def"));
		assertEquals (0, sc.get("abc"));
		assertEquals (-1, sc.get("def"));
		Set<String> kset = sc.keySet();
		assertEquals (1, kset.size());
		assertFalse (kset.contains("abc"));
		assertTrue (kset.contains("def"));
		
		Iterator<String> it = sc.iterator();
		assertTrue (it.hasNext());
		assertEquals("def", it.next());
		assertFalse (it.hasNext());

		assertNotEquals (new StringCounter(), sc);
		assertNotEquals (new StringCounter().hashCode(), sc.hashCode());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#clear()}.
	 */
	@Test
	public void testClear() {
		StringCounter sc = new StringCounter();
		sc.add("abc", 5);
		sc.add("def", 4);
		sc.add("ABC", 3);
		sc.add("abc", -2);
		sc.add("ABC", -3);
		sc.clear();
		assertEquals (0, sc.size());
		assertTrue (sc.isEmpty());
		assertFalse (sc.containsKey("abc"));
		assertEquals (0, sc.get("abc"));
		assertEquals (0, sc.keySet().size());
		assertFalse (sc.iterator().hasNext());
		assertEquals (new StringCounter(), sc);
		@SuppressWarnings("unused")
		int k = sc.hashCode(); // should not crash		
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.StringCounter#clone()}.
	 */
	@Test
	public void testClone() {
		StringCounter sc0 = new StringCounter();
		sc0.add("abc", 5);
		sc0.add("def", 4);
		sc0.add("ABC", 3);
		sc0.add("abc", -2);
		sc0.add("ABC", -3);
		StringCounter sc = (StringCounter)sc0.clone();
		assertEquals (2, sc.size());
		assertFalse (sc.isEmpty());
		assertTrue (sc.containsKey("abc"));
		assertTrue (sc.containsKey("def"));
		assertFalse (sc.containsKey("ABC"));
		assertEquals (3, sc.get("abc"));
		assertEquals (4, sc.get("def"));
		assertEquals (0, sc.get("ABC"));
		Set<String> kset = sc.keySet();
		assertEquals (2, kset.size());
		assertTrue (kset.contains("abc"));
		assertTrue (kset.contains("def"));
		
		Iterator<String> it = sc.iterator();
		assertTrue (it.hasNext());
		assertEquals("abc", it.next());
		assertTrue (it.hasNext());
		assertEquals("def", it.next());
		assertFalse (it.hasNext());

		assertEquals (sc0, sc);
		assertNotSame (sc0, sc);
		
		sc0.add("def", 1);
		assertNotEquals (sc0, sc);
		
		@SuppressWarnings("unused")
		int k = sc.hashCode();
	}

}