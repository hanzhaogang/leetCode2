public class 838 {
	
}

class Solution {
    public String pushDominoes(String dominoes) {
	int n=dominoes.length();
	int l=0,h=0;
	StringBuilder sb=new StringBuilder();
	while(h<n){
		if(l==h){
			char lc=dominoes.charAt(l);
			if(lc=='L'){
				sb.append(dominoes.charAt(l));
				l++;
				h++;
			}else if(lc=='.'){
				h++;
			}
		}else{
			char hc=dominoes.charAt(h);
			if(hc=='.'){
				h++;
			}else if(hc=='l'){
				int c=h-l;
				for(int i=0;i<c/2;i++){
					sb.append('R');
				}
				if((c-1)%2==0)
					sb.append('.');
				for(int i=0;i<c/2;i++){
					sb.append('L');
				}
				h++;
				l=h;
			}else{
				for(int i=0;i<h-l;i++){
					sb.append('R');
				}
				l=h;
			}
		}
	}
	return sb.toString();
    }
}