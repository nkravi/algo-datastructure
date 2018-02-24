package leethcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leethcode.datastructure.TreeLinkNode;

class Node{
	TreeLinkNode node;
	Integer level;
	Node(TreeLinkNode node,Integer level){
		this.level = level;
		this.node = node;
	}
}

public class PopulatingNextRightPointersinEachNode {

	public void connect(TreeLinkNode root) {
        
		if(root == null) return;
		
		Queue<Node> q = new LinkedList<Node>();
		//insert root
		q.add(new Node(root,0));
		
		while(!q.isEmpty()){
			Node n = q.remove();
			if(n == null || n.node == null) continue;
			Node next = q.peek();
			if(next != null && next.level == n.level){
				n.node.next = next.node;
			}
			q.add(new Node(n.node.left,n.level+1));
			q.add(new Node(n.node.right,n.level+1));
		}	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersinEachNode pnr = new PopulatingNextRightPointersinEachNode();
		Integer[] parent = {1,2,3,4,5,6,7};
		TreeLinkNode root = TreeLinkNode.createTree(parent);
		pnr.connect(root);
		//System.out.println(root.left.next.val);
		TreeLinkNode.print(root);
	}

}
