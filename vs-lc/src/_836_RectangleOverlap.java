/*
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], 
where (x1, y1) is the coordinate of its bottom-left corner, 
and (x2, y2) is the coordinate of its top-right corner. 
Its top and bottom edges are parallel to the X-axis, 
and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. 
To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, 
return true if they overlap, otherwise return false.

 

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false
 

Constraints:

rect1.length == 4
rect2.length == 4
-109 <= rec1[i], rec2[i] <= 109
rec1[0] <= rec1[2] and rec1[1] <= rec1[3]
rec2[0] <= rec2[2] and rec2[1] <= rec2[3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rectangle-overlap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：

rec1的x1-x2；y1-y2组成了一个区域。
rec2的四个顶点，必须至少有一个落在这个区域内。



注意：
初始化数组的时候，维度不用定义。

还需要注意的是一些corner case：
[7,8,13,15]
[10,8,12,20]

判断条件我在一开始的时候想错了。
应该是rec2的4条边，至少有一条边落在rec1上。

或者是：
rec1的x1-x2；y1-y2组成了一个区域。
rec2的四个顶点，必须至少有一个落在这个区域内。
||
rec2的x1-x2；y1-y2组成了一个区域。
rec1的四个顶点，必须至少有一个落在这个区域内。

-----------最终思路：降维
把二维的重叠问题，转化为一维的重叠问题。
如果二维上矩阵重叠，那么在x轴上线段重叠&&在y轴上线段重叠。

还要注意一种特殊情况，就是有矩阵退化为一条线段的情况。
*/

public class _836_RectangleOverlap {
    
}


class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] rec2Points=new int[][]{{rec2[0],rec2[1]}, {rec2[0],rec2[3]}, 
                                        {rec2[2],rec2[3]}, {rec2[2],rec2[1]}};
        for(int[] point:rec2Points){
            if(inRectangle(rec1,point)){
                return true;
            }
        }

        return false;
    }

    private boolean inRectangle(int[] rec,int[] point){
        return rec[0]<point[0]&& point[0]<rec[2]&&
                rec[1]<point[1]&& point[1]<rec[3];
    }
}

class Solution2 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] rec2Points=new int[][]{{rec2[0],rec2[1]}, {rec2[0],rec2[3]}, 
                                        {rec2[2],rec2[3]}, {rec2[2],rec2[1]}};
        for(int[] point:rec2Points){
            if(inRectangle(rec1,point)){
                return true;
            }
        }
        int[][] rec1Points=new int[][]{{rec1[0],rec1[1]}, {rec1[0],rec1[3]}, 
                                        {rec1[2],rec1[3]}, {rec1[2],rec1[1]}};
        for(int[] point:rec1Points){
            if(inRectangle(rec2,point)){
                return true;
            }
        }
        return false;
    }

    private boolean inRectangle(int[] rec,int[] point){
        return rec[0]<point[0]&& point[0]<rec[2]&&
                rec[1]<point[1]&& point[1]<rec[3];
    }
}
class Solution3 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0]==rec1[2] || rec1[1]==rec1[3] || rec2[0]==rec2[2] || rec2[1]==rec2[3]) &&
                (!(rec2[2]<=rec1[0]) && !( rec1[2]<=rec2[0])) //x overlap
                && ( !(rec2[3]<=rec1[1])&& !(rec1[3]<=rec2[1]));
    }    
}