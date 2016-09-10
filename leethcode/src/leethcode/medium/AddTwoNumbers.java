package leethcode.medium;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int sum = 0;
		int res = 0;
		ListNode cl1 = l1;
		ListNode cl2 = l2;
		ListNode lres = new ListNode(0);
		ListNode resHead = lres;
		int tmp1,tmp2 =0;
		
		while( cl1 != null || cl2 != null ){
			tmp1 = (cl1 != null) ? cl1.val : 0;
			tmp2 = (cl2 != null) ? cl2.val : 0;
			
			sum = tmp1+tmp2+carry;
			carry = sum/10;
			res = sum%10;
			
			lres.next = new ListNode(res);
			if(cl1 != null)
				cl1 = cl1.next;
			if(cl2 != null)
				cl2 = cl2.next;
			lres = lres.next;
			
		}
		
		if(carry != 0)
			lres.next = new ListNode(carry);
		
		resHead = resHead.next;
		
		return resHead;
	}
	
	
	public static ListNode listFromArray(int [] arr){
		ListNode head = new ListNode(arr[0]);
		ListNode ptr = head;
		
		for(int i=1; i< arr.length; i++){
			ptr.next = new ListNode(arr[i]);
			ptr = ptr.next;
		}
		
		
		return head;
	}
	
	
	public static void printNode(ListNode l){
		System.out.println();
		for(ListNode currentNode = l; currentNode != null;currentNode=currentNode.next){
			System.out.print(currentNode.val+" -> ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers ad = new AddTwoNumbers();
		int[] l1a = {5}; 
		int[] l2a = {5};
		ListNode l1 = listFromArray(l1a);
		ListNode l2 = listFromArray(l2a);
		ListNode res = ad.addTwoNumbers(l1, l2);
		printNode(res);
		
	}

}
