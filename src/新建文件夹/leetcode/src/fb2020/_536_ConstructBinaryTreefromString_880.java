package fb2020;
/*
 * You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. 
It contains an integer followed by zero, one or two pairs of parenthesis. 
The integer represents the root's value and 
a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.
Example

Example 1:

Input: "-4(2(3)(1))(6(5))"
Output: {-4,2,6,3,1,5}
Explanation:
The output is look like this:
      -4
     /  \
    2    6
   / \   / 
  3   1 5   

Example 2:

Input: "1(-1)"
Output: {1,-1}
Explanation:
The output is look like this:
     1
    /
  -1

Notice

    There will only be '(', ')', '-' and '0' ~ '9' in the input string.
    An empty tree is represented by "" instead of "()".


 */
public class _536_ConstructBinaryTreefromString_880 {
	public static void main(String[] args) {
		String s="-4(2(3)(1))(6(5)(7))";
		_536_ConstructBinaryTreefromString_880 solution=new _536_ConstructBinaryTreefromString_880();
		System.out.println(solution.str2tree(s));
	}
	
    public TreeNode str2tree(String s) {//1{-1}
    	if(s==null||s.length()==0) {
    		return null;
    	}
    	//"-4(2(3)(1))(6(5)(7))"
    	int lv=0;
    	int rootEnding=s.length()-1;//4
    	int rightStarting=s.length()-1;//4
    	boolean hasLeft=false;
    	boolean hasRight=false;
    	boolean leftDone=false;
    	for(int i=0;i<s.length();i++) {//1{-1}
    		char curChar=s.charAt(i);
    		if(curChar=='('&&lv==0&&!leftDone) {
    			rootEnding=i-1;//0
    			hasLeft=true;
    			lv++;
    		}else if(curChar=='('&&lv==0&&leftDone) {
    			rightStarting=i+1;
    			hasRight=true;
    			lv++;
    		}else if(curChar=='('){
    			lv++;
    		}else if(curChar==')'){
    			lv--;
    			if(lv==0&&!leftDone)
    				leftDone=true;
    		}
    	}
    	
    	if(!hasLeft) {
    		return new TreeNode(Integer.parseInt(s));
    	}else {
      		TreeNode root=new TreeNode(Integer.parseInt(s.substring(0,rootEnding+1)));
    		if(hasRight){
    			root.left=str2tree(s.substring(rootEnding+2,rightStarting-2));
    			root.right=str2tree(s.substring(rightStarting,s.length()-1));
    		}else {
    			root.left=str2tree(s.substring(rootEnding+2,s.length()-1));
    		}
       		return root;
    	}
    	
//    	TreeNode root=new TeeNode(Integer.parseInt(s.substring(0,rootEnding+1))); 
//    	root.left=new TreeNode(Integer.parseInt(s.substring(rootEnding+1,rightStarting-2)));
//    	return root;
    }
}
