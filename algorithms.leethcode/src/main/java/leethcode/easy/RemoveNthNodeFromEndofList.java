package leethcode.easy;

import leethcode.datastructure.ListNode;


/*
 * L = 1->2->3->4
 * n = 2
 * L`= 1->2->4
 * 
 * ptr1 and ptr 2 with distance n
 * when prt2 hits end of list then remove element at ptr1
 */

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		int i = 0;
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		//move pointer 2 distance n away
		while(i < n ){
			ptr2 = ptr2.next;
			i++;
		}
		
		//remove head
		if(ptr2 == null){
			head = head.next;
			return head;
		}
		
		//move both pointer until ptr2 hits end of the list
		for(;ptr2.next !=null;ptr1 = ptr1.next,ptr2 =ptr2.next){
			
		}
		//now ptr1 points to node next to be removed
		
		ListNode tmp = ptr1.next;
		ptr1.next = ptr1.next.next;
		tmp.next = null;
		
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1};
		int n =1;
		ListNode head = ListNode.arrayToListNode(vals);
		ListNode newHead = new RemoveNthNodeFromEndofList().removeNthFromEnd(head, n);
		ListNode.printNodes(newHead);
	}

}
