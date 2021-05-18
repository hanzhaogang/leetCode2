/*
1. 对每一个查询，一个一个计算。
*/


class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            for(int[] point:points){
                if( (query[0]-point[0])*(query[0]-point[0])+
                    (query[1]-point[1])*(query[1]-point[1])<=query[2]*query[2]){
                        res[i]++;
                }
            }
        }

        return res;
    }
}

/*
You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



Constraints:

1 <= points.length <= 500
points[i].length == 2
0 <= x​​​​​​i, y​​​​​​i <= 500
1 <= queries.length <= 500
queries[j].length == 3
0 <= xj, yj <= 500
1 <= rj <= 500
All coordinates are integers.
 

Follow up: Could you find the answer for each query in better complexity than O(n)?


For a point to be inside a circle, 
the euclidean distance between it and the circle's center 
needs to be less than or equal to the radius.


Brute force for each circle and iterate overall points and find those inside it.
*/

