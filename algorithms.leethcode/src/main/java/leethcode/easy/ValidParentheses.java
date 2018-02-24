package leethcode.easy;

import java.util.Stack;

public class ValidParentheses {

	private boolean isMatch(char open, char close){
		if(open == '(' && close == ')')
			return true;
		if(open == '{' && close == '}')
			return true;
		if(open == '[' && close == ']')
			return true;
		return false;
		
	}
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] input = s.toCharArray();
		for(char c:input){
			if(c=='(' || c=='{' || c=='[')
				stack.push(c);
			if(c==')' || c=='}' || c== ']'){
				if(stack.size() == 0 || !isMatch(stack.pop(),c) ){ 
					return false;
				}
			}
		}
		return (stack.size()==0) ? true:false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("[]"));
		System.out.println(vp.isValid("[[]"));
		System.out.println(vp.isValid("[]]"));

	}

}
