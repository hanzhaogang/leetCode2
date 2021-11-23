public class 318 {
	public int f(String[] words){
		int n=words.length;
		int[][] counts=new int[n][26];
		for(int i=0;i<n;i++){
			String word=words[i];
			for(int j=0;j<word.length();j++){
				char c=word.charAt(j);
				counts[i][c-'a']++;
			}
		}

		int res=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j) continue;
				boolean ok=true;
				for(int k=0;k<26;k++){
					if(counts[i][k]!=0&&counts[j][k]!=0) ok=false;
				}
				if(ok){
					int cur=words[i].length()*words[j].length();
					if(res<cur){
						res=cur;
					}
				}
			}
		}
		return res;
	}	
}
