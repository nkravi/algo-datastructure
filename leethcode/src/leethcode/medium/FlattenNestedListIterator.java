package leethcode.medium;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class FlattenNestedListIterator implements Iterator<Integer>{
		private List<NestedInteger> nestedList;
		private Stack<NestedInteger> stack;
		private int currIndex;
		
	    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
	        this.nestedList = nestedList;
	        this.stack = new Stack<>();
	        currIndex = 0;
	    }

	    private void expandStackTop() {
	    	if(stack.size() == 0) {
	    		return;
	    	}
	    	if(stack.peek().isInteger()) {
	    		return;
	    	}else {
	    		List<NestedInteger> tmp = stack.pop().getList();
	    		for(int i=tmp.size()-1;i>=0;i--) {
	    			stack.push(tmp.get(i));
	    		}
	    		expandStackTop();
	    	}
	    }
	    
	    @Override
	    public Integer next() {
	    	if(this.hasNext()) {
	    		if(stack.isEmpty()) {
	    			stack.push(nestedList.get(currIndex++));
	    		}
	    		expandStackTop();
	    		if(stack.size() != 0) {
	    			return stack.pop().getInteger();
	    		}
	    	}
	        return null;
	    }

	    @Override
	    public boolean hasNext() {
	        return !(stack.isEmpty() && currIndex == nestedList.size()) ;
	    }
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
