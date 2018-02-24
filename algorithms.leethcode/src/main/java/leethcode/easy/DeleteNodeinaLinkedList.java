package leethcode.easy;

import leethcode.datastructure.ListNode;

public class DeleteNodeinaLinkedList {

	public void deleteNode(ListNode node) {
		if(node == null || node.next == null){
			return;
		}else{
			node.val = node.next.val;
			ListNode temp = node.next.next;
			node.next.next = null;
			node.next = temp;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1,2,3};
		ListNode head = ListNode.arrayToListNode(vals);
		ListNode delNode = head;
		System.out.println(delNode.val);
		ListNode.printNodes(head);
		//System.out.println(head.next.next.val);
		new DeleteNodeinaLinkedList().deleteNode(delNode);
		ListNode.printNodes(head);
		

	}

}
