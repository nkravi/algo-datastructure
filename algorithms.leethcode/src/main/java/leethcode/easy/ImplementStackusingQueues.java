package leethcode.easy;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> Q;
    private Queue<Integer> tmpQ;
	
	MyStack(){
		Q = new LinkedList<>();
		tmpQ = new LinkedList<>();
	}
	// Push element x onto stack.
    public void push(int x) {
        while(!Q.isEmpty()){
        	tmpQ.add(Q.remove());
        }
        Q.add(x);
        while(!tmpQ.isEmpty()){
        	Q.add(tmpQ.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Q.remove();
    }

    // Get the top element.
    public int top() {
    	return Q.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return Q.isEmpty();
        
    }
}

public class ImplementStackusingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
	}

}
