import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * input:
 * 1,2,3,4,5
 * 6,7,8,9,10
 * output:
 * [[1,2,3,4,5],[6,7,8,9,10]]
 */
public class Company_Shopee_1 {
	public String[][] parseCVSStr(String s) {
		if(s==null||s.length()==0)
			return null;
		
		List<List<String>> res=new ArrayList<>();
		boolean preCommar=false;
		int preQuate=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			
			
			if(c=='"') {
				if(preCommar==false) {
					preCommar=true;
					
				}else {
					
				}
			}
		}
		
		return null;
	}
}


