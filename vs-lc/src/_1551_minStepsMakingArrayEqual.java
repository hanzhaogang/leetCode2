public class _1551_minStepsMakingArrayEqual {
    
}


class Solution {
    public int minOperations(int n) {
        int res=0;
        int target= (n%2==0)? ( ( 2*(n/2-1)+1 + 2*(n/2)+1 )/2 ): ( 2*(n/2)+1 );
        for(int i=0;i<n/2;i++){
            res+=target-(2*i+1);
        }
        return res;
    }
}
/*You have an array arr of length n where 
arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n and 
subtract 1 from arr[x] and add 1 to arr[y] (
    i.e. perform arr[x] -=1 and arr[y] += 1). 
    The goal is to make all the elements of the array equal. 
    It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. 
Return the minimum number of operations needed to make all the elements of arr equal.

 

Example 1:

Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
Example 2:

Input: n = 6
Output: 9
 
[1,3,5,7,9,11]

Constraints:

1 <= n <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


Build the array arr using the given formula, define target = sum(arr) / n
What is the number of operations needed to convert arr so that all elements equal target ?

*/