import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 2080 {
	
}
class RangeFreqQuery {
    Map<Integer,List<Integer>> val2arrIndexs;
    int[] arr;
    public RangeFreqQuery(int[] arr) {
        this.arr=arr;
        val2arrIndexs=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<arr.length;i++){
            List<Integer> arrIndexs=val2arrIndexs.containsKey(arr[i])?val2arrIndexs.get(arr[i]):new ArrayList<Integer>();
            arrIndexs.add(i);
            val2arrIndexs.put(arr[i],arrIndexs);
        }
    }
    
    public int query(int left, int right, int value) {
        if(!val2arrIndexs.containsKey(value))
            return 0;
        List<Integer> arrIndexs=val2arrIndexs.get(value);
        int l=helper(arrIndexs,left);
        if(left==3) System.out.println(l);
        
         int r=helper(arrIndexs,right);
         if(left==3) System.out.println(r);
         if(right<arrIndexs.get(0) || arrIndexs.get(arrIndexs.size()-1)<left)
            return 0;
       
        
        if(r==-1){
            return arrIndexs.size()-l;
        }
        
        if(value==arr[r])
            return r-l+1;
        else
            return r-l;
    }
    // find first arr index that is larger than or equals to t
    private int helper(List<Integer> arrIndexs,int t){
        int res=-1;
        int l=0,h=arrIndexs.size()-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(t<=arrIndexs.get(mid) && (mid-1<0 || arrIndexs.get(mid-1)<t))
                return mid;
            else if(t<=arrIndexs.get(mid) )
                h=mid-1;
            else
                l=mid+1;
        }
        return res;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */