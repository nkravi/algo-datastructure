package leethcode.easy;

import java.util.Stack;

class MyQueue {
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public MyQueue(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
        while(!stack2.isEmpty()){
        	stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
        stack2.pop(); 
    }

    // Get the front element.
    public int peek() {
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class ImplementQueueusingStacks {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		System.out.println(q.empty());
		q.pop();
		System.out.println(q.empty());

	}

}
