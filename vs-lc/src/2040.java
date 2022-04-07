import java.util.Arrays;

public class 2040 {
	
}
//最终ac版。
/* 这道题做了整整一天，不夸张。。
教训就是，还是要找回之前的状态：确保每一个key的敲击，都是经过三思的。
记得的错误：
太多的typo，
二分查找失败后res的累加，
超出int表示范围的问题。

再次证明，bug越到后期越难以找到。
 */
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
         long n1l=nums1[0],n1h=nums1[nums1.length-1],n2l=nums2[0],n2h=nums2[nums2.length-1];
        long[] arr=new long[]{n1l*n2l,n1l*n2h,n1h*n2l,n1h*n2h};
        // System.out.println(-100000*100000);
        Arrays.sort(arr);
        long l=arr[0],h=arr[arr.length-1];
        // System.out.println(l+"l");
        // System.out.println(h+"h");
        long res=nums1[0]*nums2[0];
        while(l<=h){
            long mid=l+(h-l)/2;
            // System.out.println("m"+mid);
            if(counts(mid-1,nums1,nums2,k)<k && k<=counts(mid,nums1,nums2,k)){
                return mid;//-19
            }else if(counts(mid,nums1,nums2,k)<k){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return res;
    }
    //count how many products are less thant or equal to p
    private long counts(long p,int[] nums1,int[] nums2,long k){//-19 k=1
        
        long res=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0){
                if(0<=p){
                    res+=nums2.length;
                    // if(p==0) System.out.println(res);
                }
            }else{
                // int t=(int)(p/(long)nums1[i]);
                int l=0,h=nums2.length-1;
                int loc=-1;
                if(nums1[i]<0){//找第一个等于或、比商大的---不对。 此时products从大到小排。 -4
                    while(l<=h){
                        int mid=l+(h-l)/2;
                        // if(mid==5) System.out.println(l+","+h);
                        if((p<(long)nums2[mid]*(long)nums1[i] )&& (nums2.length<=mid+1 || (long)nums2[mid+1]*(long)nums1[i]<=p) ){
                            loc=mid;
                            // if(i==0&&p==-10) System.out.println(loc+"loc");
                            break;
                        }else if(p<(long)nums2[mid]*(long)nums1[i]){
                            l=mid+1;
                        }else{
                            h=mid-1;
                        }
                    }
                    res+=loc==-1?nums2.length:(nums2.length-loc-1);
                    // if(i==0) System.out.println(res+"res2");
                }else{//最后一个等于、或比商小的----错。 此时products从小到大排
                    while(l<=h){
                        int mid=l+(h-l)/2;
                        if(p<(long)nums2[mid]*(long)nums1[i] && (mid-1<0 || (long)nums2[mid-1]*(long)nums1[i]<=p)){
                            loc=mid;
                            break;
                        }else if(p<(long)nums2[mid]*(long)nums1[i]){
                            h=mid-1;
                        }else{
                            l=mid+1;
                        }
                    }
                    res+=loc==-1?nums2.length:loc;
                }
            }
        }
        // if(p==-10) System.out.println(res+"res");
        return res;
    } 
}

/* 
[-4,-2,0,3]
[2,4]
1
*/
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1l=nums1[0],n1h=nums1[nums1.length-1],n2l=nums2[0],n2h=nums2[nums2.length-1];
        long[] arr=new long[]{n1l*n2l,n1l*n2h,n1h*n2l,n1h*n2h};
        Arrays.sort(arr);
        long l=arr[0],h=arr[arr.length-1];

        int res=nums1[0]*nums2[0];
        while(l<=h){
            long mid=l+(h-l)/2;
            if(counts(mid-1,nums1,nums2,k)<k && k<=counts(mid,nums1,nums2,k)){
                return mid;//-19
            }else if(counts(mid,nums1,nums2,k)<k){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return res;
    }
    //count how many products are less thant or equal to p
    private long counts(long p,int[] nums1,int[] nums2,long k){//-19 k=1
        long res=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0){
                if(0<=p){
                    res+=nums2.length;
                }
            }else{
                // int t=(int)(p/(long)nums1[i]);
                int l=0,h=nums2.length-1;
                int loc=-1;
                if(nums1[i]<0){//找第一个等于或、比商大的---不对。 此时products从大到小排。
                    while(l<=h){
                        int mid=l+(h-1)/2;
                        if(p<nums2[mid]*nums1[i]&& (nums2.length<=mid+1 || nums2[mid+1]*nums2[i]<=p) ){
                            loc=mid;
                            break;
                        }else if(p<nums2[mid]*nums1[i]){
                            l=mid+1;
                        }else{
                            h=mid-1;
                        }
                    }
                    res+=loc==-1?0:(nums2.length-loc-1);
                }else{//最后一个等于、或比商小的----错。 此时products从小到大排
                    while(l<=h){
                        int mid=l+(h-l)/2;
                        if(p<nums2[mid]*nums1[i] && (mid-1<0 || nums2[mid-1]*nums1[i]<=p)){
                            loc=mid;
                            break;
                        }else if(p<nums2[mid]*nums1[i]){
                            h=mid-1;
                        }else{
                            l=mid+1;
                        }
                    }
                    res+=loc==-1?0:loc;
                }
            }
        }
        return res;
    } 
}


/* Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, 
return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 

Example 1:

Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The 2 smallest products are:
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
The 2nd smallest product is 8.
Example 2:

Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
Explanation: The 6 smallest products are:
- nums1[0] * nums2[1] = (-4) * 4 = -16
- nums1[0] * nums2[0] = (-4) * 2 = -8
- nums1[1] * nums2[1] = (-2) * 4 = -8
- nums1[1] * nums2[0] = (-2) * 2 = -4
- nums1[2] * nums2[0] = 0 * 2 = 0
- nums1[2] * nums2[1] = 0 * 4 = 0
The 6th smallest product is 0.
Example 3:

Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
Output: -6
Explanation: The 3 smallest products are:
- nums1[0] * nums2[4] = (-2) * 5 = -10
- nums1[0] * nums2[3] = (-2) * 4 = -8
- nums1[4] * nums2[0] = 2 * (-3) = -6
The 3rd smallest product is -6.
 

Constraints:

1 <= nums1.length, nums2.length <= 5 * 104
-105 <= nums1[i], nums2[j] <= 105
1 <= k <= nums1.length * nums2.length
nums1 and nums2 are sorted.
*/



















































































/* Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 

Example 1:

Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The 2 smallest products are:
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
The 2nd smallest product is 8.
Example 2:

Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
Explanation: The 6 smallest products are:
- nums1[0] * nums2[1] = (-4) * 4 = -16
- nums1[0] * nums2[0] = (-4) * 2 = -8
- nums1[1] * nums2[1] = (-2) * 4 = -8
- nums1[1] * nums2[0] = (-2) * 2 = -4
- nums1[2] * nums2[0] = 0 * 2 = 0
- nums1[2] * nums2[1] = 0 * 4 = 0
The 6th smallest product is 0.
Example 3:

Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
Output: -6
Explanation: The 3 smallest products are:
- nums1[0] * nums2[4] = (-2) * 5 = -10
- nums1[0] * nums2[3] = (-2) * 4 = -8
- nums1[4] * nums2[0] = 2 * (-3) = -6
The 3rd smallest product is -6.
 

Constraints:

1 <= nums1.length, nums2.length <= 5 * 104
-105 <= nums1[i], nums2[j] <= 105
1 <= k <= nums1.length * nums2.length
nums1 and nums2 are sorted.
*/