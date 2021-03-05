package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

"ab" "ac" s3=abac"     

 */
public class _97_InterleavingString {
	public static void main(String[] args) {
		_97_InterleavingString s=new _97_InterleavingString();
		String s1="aabcc";
		String s2="dbbca";
//		String s3="aadbbcbcac";
		String s3="aadbbbaccc";
		System.out.println(s.isInterleave(s1, s2, s3));
	}
	
	int[][] memo2;
	public boolean isInterleave2(String s1, String s2, String s3) {
		memo2=new int[s1.length()][s2.length()];
		for(int i=0;i<memo2.length;i++) {
			for(int j=0;j<memo2[0].length;j++) {
				memo2[i][j]=-1;
			}
		}
		return helper(s1,0,s2,0,s3);
	}
	private boolean helper(String s1,int lo1,String s2,int lo2,
							String s3) {
		if(lo1==s1.length()&&
				s3.substring(lo1+lo2).equals(s2.substring(lo2))||
				lo2==s2.length()&&
				s3.substring(lo1+lo2).equals(s1.substring(lo1))) {
			return true;
		}
		if(lo1==s1.length()&&
				!s3.substring(lo1+lo2).equals(s2.substring(lo2))||
				lo2==s2.length()&&
				!s3.substring(lo1+lo2).equals(s1.substring(lo1))) {
			return false;
		}
		
		char c1=s1.charAt(lo1);
    	char c2=s2.charAt(lo2);
    	char c3=s3.charAt(lo1+lo2);
    	
    	boolean b=false;
    	if(c3==c1) {
    		boolean b1=helper(s1,lo1+1,s2,lo2,s3);
   			if(b1)
   				b=true;
    	}
    	if(!b&&c3==c2) {
    		boolean b2=helper(s1,lo1,s2,lo2+1,s3);
    		if(b2)
    			b=true;
    	}

    	if(memo2[lo1][lo2]==-1) {
    		memo2[lo1][lo2]=b?1:0;
    	}
    	return memo2[lo1][lo2]==1;
	}
	
	Map<String,Boolean> memo=new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()==0) {
    		if(s2.equals(s3)) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    	
    	if(s2.length()==0) {
    		if(s1.equals(s3)) {
    			return true;
    		}else {
    			return false;
    		}
    	}

    	String str=s1+","+s2+","+s3;
    	if(memo.containsKey(str))
    		return memo.get(str);
    	
    	char c1=s1.charAt(0);
    	char c2=s2.charAt(0);
    	char c3=s3.charAt(0);
    	
    	boolean b=false;
    	if(c3==c1) {
    		boolean b1=isInterleave(s1.substring(1),s2,s3.substring(1));
   			if(b1)
   				b=true;
    	}
    	if(!b&&c3==c2) {
    		boolean b2=isInterleave(s1,s2.substring(1),s3.substring(1));
    		if(b2)
    			b=true;
    	}

    	memo.put(str, b);
    	return memo.get(str);
    }
}

class Solution97_1 {
    public boolean is_Interleave(String s1,int i,String s2,int j,
    							String res,String s3) {
        if(res.equals(s3) && i==s1.length() && j==s2.length())
            return true;

        boolean ans=false;
        if(i<s1.length())
            ans|=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
        if(j<s2.length())
            ans|=is_Interleave(s1,i,s2,j+1,res+s2.charAt(j),s3);
        return ans;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return is_Interleave(s1,0,s2,0,"",s3);
    }
}
class Solution97_2 {
   public boolean is_Interleave(String s1, int i, String s2, int j, 
		   						String s3, int k, int[][] memo) {
       if (i == s1.length()) {
           return s2.substring(j).equals(s3.substring(k));
       }
       if (j == s2.length()) {
           return s1.substring(i).equals(s3.substring(k));
       }
       if (memo[i][j] >= 0) {
           return memo[i][j] == 1 ? true : false;
       }
       boolean ans = false;
       if (s3.charAt(k) == s1.charAt(i) && 
    		   is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo) || 
    		   s3.charAt(k) == s2.charAt(j) && 
    		   is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
           ans = true;
       }
       memo[i][j] = ans ? 1 : 0;
       return ans;
   }
   public boolean isInterleave(String s1, String s2, String s3) {
       int memo[][] = new int[s1.length()][s2.length()];
       for (int i = 0; i < s1.length(); i++) {
           for (int j = 0; j < s2.length(); j++) {
               memo[i][j] = -1;
           }
       }
       return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
   }
}
