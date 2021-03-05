import java.util.Arrays;

/*813. Largest Sum of Averages
Medium

484

16

Favorite

Share
We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input: 
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation: 
The best choice is to partition A into [9], [1, 2, 3], [9]. 
The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 

Note:

1 <= A.length <= 100.
1 <= A[i] <= 10000.
1 <= K <= A.length.
Answers within 10^-6 of the correct answer will be accepted as correct.

*/


public class LC0813_LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        Arrays.sort(A);
        double firstSum=0;
        for(int i=0;i<=A.length-K;i++){
            firstSum+=A[i];
        }
        double firstAvg=firstSum/(A.length-K+1);
        
        double result=firstAvg;
        for(int i=A.length-K+1;i<A.length;i++){
            result+=A[i];
        }
        
        return result;
    }
}
