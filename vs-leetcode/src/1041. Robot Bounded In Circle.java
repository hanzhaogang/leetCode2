public class 1041. Robot Bounded In Circle {
	
}
/* On an infinite plane, 
a robot initially stands at (0, 0) and faces north. 
The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane 
such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, 
the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/robot-bounded-in-circle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：

模拟法：按照指令一直走，同时记录已经走过的路径 
注意，bouned并不等价于最终走进一个circle。
但是走过的路径会重复。

看数据规模，o（n^3）可以通过。
模拟法中，针对每一步的指令，需要判定是不是已经存在重复路径。
判定方法：首先确定所在位置之前有没有出现过；
如果出现过，一次排查后面的每一步，
*/
class Solution {
    public boolean isRobotBounded(String instructions) {

    }
}