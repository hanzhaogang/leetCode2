package leetcode;

import java.util.PriorityQueue;

/*
You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j]. 分数

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

 

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.
Example 2:

Input: arr = [1,7], k = 1
Output: [1,7]
 

Constraints:

2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 104
arr[0] == 1
arr[i] is a prime number for i > 0.
All the numbers of arr are unique and sorted in strictly increasing order.
1 <= k <= arr.length * (arr.length - 1) / 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo=0.0;
        double hi=1.0;
        int[] res=new int[2];
        while(1e-9<hi-lo){
            double mid=lo+(hi-lo+1)/2.0;
            int[] curRes=count(mid,arr);
            if(curRes[0]<k){//number of fraction smaller than mid
                lo=mid;

            }else{
                hi=mid-1;
            }
        }

        return res;
    }

    private int[] count(double x,int[] arr){
        int lo=0;
        int hi_exc=0;
        int count=0;

        while(hi_exc<arr.length){
            int num=arr[hi_exc];
            hi_exc++;
            //update window data

            while(lo<=hi_exc&&((double)arr[lo]/(double)num)<x){//need to shrink the window.
                lo++;
                //update window data
            }

            count+=arr.length-hi_exc;
        }

        return new int[]{count,};
    }

}


/*
使用一个堆记录所有以 primes[j] 为分母且未被弹出的最小分数。依次从堆中弹出 K-1 个元素，此时堆顶的分数就是结果。

算法

在 Python 中，使用 (fraction, i, j) 表示分数 fraction = primes[i] / primes[j]。如果下一个分数有效（即 i+1 < j），那么使用当前分数时，将下一个分数压入堆中。

在Java中，使用记录 {i, j} （i 和 j 是索引，不是 A 中的元素）的 int[2] 表示分数，自定义比较器确保所有分数按照正确顺序存储。

时间复杂度：O(K \log N)O(KlogN)，其中 NN 是 A 的长度，堆中最多压入 NN 个元素，每次弹出为 O(\log N)O(logN)，需要 O(K)O(K) 次弹出操作。

作者：LeetCode
链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/di-k-ge-zui-xiao-de-su-shu-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
作者：LeetCode
链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/di-k-ge-zui-xiao-de-su-shu-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


这个题由于数据范围 A.length <= 2000, 所以可以容许 O(N^2) 复杂度的算法通过.

法二实际上就相当于把所有的可能的分数放到 堆 中，取前 K 个（使用了一个技巧让堆中的分数的个数 < N）。由于 K 最大为 N*(N-1)/2, 故时间复杂度是 O(N^2) 的。

另外 ”A 的取值范围在 2 — 2000“ 逼我去看了英文题目。
Klg(N^2)=N^2*

class Solution {//1,2,3,5;k=3
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);//3-2 小顶堆

                (a,b)->{
                    return A[a[0]]/A[a[1]]-A[b[0]]/A[b[1]]
                }
        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});//[0,1];[0,2];[0,3]; 1/5,1/3,1/2,并没有把分数全部放进去

        while (--K > 0) {
            int[] frac = pq.poll();//1/5 [0,3] 1/3 [0,2]
            if (frac[0]++ < frac[1])
                pq.offer(frac);//[1,3] 2/5 [1,2] 2/3
        }

        int[] ans = pq.poll();
        return new int[]{A[ans[0]], A[ans[1]]};
    }
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/di-k-ge-zui-xiao-de-su-shu-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/


// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] primes, int K) {
//         double lo = 0, hi = 1;
//         int[] ans = new int[]{0, 1};

//         while (hi - lo > 1e-9) {//看题，如果是保留6位小数就是-8，4位就是-6，总之大2就行
//             double mi = lo + (hi - lo) / 2.0;
//             int[] res = under(mi, primes);
//             if (res[0] < K) {
//                 lo = mi;
//             } else {
//                 ans[0] = res[1];
//                 ans[1] = res[2];
//                 hi = mi;
//             }
//         }
//         return ans;
//     }

//     public int[] under(double x, int[] primes) {
//         // Returns {count, numerator, denominator}
//         int numer = 0, denom = 1, count = 0, i = -1;
//         for (int j = 1; j < primes.length; ++j) {
//             // For each j, find the largest i so that primes[i] / primes[j] < x
//             // It has to be at least as big as the previous i, so reuse it ("two pointer")
//             while (primes[i+1] < primes[j] * x) ++i;

//             // There are i+1 fractions: (primes[0], primes[j]),
//             // (primes[1], primes[j]), ..., (primes[i], primes[j])
//             count += i+1;
//             if (i >= 0 && numer * primes[j] < denom * primes[i]) {
//                 numer = primes[i];
//                 denom = primes[j];
//             }
//         }
//         return new int[]{count, numer, denom};
//     }
// }

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/di-k-ge-zui-xiao-de-su-shu-fen-shu-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public int[] kthSmallestPrimeFraction(int[] A, int K) {
    // 因为分数是在(0,1)范围内，所以在此范围使用二分查找
    double lo = 0, hi = 1, mid;
    int p = 0, q = 1;
    int i, j;
    int count;
    // 因为是在小数内使用二分查找，无法像在整数范围内那样通过 mid+1和边界判断来终止循环
    // 所以此处根据count来结束循环
    while (true) {
        mid = (lo + hi) / 2;
        count = 0;
        p = 0;
        for (i = 0; i < A.length; i++) {
            j = 0;
            while (j < A.length-1-i && mid >= (double) A[i]/A[A.length-1-j]) {
                j++;
            }
            count += j;
            // 重点：p/q是比 mid小的数中的最大值(所有行)
            if (j > 0 && ((double)p/q) < ((double)A[i]/A[A.length-j])) {
                p = A[i];
                q = A[A.length-j];
            }
        }
        if (count > K) hi = mid;
        else if (count < K) lo = mid;
        else return new int[]{p, q};
    }
}

作者：caipengbo
链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/jian-dan-yi-dong-de-javaer-fen-cha-zhao-by-caipeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





public int[] kthSmallestPrimeFraction(int[] A, int K) {
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
        return A[a[0]]*A[b[1]]-A[b[0]]*A[a[1]];
    });
    for(int i=0;i<A.length;i++){
        pq.offer(new int[]{0,i});
    }

    int i=1;
    while(i<K){
        int[] polled=pq.poll();
        if(polled[0]<polled[1]){
            pq.offer(new int[]{polled[0]+1,polled[1]});
        }
        i++;
    }


    int[] indexs=pq.poll();
    return new int[]{A[indexs[0]],A[indexs[1]]};
}