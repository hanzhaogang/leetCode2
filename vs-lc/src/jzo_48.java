import java.util.HashMap;
import java.util.Map;

public class jzo_48 {
	public static void main(String[] args){
		String s="aa";
		System.out.println(new jzo_48().lengthOfLongestSubstring(s));
	}
	    public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> char2index=new HashMap<>();//aa
		int lo=0,hi=0;
		int n=s.length();//2
		int res=0;
		while(hi<n){//0,2;1,2
			if(!char2index.containsKey(s.charAt(hi))){
				char2index.put(s.charAt(hi),hi);//a,0

			}else{
				if(res<hi-lo){//1,0
					res=hi-lo;
				}
				int old_lo=lo;//0
				lo=char2index.get(s.charAt(hi))+1;//1

				for(int i=old_lo;i<=lo-1;i++){
					char2index.remove(s.charAt(i));//empty
				}
				char2index.put(s.charAt(hi),hi);
			}
			hi++;
		}
		if(res<hi-lo){
			res=hi-lo;
		}
		return res;
    }	
}
