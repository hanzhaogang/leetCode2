public class 838 {
	
}
class Solution {
    public String pushDominoes(String dominoes) {
	int l=0,h=0;
	StringBuilder sb=new StringBuilder();
	while(h<dominoes.length()){
		if(l==h&&dominoes.charAt(l)=='L'){
			sb.append('L');
			l++;
			h++;
		}else if(l==h&&dominoes.charAt(l)=='R'&&l==dominoes.length()-1){
			sb.append('R');
			l++;
			h++;
		}else if(l==h&&dominoes.charAt(l)=='R'&&dominoes.charAt(l+1)!='.'){
			sb.append('R');
			l++;
			h++;
		}else if(l==h&&dominoes.charAt(l)=='R'){
			h++;
		}else if(l==h&&dominoes.charAt(l)=='.'){
			h++;
		}else if(l<h&&dominoes.charAt(h)=='.'){
			h++;
		}else{
			if(dominoes.charAt(h)=='L'){
				if(dominoes.charAt(l)=='.'){
					for(int i=0;i<h-l;i++){
						sb.append(dominoes.charAt(l));
					}
					l=h;
				}else{
					for(int i=0;i<(h-l-1)
					h++;
					l=h;
				}
			}else {
				
					for(int i=0;i<h-l;i++)
						sb.append(dominoes.charAt(l));
				
				l=h;
			}
		}
	}
    }
}