package fb2020;
/*
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
    
    use two pointers, lo&hi, if chars are the same, continue(lo++&hi--); else 
    
    bcbbc
 */
public class _680_ValidPalindrome2 {
    public boolean validPalindrome(String s) {
    	int lo=0;
    	int hi=s.length()-1;
    	
    	while(lo<hi) {
    		if(s.charAt(lo)==s.charAt(hi)) {
    			lo++;
    			hi--;
    		}else {
    			if(isPalindrome(s.substring(lo+1,Math.min(s.length(), hi+1)))||isPalindrome(s.substring(lo,hi))) {
    				return true;
    			}else {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    private boolean isPalindrome(String s) {
    	int lo=0;
    	int hi=s.length()-1;
    	
    	while(lo<hi) {
    		if(s.charAt(lo)!=s.charAt(hi)) {
    			return false;
    		}
    		
    		lo++;
    		hi--;
    	}
    	
    	return true;
    }
}
