package leethcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	private boolean isValidParanthesis(String paranthesis){
		Stack<Character> stack = new Stack<>();
		char[] str = paranthesis.toCharArray();
		for(char c: str){
			if(c == '('){
				stack.push(c);
			}else{
				if(!stack.isEmpty()){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	
	
	private boolean isDone(String paranthesis, List<String> res, int n){
		if(paranthesis.length() == 2*n ){
			if(isValidParanthesis(paranthesis)){
				res.add(paranthesis);
			}
			return true;
		}else{
			return false;
		}
	}
	
	private List<String> constructCandidates(String paranthesis){
		List<String> candidates = new ArrayList<>();
		candidates.add("("+paranthesis+")");
		candidates.add("("+paranthesis+"(");
		candidates.add(")"+paranthesis+")");
		candidates.add(")"+paranthesis+"(");
		return candidates;
	}
	
	private void backTrack(String paranthesis, List<String> res, int n){
		
		if(isDone(paranthesis,res,n)){
			return;
		}else{
			List<String> candidates = constructCandidates(paranthesis);
			for(String candidate: candidates){
				backTrack(candidate,res,n);
			}	
		}
	}
	
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backTrack("",res,n);
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(new GenerateParentheses().isValidParanthesis("((()()"));
		
		List<String> res = new GenerateParentheses().generateParenthesis(1);
		
		for(String r: res){
			System.out.println(r);
		}

	}

}
