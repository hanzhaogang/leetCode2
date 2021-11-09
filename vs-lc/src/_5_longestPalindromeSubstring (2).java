package leetcode;

/* babad->aba
* cbbd->bb
*/
public class _5_longestPalindromeSubstring {
	public static void main(String[] args) {
		_5_longestPalindromeSubstring s=new _5_longestPalindromeSubstring();
		String str="babad";
		str="cbbd";
		str="bananas";
		System.out.println(s.longestPalindrome(str));
	}
	public String longestPalindrome(String s){
		int len=s.length();
		
		if(len<=1)
			return s;
		
		boolean[][] dp=new boolean[len][len];
		for(int i=0;i<len;i++) {
			dp[i][i]=true;
		}
		int[] maxIndexs=new int[2];
		for(int i=0;i<len-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				dp[i][i+1]=true;
				maxIndexs[0]=i;
				maxIndexs[1]=i+1;
			}
		}
		
		for(int j=2;j<len;j++) {
			for(int i=j-2;0<=i;i--) {
				dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)?true:false;
				if(dp[i][j]&&maxIndexs[1]-maxIndexs[0]<j-i) {
					maxIndexs[0]=i;
					maxIndexs[1]=j;
				}
			}
		}
		
		return s.substring(maxIndexs[0],maxIndexs[1]+1);
	}
	
	
}