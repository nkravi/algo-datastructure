package leethcode.hard;


import java.util.HashMap;
import java.util.Map;


class Node{
	int val;
	int key;
	Node prev;
	Node next;
	Node (int key,int val){
		this(key,val,null,null);
	}
	Node(int key,int val,Node prev,Node next){
		this.key = key;
		this.val = val;
		this.prev = prev;
		this.next = next;
	}
}

class DoublyLinkedList{
	Node head;
	Node tail;
	int len;
	
	DoublyLinkedList(){
		this.len = 0;
		this.head = this.tail = null;
	}
	
	public void addToHead(Node node){
		if(node == null) return;
		if(head == null) {
			head = tail = node;
		}else {
			Node tmp = head;
			head = node;
			head.prev = null;
			head.next = tmp;
			tmp.prev = head;
		}
		len++;
	}
	
	public void deleteFromTail() {
		this.delete(tail);
	}
	
	public void delete(Node node) {
		if(node == null) return;
		Node before = node.prev;
		Node after = node.next;
		if(before == null && after == null) {
			head=tail=null;
		}else if(before == null) {
			head = after;
			head.prev = null;
		}else if(after == null) {
			tail = before;
			tail.next = null;
		}else {
			before.next = after;
			after.prev = before;
		}
		len--;
	}
	
	public int size() {
		return this.len;
	}
}

public class LRUCache {
	int maxSize;
	Map<Integer,Node> map;
	DoublyLinkedList dd;
	
	public LRUCache(int capacity) {
		map= new HashMap<>();
        dd = new DoublyLinkedList();
        maxSize = capacity;
    }
    
    public int get(int key) {
    	if(!map.containsKey(key)) {
    		return -1;
    	}
    	Node node = map.get(key);
    	dd.delete(node);
    	Node newNode = new Node(node.key,node.val);
    	dd.addToHead(newNode);
    	map.put(key, newNode);
    	return node.val;
    }
    
    public void put(int key, int value) {
    	if(get(key) == -1) {
    		if(map.size() == maxSize) {
    			Node tmp = dd.tail;
    			dd.deleteFromTail();
    			map.remove(tmp.key);
    		}
    		Node newNode = new Node(key,value);
    		dd.addToHead(newNode);
    		map.put(key, newNode);
    	}else {
    		Node node = map.get(key);
    		node.val = value;
    		map.put(key, node);
    	}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DoublyLinkedList dd = new DoublyLinkedList();
		

	}
}
