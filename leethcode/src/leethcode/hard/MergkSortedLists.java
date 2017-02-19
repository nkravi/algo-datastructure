package leethcode.hard;

import leethcode.datastructure.ListNode;

public class MergkSortedLists {

	
	private void merge(ListNode l1,ListNode l2,ListNode res){
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				res.next = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				res.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			res = res.next;
		}
		ListNode rem = (l1==null)? l2: l1;
		while(rem != null){
			res.next = new ListNode(rem.val);
			rem = rem.next;
			res = res.next;
		}
	}
	
	private void copy(ListNode[] lists,ListNode res,int start,int end){
		for(int i=start;i<=end;i++){
			ListNode l = lists[i];
			while(l != null){
				res.next = new ListNode(l.val);
				l = l.next;
				res = res.next;
			}
		}
	}
	
	private void merge(ListNode[] lists,ListNode res,int start,int end){
		//System.out.println(start+" "+end);
		ListNode head = res;
		int l1Start = start;
		int l1End = start + (end-start)/2;
		int l2Start = l1End +1;
		int l2End = end;
		
		while(l1Start<= l1End && l2Start <= l2End){
			ListNode l1 = lists[l1Start];
			ListNode l2 = lists[l2Start];
			merge(l1,l2,res);
			l1Start++;
			l2Start++;
		}
		//copy remaining
		copy(lists,res,l1Start,l1End);
		copy(lists,res,l2Start,l2End);
		res = head;
		ListNode.printNodes(res);
	}
	
	private void mergeKLists(ListNode[] lists ,ListNode res,int start,int end){
		
		if(start>= end){
			return;
		}
		int middle = (end+start)/2;
		mergeKLists(lists,res,start,middle);
		mergeKLists(lists,res,middle+1,end);
		merge(lists,res,start,end);
	}
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode(1);
		ListNode ptr = res;
		mergeKLists(lists,ptr,0,lists.length-1);
		return res.next;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergkSortedLists mg = new MergkSortedLists();
		ListNode node1 = ListNode.arrayToListNode(new int[]{1,3,5});
		ListNode node2 = ListNode.arrayToListNode(new int[]{2,4,7});
		ListNode node3 = ListNode.arrayToListNode(new int[]{6,9,12});
		ListNode res = mg.mergeKLists(new ListNode[]{node1,node2,node3});
		ListNode.printNodes(res);

	}

}
