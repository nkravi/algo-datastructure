package leethcode.medium;

import java.util.Stack;

/*
 * 
 * s1 = push in stack 1 unless hit space
 * s2 = if space pop from 
 * 
 */

public class ReverseWordsinaString {
	
	public String reverseWords(String s) {
		String res = "";
		if(s == null || s.trim().length() == 0) return res;
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();

		for(char c: s.trim().toCharArray()){
			if(c == ' '){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
				s2.push(c);
			}else{
				s1.push(c);
			}
		}
		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		
		while(!s2.isEmpty()){
			res += s2.pop();
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		System.out.println(new ReverseWordsinaString().reverseWords(s));

	}

}
