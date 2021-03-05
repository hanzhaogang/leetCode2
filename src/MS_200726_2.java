package leetcode;

public class MS_200726_2 {
    public int solution(String S) {
    	int lo=0;
    	while(lo<S.length()&&S.charAt(lo)=='0') {
    		lo++;
    	}

    	int res=0;
    	for(int i=S.length()-1;lo<=i;i--) {
    		if(i==lo) {
    			res++;
    			break;
    		}else {
    			char c=S.charAt(i);
    			if(c=='1') {
    				res=res+2;
    			}else {
    				res++;
    			}
    		}
    	}
    	
    	return res;
    }
}
