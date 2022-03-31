public class LC2024 {
    public static void main(String[] args){
        String answerKey="TTFTTTTTFTTFF";
        int k=1;
        Solution s=new Solution();
        s.maxConsecutiveAnswers(answerKey,k);
    }
	
}
/* TTFTTFTTFFF 

TT 1
F 1

"TFFT"
1


这道题需要重点说明一下。
sliding windows的题，需要特别注意细节，一不小心，出错，很难debug。跟链表有点像。
注意点：1 区间开闭问题。在本题中，我的处理是l h都是闭区间。h++在循环最后面，前面是处理当前的h。
2. 当k值为0、变换有用尽时，如果当前h的值为需要变换的char，那么： 首先收缩l，然后记得处理h并给c++。
*/
class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if(answerKey.length()==1)
            return 1;
        int m1=helper(answerKey,k,'T');
        int m2=helper(answerKey,k,'F');
        return m1<m2?m2:m1;
    }
    private int helper(String answerKey,int k,char ch){//TFFT 1 T
        int c=0;
        int max=0;
        int l=0,h=0;
        while(h<answerKey.length()){
            if(answerKey.charAt(h)!=ch)
                c++;
            else{
                if(0<k){
                    c++;
                    k--;
                }else{
                    if(max<c) max=c;
                    while(answerKey.charAt(l)!=ch){
                        l++;
                        c--;
                    }
                    l++;
                    c--;
                    k++;
                    c++;//可以处理当前h了，处理一下。
                    k--;
                }
            }
            h++;
        }
        if(max<c) max=c;
        return max;
    }
}
