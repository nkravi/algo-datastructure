package leethcode.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode arrayToListNode(int[] vals){
	
		ListNode node = null;
		ListNode ptr = new ListNode(1);
		ListNode headDummy = ptr;
		for(int val : vals){
			node = new ListNode(val);
			ptr.next = node;
			ptr = ptr.next;
		}
		return headDummy.next;
	}
	public static void printNodes(ListNode head){
		System.out.println();
		for(ListNode node = head;node != null;node = node.next){
			System.out.print(node.val+"\t");
		}
	}
	public static List<Integer> ListNodeToArray(ListNode head){
		List<Integer> l = new ArrayList<Integer>();
		for(ListNode node = head;node != null;node = node.next){
			l.add(node.val);
		}
		return l;
	}
}