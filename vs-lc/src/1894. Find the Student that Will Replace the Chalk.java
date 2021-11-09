public class 1894. Find the Student that Will Replace the Chalk {
	
}
/* There are n students in a class numbered from 0 to n - 1. 
The teacher will give each student a problem starting with the student number 0, 
then the student number 1, 
and so on until the teacher reaches the student number n - 1. 
After that, the teacher will restart the process, starting with the student number 0 again.

You are given a 0-indexed integer array chalk and an integer k. 
There are initially k pieces of chalk. 
When the student number i is given a problem to solve, 
they will use chalk[i] pieces of chalk to solve that problem. 
However, if the current number of chalk pieces is strictly less than chalk[i], 
then the student number i will be asked to replace the chalk.

Return the index of the student that will replace the chalk.

 

Example 1:

Input: chalk = [5,1,5], k = 22
Output: 0
Explanation: The students go in turns as follows:
- Student number 0 uses 5 chalk, so k = 17.
- Student number 1 uses 1 chalk, so k = 16.
- Student number 2 uses 5 chalk, so k = 11.
- Student number 0 uses 5 chalk, so k = 6.
- Student number 1 uses 1 chalk, so k = 5.
- Student number 2 uses 5 chalk, so k = 0.
Student number 0 does not have enough chalk, so they will have to replace it.
Example 2:

Input: chalk = [3,4,1,2], k = 25
Output: 1
Explanation: The students go in turns as follows:
- Student number 0 uses 3 chalk so k = 22.
- Student number 1 uses 4 chalk so k = 18.
- Student number 2 uses 1 chalk so k = 17.
- Student number 3 uses 2 chalk so k = 15.
- Student number 0 uses 3 chalk so k = 12.
- Student number 1 uses 4 chalk so k = 8.
- Student number 2 uses 1 chalk so k = 7.
- Student number 3 uses 2 chalk so k = 5.
- Student number 0 uses 3 chalk so k = 2.
Student number 1 does not have enough chalk, so they will have to replace it.
 

Constraints:

chalk.length == n
1 <= n <= 105
1 <= chalk[i] <= 105
1 <= k <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
数学问题，解为：首先经过n轮循环（n有可能为0），在第n+1轮循环中，停在某一个学生上。
首先，遍历一遍数组，并累加chalk，计算所有学生需要的sum。
如果sum数超过了k，则终止遍历、输出结果。
如果没有超出，则用如下方式更新K：k=k%sum。
然后再次遍历数组，这次sum一定会超过更新后的k，终止遍历时输出结果就OK。*/
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
	int sum=0;
	for(int i=0;i<chalk.length;i++){
		sum+=chalk[i];
		if(k<sum){
			return i;
		}
	}
	k=k%sum;
	sum=0;
	for(int i=0;i<chalk.length;i++){
		sum+=chalk[i];
		if(k<sum){
			return i;
		}
	}
	return -1;
    }
}