package leethcode.easy;

import leethcode.datastructure.ListNode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
		ListNode dummy = head;
        
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        
        while(ptr1 != null && ptr2 != null){
        	if(ptr1.val < ptr2.val){
        		dummy.next = new ListNode(ptr1.val);
        		ptr1 = ptr1.next;
        	}else{
        		dummy.next = new ListNode(ptr2.val);
        		ptr2 = ptr2.next;
        	}
        	dummy = dummy.next;
        }
        
        while(ptr1 != null){
        	dummy.next = new ListNode(ptr1.val);
        	ptr1 = ptr1.next;
        	dummy = dummy.next;
        }
        
        while(ptr2 != null){
        	dummy.next = new ListNode(ptr2.val);
        	ptr2 = ptr2.next;
        	dummy = dummy.next;
        }
        
        return head.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {};
		int[] nums2 = {};
		
		ListNode l1 = ListNode.arrayToListNode(nums1);
		ListNode l2 = ListNode.arrayToListNode(nums2);
		
		ListNode res = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
		
		ListNode.printNodes(res);
	}

}
