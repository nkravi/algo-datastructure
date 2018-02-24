package leethcode.hard;

import java.util.HashMap;
import java.util.Map;

import leethcode.datastructure.RandomListNode;

/*
 * Hashtable a->a`,b->b'
 * 
 * head 
 * head'
 * 
 */

public class CopyListwithRandomPointer {
	
	
	
	
	public RandomListNode copyRandomList(RandomListNode head) {
		
		if(head == null) return null;
		RandomListNode dummyHead = new RandomListNode(-1);
		Map<RandomListNode,RandomListNode> map= new HashMap<>();
		
		for(RandomListNode node = head , nodeDash = dummyHead; node != null; node = node.next){
			nodeDash.next = new RandomListNode(node.label);
			nodeDash = nodeDash.next;
			map.put(node, nodeDash);
		}
		
		RandomListNode newHead = dummyHead.next;
		
		for(RandomListNode node = head , nodeDash = newHead; node != null; node = node.next,nodeDash= nodeDash.next){
			nodeDash.random = map.get(node.random);
		}
		
        return newHead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
