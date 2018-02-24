package leethcode.medium;

import leethcode.datastructure.TreeNode;
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
 
	private void levelOrder(TreeNode node,int level,List<List<Integer>> res){
		if(node == null){
			return;
		}
		
		if(res.size()-1 < level){
			res.add( new ArrayList<Integer>());
		}
		List<Integer> tmp = res.get(level);
		tmp.add(node.val);
		res.set(level,tmp);
		
		levelOrder(node.left,level+1,res);
		levelOrder(node.right,level+1,res);
	}
	
	
	public List<Integer> reverse(List<Integer> lst){
		List<Integer> reverseList = new ArrayList<>();
		for(int i= lst.size()-1;i >=0 ;i--){
			reverseList.add(lst.get(i));
		}
		return reverseList;
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelOrder(root,0,res);
		List<List<Integer>> revres = new ArrayList<>();
		boolean reverse = false;
		for(List<Integer> r: res){
			if(reverse){
				revres.add(reverse(r));
				reverse = false;
			}else{
				revres.add(r);
				reverse = true;
			}
		}
        return revres;
    }
	public static void main(String[] args) {
		Integer[] parent = {3,9,20,5,11,15,7};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		List<List<Integer>> res = (new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
		
		for(List<Integer> r:res){
			System.out.println();
			for(Integer i: r){
				System.out.print(i+"\t");
			}
		}

	}

}
