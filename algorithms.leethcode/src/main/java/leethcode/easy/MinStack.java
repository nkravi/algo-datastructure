package leethcode.easy;
import java.util.Stack;

public class MinStack {
	private Stack<Node> stack;
	class Node{
		private int val;
		private int min;
		Node(int val,int min){
			this.min = min;
			this.val = val;
		}
	}
	
	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int x) {
		stack.push(new Node(x, Math.min(x, getMin())));
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().val;
	}

	public int getMin() {
		if(stack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return stack.peek().min;
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinStack obj = new MinStack();
		
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
	}

}
