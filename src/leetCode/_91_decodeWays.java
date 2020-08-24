package leetCode;

import java.util.HashMap;
import java.util.Map;

public class _91_decodeWays {
	
	public static void main(String[] args) {
		String s="226";
		_91_decodeWays solution=new _91_decodeWays();
		System.out.println(solution.numDecodings(s));
	}
	Map<String,Integer> memo=new HashMap<>();
	
    public int numDecodings(String s) {
    	if(memo.containsKey(s)) {
    		return memo.get(s);
    	}
    	
    	if(s.equals(""))
    		return 1;
    	
    	if(s.length()==1) {
    		if(s.charAt(0)=='0')
    			return 0;
    		else
    			return 1;
    	}
    	
    	char c1=s.charAt(0);
    	char c2=s.charAt(1);
    	
    	if(c1=='0') {
    		memo.put(s, 0);
    		return 0;
    	}
    	if(c1=='1') {
    		if(c2=='0') {//1026: 
    			memo.put(s, numDecodings(s.substring(2)));
    			return memo.get(s);
    		}else {//1926,110
    			memo.put(s, numDecodings(s.substring(1))+numDecodings(s.substring(2)));
    			return memo.get(s);

    		}
    	}
    	
    	if(c1=='2') {
    		if('0'<c2&&c2<='6') {//226:2 2 6 2 26 22 6
    			memo.put(s, numDecodings(s.substring(1))+numDecodings(s.substring(2)));
    			return memo.get(s);
    		}else {
    			memo.put(s, numDecodings(s.substring(2)));
    			return memo.get(s);
    		}
    			
    	}
    	memo.put(s, numDecodings(s.substring(1)));
		return memo.get(s);
    }
}
