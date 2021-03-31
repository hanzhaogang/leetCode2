package leetCode;

public class _10_regularExpressionMatch {
	
	public static void main(String[] args) {
		_10_regularExpressionMatch solution=new _10_regularExpressionMatch();
		String s="aa";
		String p=".*";
		System.out.println(solution.isMatch(s, p));
	}
    public boolean isMatch(String s, String p) {
        /*  
             "" m i s s i s s i p p i

        ""   t  f f f f f f f f f f f
        m    f  t f f f f f f f f f f
        i    f  f t f f f f f f f f f
        s    f  f f t f f f f f f f f
        *    f  f t t t f f f f f f f
        i    f  f f f f t f f f f f f 
        s    f  
        *    f
        p    f
        *    f
        .    f
        
            "" a a b
        ""  t  f f f
        c   f  f f f
        *   t  f f f
        a   f  t f f
        *   f  t t f
        b   f  f f t

           "" a a 
        "" t  f f
        .  f  t f
        *  
        

        */
        if(s==null||p==null)
            return false;

        int sLen=s.length();
        int pLen=p.length();
        boolean[][] dp=new boolean[pLen+1][sLen+1];
        for(int i=0;i<=pLen;i++){
            for(int j=0;j<=sLen;j++){
                
                if(i==0&&j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    char pChar=p.charAt(i-1);
                    if(pChar!='*')
                        dp[i][j]=false;
                    else
                        dp[i][j]=dp[i-2][j];
                }else{
                    char pChar=p.charAt(i-1);
                    if(pChar!='.'&&pChar!='*'){
                        if(pChar==s.charAt(j-1))
                            dp[i][j]=dp[i-1][j-1];
                        else
                            dp[i][j]=false;
                    }else if(pChar=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }else{//*
                        if(p.charAt(i-2)!=s.charAt(j-1)) {
                        	dp[i][j]=dp[i-2][j];
                        }else{
                        	if(dp[i-1][j]||dp[i][j-1]||dp[i][j-2]) {
                        		dp[i][j]=true;
                        	}
                        }
                    }
                }
            }
        }
        return dp[pLen][sLen];
    }
}


     1
  2       3
4       5

1 2 3 4 5；
4 2   1  5 3

