/*
Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output: 
Explanation: 
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output: 
Explanation: 
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
Note:
The m and n will be in the range [1, 30000].
The k will be in the range [1, m * n]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


由于 \text{k}k 和 \text{m*n}m*n 最多为 9 * 10^89∗10 
8
 ，线性解将不起作用。???
 
形式化第i行的数为 [1*i, 2*i, 3*i, ..., k*i, ..., n*i]，每一行都有n个数。
假设此时第k个数 k*i 小于等于mid，所以k*i <= mid, k = mid // i，说明这行比小于等于mid的数有k个。
当 k<n时，说明此行有k个数小于等于mid，当 k>=n 时，说明此行的n个数都小于等于mid。
最后遍历所有行，统计所有小于等于mid的数都多少个。

作者：Cowry
链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/er-fen-cha-zhao-si-lu-xiang-jie-python3-by-cowry/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

素数分数稍微多一点处理，就是找到的最合适的分数值d可能不是我们表里面能够构成的分数值，那就需要在原列表里面找到最接近的数据对
可以遍历数据A[i]，通过A[i]/d去查找该数据在原列表中的插入位置，该位置即为分子为i时的最接近数据，找到所有i的最接近d的数据即是答案

作者：hw_wt
链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/er-fen-fa-jie-jue-de-tong-yong-kzhi-lei-wen-ti-by-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    思路：二分法
    1、找第k小，第k大一类的问题，一般情况下都是用二分来解决，那么二分法就需要找到二分的数据点以及比较方式
    2、当前乘法表中最小值肯定是1，最大值为m*n，也就是我们这张表的最小和最大值，数据点找到
    3、比较方式，要找到第k小，那么我们在拿到mid数据点的时候，去看当前mid的位置，如果mid位置大于k，说明mid值太大，需要再次进行二分求解
    4、问题来了，这个位置怎么找呢，假设mid位于指定行i，那么mid/i也就是mid元素的列的位置，如果列的位置大于列最大长度n，那么说明该行所有数据都小于mid，累加n即可
       如果不是呢，说明找到了正确的行，只需要mid/i列的位置也就是这一行小于mid的元素个数
    5、边界条件的处理是二分法中比较重要的，我们要找第k小，那么可以理解为假设当mid处于某个值时，满足了条件，我们需要锁定大值，也就是count>=k，去调整l的值不断逼近
       当l的值逼近到某个数据，使得条件再次满足时，就是循环条件结束的时候，这样可以保证l的值一定是在原列表中的，因为+1或-1都会导致条件不满足
       当然我们的>=条件也是不允许的，因为满足之后l值就被锁定了

作者：hw_wt
链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/er-fen-fa-jie-jue-de-tong-yong-kzhi-lei-wen-ti-by-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo=1;
        int hi=m*n;
        while(lo<hi){
            int mid=lo+(hi-lo+1)/2;
            if(k<=count_lessThan(mid,m,n)){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        return lo;
    }

    private int count_lessThan(int x,int m,int n){
        int count=0;
        for(int i=1;i<=m;i++){
            count+=Math.min(n,(x-1)/i);
        }
        return count;
    }
}