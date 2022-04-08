public class 327 {
	
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

    }
}

/* range sum 小于upper的个数？

依然考虑前缀和数组 \textit{preSum}preSum。

对于每个下标 jj，以 jj 为右端点的下标对的数量，就等于数组 \textit{preSum}[0..j-1]preSum[0..j−1] 中的所有整数，出现在区间 [\textit{preSum}[j]-\textit{upper}, \textit{preSum}[j]-\textit{lower}][preSum[j]−upper,preSum[j]−lower] 的次数。故很容易想到基于线段树的解法。

我们从左到右扫描前缀和数组。每遇到一个数 \textit{preSum}[j]preSum[j]，我们就在线段树中查询区间 [\textit{preSum}[j]-\textit{upper}, \textit{preSum}[j]-\textit{lower}][preSum[j]−upper,preSum[j]−lower] 内的整数数量，随后，将 \textit{preSum}[j]preSum[j] 插入到线段树当中。

注意到整数的范围可能很大，故需要利用哈希表将所有可能出现的整数，映射到连续的整数区间内。
