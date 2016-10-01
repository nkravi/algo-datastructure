package leethcode.easy;

import java.util.Stack;

import leethcode.datastructure.ListNode;

public class PalindromeLinkedList {
	
	public boolean isSame(ListNode listOne,ListNode listTwo){
		for(ListNode l1 = listOne,l2= listTwo;l1 != null && l2 != null; l1 = l1.next,l2 = l2.next){
			if(l1.val != l2.val ){
				return false;
			}
		}
		return true;
	}
	
	public ListNode reverseLinkedList(ListNode head){
		Stack<ListNode> stack = new Stack<>();
		for(ListNode node = head; node != null; node = node.next){
			stack.push(node);
		}
		ListNode newHead = new ListNode(stack.pop().val);
		newHead.next = null;
		ListNode ptr = newHead;
		while(!stack.isEmpty()){
			ListNode lnode =  new ListNode(stack.pop().val);
			lnode.next = null;
			ptr.next = lnode;
			ptr = ptr.next;
		}
		return newHead;
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		ListNode tmpHead = head;
		ListNode reversed = reverseLinkedList(tmpHead);
		return isSame(head,reversed);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1,1,2,1};
		ListNode head = ListNode.arrayToListNode(vals);
		System.out.println(new PalindromeLinkedList().isPalindrome(head)); 

	}

}
