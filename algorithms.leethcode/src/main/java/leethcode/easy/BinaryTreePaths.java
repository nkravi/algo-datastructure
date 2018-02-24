package leethcode.easy;

import java.util.ArrayList;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class BinaryTreePaths {

	private void DFS(TreeNode node,String str,List<String> l){
		if(node == null){
			return;
		}
		str = str+node.val+"->";
		if(node.left == null && node.right == null){
			str = str.trim();
			str = str.substring(0,str.length()-2);
			l.add(str);
			str = "";
		}
		DFS(node.left,str,l);
		DFS(node.right,str,l);
	}
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> l = new ArrayList<String>();
		DFS(root,"",l);
		return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,3,4,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		List<String> l = (new BinaryTreePaths().binaryTreePaths(root));
		for(String s:l){
			System.out.println(s);
		}
	}

}
