package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class _1439 {
	public static void main(String[] args) {
		_1439 s=new _1439();
		int[][] mat= {{1,10,10},{1,4,5},{2,3,6}};
		int k=		27;

		System.out.println(s.kthSmallest(mat, k));
	}
    public int kthSmallest(int[][] mat, int k) {
        int m=mat.length;//2
        Set<List<Integer>> set=new HashSet<>();
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((l1,l2)->{
            int sum1=0;
            for(Integer i=0;i<l1.size();i++){
                sum1+=mat[i][l1.get(i)];
            }
            int sum2=0;
            for(Integer i=0;i<l2.size();i++){
                sum2+=mat[i][l2.get(i)];
            }

            return sum1-sum2;
        });
        List<Integer> indexList=new ArrayList<>();
        for(int i=0;i<m;i++){
            indexList.add(0);
        }

        pq.offer(indexList);
        set.add(indexList);
        int res=0;
        for(int i=0;i<k;i++){
            List<Integer> curList=pq.poll();
            set.remove(curList);

            if(i==k-1){
                for(int j=0;j<m;j++){
                    res+=mat[j][curList.get(j)];
                }
                return res;
            }
            for(int j=0;j<m;j++){
                if(curList.get(j)<mat[0].length-1){
                    List<Integer> newList=new ArrayList<>(curList);
                    newList.set(j,curList.get(j)+1);
                    if(!set.contains(newList)){
                        set.add(newList);
                        pq.offer(newList);
                    }
                    
                }
                
            }
        }
        return res;
    }
}

