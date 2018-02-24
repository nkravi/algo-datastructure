package leethcode.medium;
import leethcode.datastructure.ListNode;

public class OddEvenLinkedList {
	
	
	public ListNode oddEvenList(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		ListNode odd = head;
		ListNode even = head.next;
		
		ListNode oddPtr = odd;
		ListNode evenPtr = even;
		
		
		while(evenPtr != null && evenPtr.next != null){
			oddPtr.next = evenPtr.next;
			oddPtr = oddPtr.next;
			evenPtr.next = oddPtr.next;
			evenPtr = evenPtr.next;
		}
		
		oddPtr.next = even;
		
		return odd;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1,2,3,4,5,6};
		ListNode head = ListNode.arrayToListNode(vals);
		ListNode res = new OddEvenLinkedList().oddEvenList(head);
		ListNode.printNodes(res);
	}

}
