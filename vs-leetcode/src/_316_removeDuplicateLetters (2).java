package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appears once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"; bcab abacb acabb
Output: "abc"

Example 2:

Input: "cbacdcbc"
Output: "acdb"

 */
public class _316_removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
    	if(s==null)
    		return null;
    	
    	int[] leftCounts=new int[26];
    	for(char c:s.toCharArray()) {
    		leftCounts[c-'a']++;
    	}
    	Deque<Character> stack=new ArrayDeque<>();
    	Set<Character> charInStack=new HashSet<>();
    	for(char c:s.toCharArray()) {
    		if(stack.isEmpty()) {
    			stack.push(c);
    			charInStack.add(c);
    			leftCounts[c-'a']--;
    		}else {
    			if(charInStack.contains(c)) {
    				leftCounts[c-'a']--;
    				continue;
    			}
    			while(!stack.isEmpty()&&c<=stack.peek()&&0<leftCounts[stack.peek()-'a']) {
    				charInStack.remove(stack.peek());
    				stack.pop();
    			}
    			stack.push(c);
    			charInStack.add(c);
    			leftCounts[c-'a']--;
    		}
    	}
    	
    	StringBuilder sb=new StringBuilder();
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	return sb.reverse().toString();
    }
}
