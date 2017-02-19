package leethcode.medium;

import java.util.Stack;

public class DecodeString {

	private String getString(Stack<String> stack){
		String acc = "";
		while(!stack.peek().equals("[")){
			acc = stack.pop() + acc;
		}
		stack.pop();
		return acc;
	}
	
	private boolean isInt(String s){
		char c = s.charAt(0);
		return c >= '0' && c <= '9';
	}
	private Integer getInteger(Stack<String> stack){
		String acc = "";
		while(!stack.isEmpty() && isInt(stack.peek())){
			acc = stack.pop() + acc;
		}
		return Integer.parseInt(acc);
	}
	
	private String process(Stack<String> stack){
		String str = getString(stack);
		Integer n = getInteger(stack);
		String acc = "";
		for(int i=0; i< n; i++) acc += str;
		return acc;
	}
	
	private String getResult(Stack<String> stack){
		String acc = "";
		while(!stack.isEmpty()){
			acc = stack.pop() + acc;
		}
		
		return acc;
	}
	
	public String decodeString(String s){
		Stack<String> stack = new Stack<String>();
		char[] sArray = s.toCharArray();
		
		for(char c: sArray){
			if(c != ']'){
				stack.push(c+"");
			}else{
				stack.push(process(stack));
			}
			
		}
		return getResult(stack);
	}
	
	
	
	
	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		String out = new DecodeString().decodeString(s);
		
		System.out.println(out.equals("abcabccdcdcdef"));
	}
	
	
     
	
}
