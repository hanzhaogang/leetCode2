public class 2024 {

	
}
/* TTFTTFTTFFF 

TT 1
F 1*/
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if(answerKey.length()==1)
            return 1;
        int m1=helper(answerKey,k,'T');
        int m2=helper(answerKey,k,'F');
        return m1<m2?m2:m1;
    }
    private int helper(String answerKey,int k,char ch){//TT 1 T
        int l=0,h=0;
        int c=0;
        int max=0;
        while(h<answerKey.length()){
            h++;
            if(answerKey.charAt(h-1)!=ch)
                c++;
            else{
                if(0<k){
                    c++;
                    k--;
                }else{
                    if(max<h-l) max=h-l;
                    while(answerKey.charAt(l)!=ch){
                        l++;
                        c--;
                    }
                    l++;
                    c--;
                    k++;
                }
            }
        }
        if(max<h-l) max=h-l;
        return max;
    }
}
