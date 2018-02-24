package leethcode.hard;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class LRUCacheTests {
	
	DoublyLinkedList dd;
	LRUCache cache;
	
	@Before
	public void setUp(){
		dd = new DoublyLinkedList();
		cache = new LRUCache(2);
		
	}
	@Test
	public void testDDSize() {
		assertEquals(0, dd.size());
		Node node = new Node(1,1,null,null);
		dd.addToHead(node);
		assertEquals(1, dd.size());
		dd.deleteFromTail();
		assertEquals(0, dd.size());
	}
	@Test
	public void testDDAddToHead() {
		Node node1 = new Node(1,1);
		Node node2 = new Node(2,2);
		dd.addToHead(node1);
		dd.addToHead(node2);
		assertEquals(node2,dd.head);
	}
	@Test
	public void testDDDeleteFromTail() {
		Node node1 = new Node(1,1);
		Node node2 = new Node(2,2);
		dd.addToHead(node1);
		dd.addToHead(node2);
		dd.deleteFromTail();
		assertEquals(node2,dd.tail);
	}
	@Test
	public void testDDDelete() {
		Node node1 = new Node(1,1);
		Node node2 = new Node(2,2);
		Node node3 = new Node(3,3);
		dd.addToHead(node3);
		dd.addToHead(node2);
		dd.addToHead(node1);
		dd.delete(node2);
		assertEquals(1, dd.head.val);
		assertEquals(3,dd.tail.val);
		assertEquals(2,dd.size());
	}
	@Test
	public void testLRUCache() {
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(1,cache.get(1));
		cache.put(3, 3);
		//System.out.println(cache.maxSize);
		assertEquals(-1,cache.get(2));
		//System.out.println(cache.map.size());
		cache.put(4, 4);
		//System.out.println(cache.map.size());
		assertEquals(-1,cache.get(1));
	}

}
