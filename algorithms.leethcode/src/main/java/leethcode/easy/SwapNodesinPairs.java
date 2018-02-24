package leethcode.easy;

import java.util.List;

import leethcode.datastructure.ListNode;

public class SwapNodesinPairs {

	private ListNode swap(ListNode ptr){
		if(ptr == null || ptr.next == null)
			return ptr;
		ListNode tmp = ptr.next;
		ptr.next = ptr.next.next;
		tmp.next = ptr;
		ptr = tmp;
		return ptr;
	}
	
	public ListNode swapPairs(ListNode head) {
		if(head == null) return null;
		ListNode node = null;
		node = swap(head);
		ListNode tmp = node;
		while(node.next != null && node.next.next != null){
			node.next.next = swap(node.next.next);
			node = node.next.next;
		}
		return tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1,2,3,4,5,6};
		ListNode head = ListNode.arrayToListNode(vals);
		SwapNodesinPairs snp = new SwapNodesinPairs();
		ListNode res = snp.swapPairs(head);
		List<Integer> L = ListNode.ListNodeToArray(res);
		for(int i: L){
			System.out.println(i);
		}
		
	}

}
