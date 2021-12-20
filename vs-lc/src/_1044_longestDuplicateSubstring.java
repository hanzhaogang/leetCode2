package leetCode;

import java.util.HashSet;
import java.util.Set;
/*
 * banana -> ana
 */
public class _1044_longestDuplicateSubstring {
	public static void main(String[] args) {
		String str="banana";
		_1044_longestDuplicateSubstring s=new _1044_longestDuplicateSubstring();
		System.out.println(s.longestDupSubstring(str));
	}
	
	String res="";
	public String longestDupSubstring(String S) {
		bs(S,1,S.length());
		return res;
	}
	
	private int bs(String S,int lo,int hi) {
		if(hi<lo)
			return -1;
		
		int mid=lo+(hi-lo)/2;
		if(hasDup(S,mid)&&!hasDup(S,mid+1)) {
			return mid;
		}
		
		if(hasDup(S,mid)&&hasDup(S,mid+1)) {
			return bs(S,mid+1,hi);
		}else {
			return bs(S,lo,mid-1);
		}
	}
	private boolean hasDup(String S,int len) {
		Set<Long> set=new HashSet<>();
		
		Long hashVal=(long)(S.charAt(0)-'a');
		Long largestRadix=1L;
		for(int i=1;i<len;i++) {
			hashVal=hashVal*26+(S.charAt(i)-'a');
			largestRadix=largestRadix*26;
		}
		set.add(hashVal);
				
		for(int i=len;i<S.length();i++) {
			hashVal=(hashVal-(S.charAt(i-len)-'a')*largestRadix)*26+S.charAt(i)-'a';
			if(!set.contains(hashVal)) {
				set.add(hashVal);
			}else {
				String substr=S.substring(i-(len-1),i+1);
				if(res.length()<substr.length())
					res=substr;
				return true;
			}
		}
		return false;
	}
}