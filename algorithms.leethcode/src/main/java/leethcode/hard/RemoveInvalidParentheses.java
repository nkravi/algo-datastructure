package leethcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	
	
	private boolean isValid(String str){
		char[] arr = str.toCharArray();
		int i=0;
		for(char c: arr){
			if(c=='(') i++;
			if(c==')') i--;
			if(i<0) return false;
		}
		return (i==0)? true:false;
	}
	
	
	private List<String> generateChildren(String parent){
		List<String> childrens = new ArrayList<String>();
		for(int i=0;i<parent.length();i++){
			if (parent.charAt(i) != '(' && parent.charAt(i) != ')') continue;
			String s = parent.substring(0, i) + parent.substring(i+1,parent.length());
			childrens.add(s);
		}
		return childrens;		
	}
	private List<String> BFS(String str){
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		List<String> res = new ArrayList<String>();
		int max = -1;
		queue.add(str);
		
		
		while(!queue.isEmpty()){
			String curr = queue.remove();
			if(visited.contains(curr)) continue;
			visited.add(curr);
			if(curr.length() < max){
				continue;
			}
			if(isValid(curr)){
				res.add(curr);
				max = curr.length();
			}
			for(String child:this.generateChildren(curr)){
				if(visited.contains(child)) continue;
				queue.add(child);
			}
		}
		return res;
	}
	public List<String> removeInvalidParentheses(String s) {
		return BFS(s);
    }
	
	
	
	
	
	
	
	
	/*
	private String remove(char[] str, int pos){
		String res = "";
		for(int i=0;i<str.length;i++){
			if(i== pos && (str[i]=='('||str[i]==')')){
				continue;
			}
			res += str[i];
		}
		return res;
	}
	
	private void generate(char[] str,String s,int pos,Set<String> res,int[] maxLen){
		System.out.println(s+" "+pos);
		if(isValid(s)){
			res.add(s);
			maxLen[0] = (s.length() > maxLen[0]) ? s.length() : maxLen[0]; 
		}
		if(pos >= str.length || s.length() < maxLen[0]){
			return;
		}
		generate(str,s,pos+1,res,maxLen);
		generate(str,remove(str,pos),pos+1,res,maxLen);
	}
	
	*/
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoveInvalidParentheses rmf = new RemoveInvalidParentheses();
		List<String> childrens = rmf.removeInvalidParentheses("()(((((((()");
		for(String child: childrens){
			System.out.println(child);
		}
		

	}

}
