package leetCode;
/*
 * Koko loves to eat bananas.  
 * There are N piles of bananas, the i-th pile has piles[i] bananas.  
 * The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  
Each hour, she chooses some pile of bananas, 
and eats K bananas from that pile.  
If the pile has less than K bananas, 
she eats all of them instead, 
and won't eat any more bananas during this hour.

Koko likes to eat slowly, 
but still wants to finish eating all the bananas 
before the guards come back.

Return the minimum integer K 
such that she can eat all the bananas within H hours.

 

Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23

 

Constraints:

    1 <= piles.length <= 10^4
    piles.length <= H <= 10^9
    1 <= piles[i] <= 10^9
 */
public class _875_kokoEatingBananas {
	public static void main(String[] args) {
		int[] piles=new int[] {3,6,7,11};
		_875_kokoEatingBananas s=new _875_kokoEatingBananas();
		System.out.print(s.minEatingSpeed(piles, 8));
	}

    public int minEatingSpeed(int[] piles, int H) {
    	int minK=1;
    	int maxK=0;
    	for(int pile:piles) {
    		if(maxK<pile)
    			maxK=pile;
    	}
    	
    	return bs(piles,H,minK,maxK);//1,11
    }
    
    private int bs(int[] piles,int H,int lo,int hi) {//1,5;4,5
    	if(hi<lo)
    		return -1;
    		
    	int mid=lo+(hi-lo)/2;//6;3;4
    	if( (timing(piles,mid)<=H) && 
    			( mid==1 || ( (H<timing(piles,mid-1) ) ) ) 
    			) {
    		return mid;
    	}
    	if( (timing(piles,mid)<=H) && (1<mid) && timing(piles,mid-1)<=H ) {
    		return bs(piles,H,lo,mid-1);//1,5
    	}
    	return bs(piles,H,mid+1,hi);//4,5
    }
    
    private int timing(int[] piles,int K) {//timing less or equal to H means can do.
    	int hours=0;
    	for(int pile:piles) {
    		hours+=pile%K==0?(pile/K):(pile/K+1);
    	}
    	return hours;
    }
}
