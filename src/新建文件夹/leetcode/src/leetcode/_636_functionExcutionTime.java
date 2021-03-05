package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * On a single threaded CPU, we execute some functions.  
 * Each function has a unique id between 0 and N-1.

We store logs in timestamp order 
that describe when a function is entered or exited.

Each log is a string with this format: 
"{function_id}:{"start" | "end"}:{timestamp}".  
For example, 
"0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a given time unit.

Return the exclusive time of each function, sorted by their function id.

 

Example 1:

Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.

 

Note:

    1 <= n <= 100
    Two functions won't start or end at the same time.
    Functions will always log when they exit.

 */
public class _636_functionExcutionTime {
	public static void main(String[] args) {
		_636_functionExcutionTime s=new _636_functionExcutionTime();
		List<String> logs=Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
		int n=2;
		
		/*
		 * 1
["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
		 */
		s.exclusiveTime(n, logs);
	}
    public int[] exclusiveTime(int n, List<String> logs) {
    	Deque<String> stack=new ArrayDeque<>();
    	int[] times=new int[n];
    	
    	for(int i=0;i<logs.size();i++) {
    		String curLog=logs.get(i);
    		String[] curLogItemStrs=curLog.split(":");
    		
    		if(stack.isEmpty()) {
    			stack.push(curLog);
    		}else {
    			String peekedLog=stack.peek();
    			String[] peekedLogItemStrs=peekedLog.split(":");
    			int curTimeStamp=Integer.parseInt(curLog.split(":")[2]);
				String preLog=logs.get(i-1);
				String[] preLogItemStrs=preLog.split(":");
				int preTimeStamp=Integer.parseInt(preLogItemStrs[2]);
				
    			if(peekedLogItemStrs[1].equals("start")&&
    					curLogItemStrs[1].equals("end")) {
    				
    				int endingFunction=Integer.parseInt(curLogItemStrs[0]);
    				times[endingFunction]+=(preLog.equals(peekedLog))?
    						curTimeStamp-preTimeStamp+1:
    							curTimeStamp-preTimeStamp;
    				
    				stack.pop();
    			}else if(peekedLogItemStrs[1].equals("start")&&
    					curLogItemStrs[1].equals("start")) {
    				
    				int execFunction=Integer.parseInt(peekedLogItemStrs[0]);
    				times[execFunction]+=(preLog.equals(peekedLog))?
    						curTimeStamp-preTimeStamp:curTimeStamp-preTimeStamp-1;
    				
    				stack.push(curLog);
    			}
    		}
    	}
    	return times;
    }
}
