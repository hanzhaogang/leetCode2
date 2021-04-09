public class _1697_min {
    
}

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];
        int count_1=0;
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)-'0'==1){
                res[0]+=i;
                count_1++;
            }

        }

        int count_1_left=count_1;
        for(int i=1;i<res.length;i++){
            if(boxes.charAt(i-1)-'0'==1){
                count_1_left--;
            }

            res[i]=res[i-1]-count_1_left+(count_1-count_1_left);
        }

        
        return res;
    }
}