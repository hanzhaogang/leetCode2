package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Design a stack which supports the following operations.

Implement the CustomStack class:

    CustomStack(int maxSize) Initializes the object with maxSize 
    which is the maximum number of elements in the stack 
    or do nothing if the stack reached the maxSize.
    
    void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
    int pop() Pops and returns the top of stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val. 
    If there are less than k elements in the stack, just increment all the elements in the stack.

 

Example 1:

Input
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
Output
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
Explanation
CustomStack customStack = new CustomStack(3); // Stack is Empty []
customStack.push(1);                          // stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.push(3);                          // stack becomes [1, 2, 3]
customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
customStack.increment(5, 100);                // stack becomes [101, 102, 103]
customStack.increment(2, 100);                // stack becomes [201, 202, 103]
customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
customStack.pop();                            // return -1 --> Stack is empty return -1.

 

Constraints:

    1 <= maxSize <= 1000
    1 <= x <= 1000
    1 <= k <= 1000
    0 <= val <= 100
    At most 1000 calls will be made to each method of increment, push and pop each separately.
    
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]


 */
public class _1381_DesignAStackWithIncrementOperation {
	public static void main(String[] args) {
//		CustomStack_2 s=new CustomStack_2(3);
//		s.push(1);
//		s.push(2);
//		System.out.println(s.pop());
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		s.increment(5, 100);
//		s.increment(2, 100);
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
		
//["CustomStack","pop","increment","push","increment","increment","increment","pop","increment"]
//[[30],[],[3,40],[30],[4,63],[2,79],[5,57],[],[5,32]]
		CustomStack_2 s=new CustomStack_2(30);
		s.pop();
		s.increment(3, 40);
		s.push(30);
		s.increment(4, 63);
		s.increment(2, 79);
		s.increment(5, 57);
		System.out.println(s.pop());
		s.increment(5,32);
		
	}
}

class CustomStack{
	int maxSize;
	Deque<Integer> stack;
	
	public CustomStack(int maxSize) {
    	this.maxSize=maxSize;
    	stack=new ArrayDeque<>();
    }
    
    public void push(int x) {
    	if(stack.size()<maxSize) {
    		stack.push(x);
    	}
    }
    
    public int pop() {
    	if(stack.isEmpty()) {
    		return -1;
    	}
    	return stack.pop();
    }
    
    public void increment(int k, int val) {
    	List<Integer> list=new ArrayList<>();
    	while(!stack.isEmpty()) {
    		list.add(0,stack.pop());
    	}
    	for(int i=0;i<Math.min(list.size(),k);i++) {
    		list.set(i, list.get(i)+val);
    	}
    	for(Integer i:list) {
    		stack.push(i);
    	}
    }
}

class CustomStack_2{
	int[] array;
	int topPointer;
	Map<Integer,Integer> k2increVal;
	
	public CustomStack_2(int maxSize) {
    	array=new int[maxSize];
    	topPointer=-1;
    	k2increVal=new HashMap<Integer,Integer>();
    }
    
    public void push(int x) {
    	if(topPointer<array.length-1) {
    		array[++topPointer]=x;
    	}
    }
    
    public int pop() {
    	if(topPointer==-1) {
    		return -1;
    	}
    	
    	int increament=k2increVal.getOrDefault(topPointer+1, 0);
    	if(k2increVal.containsKey(topPointer+1)){
    		int val=k2increVal.remove(topPointer+1);
    		k2increVal.put(topPointer,
    				k2increVal.getOrDefault(topPointer,0)+val);
    	}
    	return increament+array[topPointer--];
    }
    
    public void increment(int k, int val) {
    	if(topPointer+1<k) {
    		k=topPointer+1;
    	}
    	if(k2increVal.containsKey(k)) {
    		k2increVal.put(k,k2increVal.get(k)+val);
    	}else {
    		k2increVal.put(k, val);
    	}
    }
}