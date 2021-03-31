package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1262_GreatestSumDivisiableByTreee {
    public int maxSumDivThree(int[] nums) {
        int res=0;
        for(int num:nums){
            res+=num;
        }
        if(res%3==0)
            return res;

        Arrays.sort(nums);
        List<Integer> _1List=new ArrayList<>();
        List<Integer> _2List=new ArrayList<>();
        for(int num:nums){
            if(num%3==1)
                _1List.add(num);
            else if(num%3==2)
                _2List.add(num);
        }

        int resA=0;
        int resB=0;
        if(res%3==1){
            if(_1List.size()!=0){
                resA=res-_1List.get(0);
            }
            if(2<_2List.size()){
                resB=res-_2List.get(0)-_2List.get(1);
            }
        }else{
            if(_2List.size()!=0){
                resA=res-_2List.get(0);
            }
            if(2<_1List.size()){
                resB=res-_1List.get(0)-_1List.get(0);
            }
        }
        return Math.max(resA,resB);
    }
}
