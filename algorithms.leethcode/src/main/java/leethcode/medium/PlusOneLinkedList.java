package leethcode.medium;
import leethcode.datastructure.ListNode;

public class PlusOneLinkedList {
	
	private int add(ListNode node){
		if(node.next == null){
			int sum = node.val + 1;
			node.val = (sum == 10) ? 0 : sum;
			return (sum==10) ? 1 : 0;
		}else{
			int reminder = add(node.next);
			int sum = node.val + reminder;
			node.val = (sum == 10) ? 0 : sum;
			return (sum==10) ? 1 : 0;
		}
	}
	
	public ListNode plusOne(ListNode head) {
		int carry = add(head);
		if(carry == 1){
			ListNode newNode = new ListNode(1);
			newNode.next = head;
			head = newNode;
		}
		return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {9,9,9};
		ListNode head = ListNode.arrayToListNode(vals);
		ListNode newHead = (new PlusOneLinkedList()).plusOne(head);
		ListNode.printNodes(newHead);

	}

}
