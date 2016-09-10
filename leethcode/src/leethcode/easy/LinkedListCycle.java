package leethcode.easy;

import java.util.HashSet;
import java.util.Set;

import leethcode.datastructure.ListNode;

public class LinkedListCycle {
	
	
	 public boolean hasCycle(ListNode head) {
		 
		 if(head == null)
			 return false;
		 
		 Set<ListNode> set = new HashSet<ListNode>(); 
		 for(ListNode ptr = head; ptr != null; ptr = ptr.next){
			 
			 if(set.contains(ptr)){
				 return true;
			 }else{
				 set.add(ptr);
			 }
				
			
		 }
		 
		 
		 
		 return false;
	 }
	 
	 private static ListNode lstFromArray(int[] a, boolean isCycle){
		 ListNode ptr = new ListNode(a[0]);
		 ListNode head = ptr;
		 for(int i=1;i<a.length;i++){
			 ptr.next = new ListNode(a[i]);
			 ptr = ptr.next;
		 }
		 
		 if(isCycle)
			 ptr.next = head;
		 
		 return head;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycle lc = new LinkedListCycle();
		
		int [] nums = {1,2,3,4,5};
		
		ListNode head = lstFromArray(nums,false);
		System.out.println(lc.hasCycle(head));

	}

}
