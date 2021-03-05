package fb2020;
/*
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100

Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.

Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.

Example 3:

Input: [20,30,100,110,120]
Output: 3
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

 

Notes:

    1 <= ages.length <= 20000.
    1 <= ages[i] <= 120.
    
    
    
    bf: O(n^2)
    
    O(nlgn)
    sort.
    one will only find friends YOUNGER him.
    one will not find friends who is TOO YOUNG.
    
    
    ->
    O(n)
    
    需要注意数据的特点。
    
 */
public class _827_FriendsOfAppropriateAge {
	public static void main(String[] args) {
		_827_FriendsOfAppropriateAge s=new _827_FriendsOfAppropriateAge();
		int[] ages=new int[] {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
		int res=s.numFriendRequests(ages);
		System.out.println(res);
	}
    public int numFriendRequests(int[] ages) {//16,16//16,17,18
    	//[73,106,39,6,26,15,30,100,71,35,46,112,6,60,110]
    	
    	
    	//put people counts into buckets
    	int[] buckets=new int[121];
    	for(int i=0;i<ages.length;i++) {
    		buckets[ages[i]]++;
    	}
    	
    	int res=0;
    	for(int i=0;i<buckets.length;i++) {
    		if(buckets[i]==0)
    			continue;
    		
    		int count_b=0;
    		for(int j=0;j<i;j++) {
    			if(j<=(0.5*(i))+7)
					continue;
    			res+=buckets[j]*buckets[i];
    			
    		}
			res+=buckets[i-1]*buckets[i];//17:1;
    	}
    	
    	return res;
    }
}


//class Solution {
//    public int numFriendRequests(int[] ages) {
//        int[] count = new int[121];
//        for (int age: ages) count[age]++;
//
//        int ans = 0;
//        for (int ageA = 0; ageA <= 120; ageA++) {
//            int countA = count[ageA];
//            for (int ageB = 0; ageB <= 120; ageB++) {
//                int countB = count[ageB];
//                if (ageA * 0.5 + 7 >= ageB) continue;
//                if (ageA < ageB) continue;
//                ans += countA * countB;
//                if (ageA == ageB) ans -= countA;
//            }
//        }
//
//        return ans;
//    }
//}
