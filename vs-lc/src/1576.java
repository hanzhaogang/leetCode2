public class 1576 {
	public String modifyString(String s){
		int l,r=-1;
		boolean bool=false;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='?'){
				if(!bool){
					l=i-1;
				}
				bool=true;
			}else{
				if(bool){
					r=i;
				}
				char c1=l==-1?s.charAt(r):s.charAt(l);
				char c2=s.charAt(r);
				if(c1==c2){
					char a=c1=='a'?z:(c1-1);
					char b=c1=='z'?a:(c1+1);
				}else{
					char a=c1=='z'?a:(c1+1);
					char b=c2=='z'?a:(c2+1);
				}

				bool=false;
			}
		}
	}

	public String modifyString(String s){
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='?'){
				if(i==0){
					if((i+1<s.length())&&s.charAt(i+1)!='?'){
						if()
					}
				}
			}
		}
	}
}
