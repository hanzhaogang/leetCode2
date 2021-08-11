public class 1792. Maximum Average Pass Ratio {
	
}
/* There is a school that has classes of students and each class will be having a final exam. 
You are given a 2D integer array classes, where classes[i] = [passi, totali]. 
You know beforehand that in the ith class, there are totali total students, 
but only passi number of students will pass the exam.

You are also given an integer extraStudents. 
There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. 
You want to assign each of the extraStudents students to a class 
in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to 
the number of students of the class that will pass the exam divided by the total number of students of the class. 
The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. 
Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: 
You can assign the two extra students to the first class. 
The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
Example 2:

Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485
 

Constraints:

1 <= classes.length <= 105
classes[i].length == 2
1 <= passi <= totali <= 105
1 <= extraStudents <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-average-pass-ratio
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路:
最大化平均通过率，也就是最大化通过率之和。

如果把超级学生加到一个通过率为100%的班级，通过率不变,这种班级应该在优先队列的最后面；
如果把超级学生加到一个总人数为n的班级，不论原来通过率是多少（不为100%），通过率的增加为： 
(1+p)/(n+1)-p/n=((1+p)*n-p*(n+1))/(n+1)*n=(n+n*p-n*p-p)/(n+1)*n=(n-p)/(n+1)*n
可见n相等的时候，p越小增加的越多；
p相等的时候，n越大，增加的越少。

根据n、p的值，把每个班级放进优先队列。针对每一个超级学生，从优先队列中取第一个班级、把超级学生放进去，然后再放进优先队列。
超级学生全部放进去后，遍历队列，计算每个班级的通过率，得到res。
*/

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
	PriorityQueue<int[]> pq=new PriorityQueue<>((c1,c2)->{
		if(c1[0]==c1[1]){
			return 
		}else if(c2[0]==c2[1]){

		}else if(c1[0]==c2[0]){
			return Integer.compare(c1[1],c2[1]);
		}else{
			
		}
	});
    }
}
