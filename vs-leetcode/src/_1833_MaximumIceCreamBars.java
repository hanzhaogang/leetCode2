import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1833_MaximumIceCreamBars {
    
}
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int cost:costs){
            pq.add(cost);
        }

        while(!pq.isEmpty()){
            int cost=pq.poll();
            if(cost<=coins){
                res+=1;
                coins-=cost;
            }else{
                break;
            }
        }

        return res;
    }
}