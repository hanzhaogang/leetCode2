import java.util.List;

public class 1447 {
	
}
/* 在第二层循环中，j=i+1,一开始写成了j=2。为了保证分数小于1，j应该永远比i大。
另外，求最大公约数，gdc，可以用辗转相除法，复杂度lgn。*/
class Solution {
    public List<String> simplifiedFractions(int n) {
	List<String> res=new ArrayList<>();
	Set<String> set=new HashSet<>();
	for(int i=1;i<n;i++){
		for(int j=i+1;j<=n;j++){// 4/6
			if(j%i==0){
				set.add("1/"+j/i);
				continue;
			}
			for(int k=i/2;1<=k;k--){
				if(i%k==0&&j%k==0){
					set.add(""+i/k+"/"+j/k);
					break;
				}
			}
		}
	}
	res.addAll(set);
	return res;
    }
}
