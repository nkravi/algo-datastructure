package leethcode.medium;
import leethcode.datastructure.ListNode;

public class AddTwoNumbersII {

	public int addTwoNumbers(ListNode l1, ListNode l2,ListNode res){
		if(l1.next == null && l2.next == null){
			return 0;
		}else{
			if(l1.next != null) l1 = l1.next;
			if(l2.next != null) l2 = l2.next;
			int carry = addTwoNumbers(l1, l2,res);
			System.out.println(l1.val+" "+l2.val);
			int sum = l1.val + l2.val + carry;
			int newCarry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			newNode.next = res.next;
			res.next = newNode;
			return newCarry;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode  dummyHead = new ListNode(11);
		ListNode l1Dummy =new ListNode(1);
		ListNode l2Dummy =new ListNode(1);
		l1Dummy.next = l1; l2Dummy.next = l2;
		int carry = addTwoNumbers(l1Dummy,l2Dummy,dummyHead);
		if(carry != 0){
			dummyHead.val = carry;
		}else{
			dummyHead = dummyHead.next;
		}
		return dummyHead;
	        
	}
	public static void main(String[] args) {
		int[] val1 = {7,2,4,3};
		int[] val2 = {5,6,7,9};
		ListNode l1 = ListNode.arrayToListNode(val1);
		ListNode l2 = ListNode.arrayToListNode(val2);
		ListNode res = new AddTwoNumbersII().addTwoNumbers(l1, l2);
		ListNode.printNodes(res);
	}

}
