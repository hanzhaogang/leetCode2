public class LC0925 {
    public boolean isLongPressedName(String name, String typed) {
    	int p1=0;
    	int p2=0;
    	if(name.length()==0||typed.length()==0) return false;
    	
    	while(p1<name.length()&&p2<typed.length()) {
    		char c1=name.charAt(p1);
    		char c2=typed.charAt(p2);
    		
    		if(c1==c2) {
    			if(p1==name.length()-1&&p2==typed.length()-1)
    				return true;
    			if(c1==name.charAt(c1+1)&&c2==typed.charAt(c2+1)) 
    				p1++;
    			p2++;
    		}else {
    			p1++;
    			c1=name.charAt(p1);
    			if(c1==c2) {
    				p2++;
    			}else {
    				return false;
    			}
    		}
    	}
    
    	return p1==name.length()-1?true:false;
    }
}

/*925. Long Pressed Name
Easy

191

23

Favorite

Share
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

       Input: name = "leeled", 
             typed = "lleeeleeee"

Example 1:

""
"abc"
Input: name = "aalex", 
      typed = "aaleex"

Input: name = "alex", 
      typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", 
      typed = "ssaaedd"

Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", 
      typed = "lleeelee"
      

Output: true
Example 4:

Input: name = "laiden", 
      typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.
*/
