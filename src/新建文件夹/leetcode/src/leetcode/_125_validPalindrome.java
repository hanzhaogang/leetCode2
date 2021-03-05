package leetcode;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

 

Constraints:

    s consists only of printable ASCII characters.
 */
public class _125_validPalindrome {
	public static void main(String[] args) {
		_125_validPalindrome solution=new _125_validPalindrome();
		String s="A man, a plan, a canal: Panama";
		solution.isPalindrome(s);
	}
    public boolean isPalindrome(String s) {
    	//
    	if(s==null)
    		return false;
    	if(s.length()==0)
    		return true;
    	
    	int lo=0;
    	int hi=s.length()-1;
    	
    	while(lo<hi) {
    		if(!Character.isLetterOrDigit(s.charAt(lo))) {
    			lo++;
    		}else if(!Character.isLetterOrDigit(s.charAt(hi))) {
    			hi--;
    		}else {
    			if(Character.toLowerCase(s.charAt(lo))==Character.toLowerCase(s.charAt(hi))) {
    				lo++;
    				hi--;
    			}else {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

}
