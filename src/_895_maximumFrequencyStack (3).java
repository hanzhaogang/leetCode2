package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Implement FreqStack, 
 * a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

    push(int x), which pushes an integer x onto the stack.
    
    pop(), which removes and returns the most frequent element in the stack.
    
        If there is a tie for most frequent element, 
        the element closest to the top of the stack is removed and returned.

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, 
the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].

Note:

    Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
    It is guaranteed that FreqStack.pop() won’t be called if the stack has zero elements.
    The total number of FreqStack.push calls will not exceed 10000 in a single test case.
    The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
    The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.

 */
public class _895_maximumFrequencyStack {
	public static void main(String[] args) {
		_895_maximumFrequencyStack s=new _895_maximumFrequencyStack();
		s.push(5);
		s.push(7);
		s.push(5);
		s.push(7);
		s.push(4);
		s.push(5);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
	}
	PriorityQueue<Pair895> pq;
	Map<Integer,Integer> val2fre;
	int stamp;
	
	public _895_maximumFrequencyStack() {
		pq=new PriorityQueue<Pair895>((p1,p2)-> {
			if(p1.fre!=p2.fre)
				return p2.fre-p1.fre;
			else
				return p2.stamp-p1.stamp;
		});
		val2fre=new HashMap<Integer,Integer>();
	}
	
	public void push(int val) {
		int newFre=val2fre.getOrDefault(val, 0)+1;
		val2fre.put(val, newFre);
		pq.offer(new Pair895(val,newFre,stamp++));
	}
	
	public int pop() {
		Pair895 p=pq.poll();
		if(val2fre.get(p.val)<=1)
			val2fre.remove(p.val);
		else
			val2fre.put(p.val, p.fre-1);
		return p.val;
	}
}

class Pair895{
	int val;
	int fre;
	int stamp;
	
	public Pair895(int val,int fre,int stamp) {
		this.val=val;
		this.fre=fre;
		this.stamp=stamp;
	}
}