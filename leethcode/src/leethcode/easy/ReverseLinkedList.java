package leethcode.easy;

import java.util.Stack;

import leethcode.datastructure.ListNode;



public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		Stack<Integer> st = new Stack<Integer>();
		ListNode dummy = new ListNode(0);
		ListNode resHead = dummy;
		
		for(ListNode ptr=head; ptr != null; ptr=ptr.next){
			st.push(ptr.val);
		}
		
		while(!st.isEmpty()){
			dummy.next = new ListNode(st.pop());
			dummy = dummy.next;
		}
		
		
		return resHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
