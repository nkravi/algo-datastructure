package leethcode.easy;

import leethcode.datastructure.ListNode;

public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		
		int aCntr = 0;
		int bCntr = 0;
		
		ListNode aTail = null;
		ListNode bTail = null;
		
		for(ListNode node = headA; node != null; node = node.next){
			aTail = node;
			aCntr++;
		}
		for(ListNode node = headB; node != null; node = node.next){
			bTail = node;
			bCntr++;
		}
        if(aTail != bTail){
        	return null;
        }
		
        if(aCntr > bCntr){
        	for(int i=0 ;i< (aCntr-bCntr);i++ ){
        		headA = headA.next;
        	}
        }else{
        	for(int i=0 ;i< (bCntr-aCntr);i++ ){
        		headB = headB.next;
        	}
        }
        
        ListNode intersection = null;
        for(ListNode node1=headA,node2 = headB;node1!=null && node2!= null;node1 = node1.next,node2= node2.next){
        	if(node1 == node2){
        		intersection = node1;
        		break;
        	}
        	
        }
		return intersection;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {2,4,6,8,10,12};
		int[] vals1 = {1,3,5,7};
		
		ListNode headA = ListNode.arrayToListNode(vals);
		ListNode headB = ListNode.arrayToListNode(vals1);
		int count = 2;
		int i =0;
		for(ListNode node1=headA,node2 = headB;node1!=null && node2!= null;node1 = node1.next,node2= node2.next){
        	if(i==count){
        		node2.next = node1.next.next;
        		break;
        	}
        	i++;
        }
		
		ListNode inters = new IntersectionofTwoLinkedLists().getIntersectionNode(headA, headB);
		ListNode.printNodes(headA);
		ListNode.printNodes(headB);
		System.out.println();
		if(inters !=null){
			System.out.println(inters.val);
		}else{
			System.out.println("Null");
		}
		
	}

}
