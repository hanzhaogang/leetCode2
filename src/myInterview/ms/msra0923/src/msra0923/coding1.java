package msra0923;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * valid bracket expression: string contains only (, ), [, ] characters
 * 
1. Empty sequence

2. S is valid => (S), [S] is valid

3. A, B are valid => AB is valid

example
[]
()
[]()
[()]


[上午11:45] Yue Fei (MSRA) (来宾)
    
[ => []
​[上午11:45] Yue Fei (MSRA) (来宾)
    
(=>()
​[上午11:45] Yue Fei (MSRA) (来宾)
    
[(] => [()]

()()()[ -> 
()()()[]

[(])) ->(([()]))




[]([] ->[ shrortest("") ]


]([ =>  [    ( ]   => []()[] 


[[]()[]] 



[](()))  0,s.length()  0,0, ... i,i



   [   ]   (   (  )   )   ) 

[  2   2   4   ?              ?
]     2    4   
(          2   4
(             2   2
)                 2
)
)


 */
public class coding1 {
	
	
	public String shortestValid(String s) {
		int len=s.length();//4,5
		if(isValid(s)) {
			return s;
		}else {
			if(s.length()==0)
				return "";
			if(len==1) {
				return s.charAt(0)"()" "[];"
			}
			
			if(isMatch(s.charAt(0),s.charAt(s.length()-1))){
				return s.charAt(0)+shortestValid(s.substring(1,s.length()-1))+s.charAt(s.length()-1);
			}else {
				return shortestValid(s.substring(0,len/2))+shortestValid(s.substring(len/2,len));
			}
		}
	}
	
	
	
	
	
	
	public boolean isValid(String s) {// [; []; [(; [][; [((])]]
		if(s==null)
			return true;
		
		if(s.length()==0)
			return true;
		
		Deque<Character> stack=new ArrayDeque<>();
		//Stack<>
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			
			if(c=='['||c=='(') {
				stack.push(c);
			}else if(!stack.isEmpty()&&isMatch(stack.peek(),c)) {
				stack.pop();
			}else {
				return false;
			}
		}
		
		return stack.isEmpty();//stack =[
	}
	
	private boolean isMatch(char c1,char c2) {
		if(c1=='['&&c2==']' || c1=='('&&c2==')') {
			return true;
		}else {
			return false;
		}
	}
}





/*
单调栈问题
 * [3, 2, 2, 13, 24, 12, 18, 20]
[1, 0, 0, 2, 1, 0, 0, 0]*/



	public int[] nearestSmallerEle(int[] nums) {
		if(nums==null||nums.length==0) {
			return nums;
		}
		
		
		int[] res=new int[nums.length];
		// null,
		//[]
		//[1]
		//[1,1]
		//[3,2,2,3]
		//[1,2,3,4,5]
		//[5,4,3,2,1]
		//[-5,0,5]
		//[0,0,0,0]
		//[1234444444444444444,]
		//[0.123,0.4444,9999999999999999.1]
		//
		//[3, 2, 5, 13, 24, 12, 18, 20]
		//
		Deque<Integer> stack=new ArrayDeque<>();
		for(int index=0;index<nums.length;index++) {
			int num=nums[index];
			
			if(stack.isEmpty()|| nums[stack.peek()]<=num) {
				stack.push(index);//1,2,3,4
			}else {//
				while(!stack.isEmpty()&&num<nums[stack.peek()]) {
					int popedIndex=stack.pop();
					res[popedIndex]=index-popedIndex;//res[1,0,2,1,
				}
				
				stack.push(index);//1,5,6,7
			}
			
		}
		
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	Pros: Good communication skills.

Cons: Limited design & engineering skills. Limited coding skills.

Zhaogang is a very outgoing and friendly person. He can introduce his work in a clear and understandable way. 
He has been working on a web service deployment for a while. 
But when I drill into details, 
he does not explain it logically and there are some design questions remain unanswered, like performance enhancement, traffic load handling, etc. 
For coding part, we discuss a problem about string formatting, which prints a string on a 80-character-width screen without breaking a words into two lines. 
He does not know how to solve it and only writes segments of codes. 
When I give him more hints, he tries to implement it, but there are still many errors and we do not finish this problem in the interview 
(around 35 minites for coding). Overall, I think the candidate may not reach the bar in my personal opinion.
	 *  行宽 80 字符
	 * 
	 * 单词不跨行。
	 * 
	 * ， 。 其他所有标点-》空格
	 * 
	 *多个空格-》1个。
	 * 
	 * 流。 
	 */
	
	public void print(String s) {
		
		StringBuilder line=new StringBuilder();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			
			char curC=s.charAt(i);
			if(curC.isWord()) {
				
				
			}else if(curC.isPank()){
				
				String preWord=sb.toString();//apple,peak
				
				
				if(line.length()+preWord.length()<80) {
					line.append(preWord);
				}else {
					System.out.println(line);
					line.delete(0, line.length());
					line.append(preWord);
					line.append(curC);
				}
				
				if(line.length()+1<80) {
					line.append(curC);
				}else {
					System.out.println(line);
					line.delete(0, line.length());
					line.append(preWord);
					line.append(curC);
				}
				
			}
			
			
//			if(curC!=','&&curC!='.') {
//				sb.append(" ");
//			}
			
			
			if()
		}
			System.out.println(sb.toString());
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
