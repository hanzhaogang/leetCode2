public class 798 {
	
}

/* 思路分析：这道题可能大家都是想着直接移动，然后计算分数，再取最高值。蛋式A的长度比较大的时候耗时就非常大了。

我们以A=[2,3,1,4,0]为例寻找规律:

A[0]=2移动到 2 号索引位置[4,0,2,3,1]其对应的K为3=(0-A[0]+5)%5
A[1]=3移动到 3 号索引位置[0,2,3,1,4]其对应的K为3=(1-A[1]+5)%5
A[2]=1移动到 1 号索引位置[3,1,4,0,2]其对应的K为1=(2-A[2]+5)%5
A[3]=4移动到 4 号索引位置[0,2,3,1,4]其对应的K为1=(3-A[3]+5)%5
A[4]=0移动到 0 号索引位置[0,2,3,1,4]其对应的K为3=(4-A[4]+5)%5

由此可以得出一个公式，将A[i]向左移动到下标A[A[i]]的位置需要K = (i - A[i] + N) % N
并且我们发现，A[A[i]]是第一个A[i]能得分的位置，如果这时减小K，则A[i]继续得分，如果增大K则A[i]将不得分。
如果我们能够刚好把所有A[i]都移动到A[A[i]]的位置，那么我们拿到的分数肯定的是最高的，蛋式这种情况几乎不可能。

当我们把A[i]移动到A[A[i]]后，再向左移动一个位置（即K增加1）。A[i]的移动公式为K’ = (1 + i - A[i] + N) % N这个时候A[i]刚好不得分。

我们可以在这个刚好不得分的k标记一下，通过+1进行标记，这个k就是 (i - A[i] + 1 + N) % N。用一个长度为N
的myK数组，对于每个元素A[i]，我们都找到其刚好不得分的k = (i - A[i] + 1 + N) % N，那么此时myK[k]就表示
数组中的数字在K = k时，A数组中不得分的元素个数。

可以发现，如果当K = k时，A[i]刚好不得分，当K = k + 1时（左移一个）A[i]继续不得分，蛋式当K = k + 1时
有一个元素开始得分了，就是在当K = k处于A[0]的元素开始得分！！！

因此递推公式为：myK[k + 1] += myK[k] - 1 */