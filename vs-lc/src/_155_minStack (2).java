package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _155_minStack {
/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
	/** initialize your data structure here. */
	Deque<int[]> s;
    public _155_minStack() {
        s=new LinkedList<>();
    }
    
    public void push(int x) {
    	if(s.isEmpty()) {
    		s.push(new int[] {x,x});
    	}else{
            int[] topEle=s.peek();
            s.push(new int[] {x,(x<=topEle[1])?x:topEle[1]});
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
    }
}
