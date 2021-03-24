/*
Given the coordinates of two rectilinear rectangles in a 2D plane, 
return the total area covered by the two rectangles.

The first rectangle is defined by its bottom-left corner (A, B) 
and its top-right corner (C, D).

The second rectangle is defined by its bottom-left corner (E, F) 
and its top-right corner (G, H).

 

Example 1:


Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Example 2:

Input: A = -2, B = -2, C = 2, D = 2, E = -2, F = -2, G = 2, H = 2
Output: 16
 

Constraints:

-104 <= A, B, C, D, E, F, G, H <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rectangle-area
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
分overlap和没有overlap两种。
如果没有重叠，直接返回两个矩形面积之和。
如果重叠（降维判断有没有重叠），返回面积之和-重叠部分的面积。

特殊情况： 矩阵有没有可能退化为一个线段*/

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(!(A==C || B==D || E==G || F==H) &&
                (!(G<=A) && !( C<=E)) //x overlap
                && ( !(H<=B)&& !(D<=F)))
            return (C-A)*(D-B)+(H-F)*(G-E)-(Math.min(G,C)-Math.max(E,A))*(Math.min(D,H)-Math.max(B,F));
        else
            return (C-A)*(D-B)+(H-F)*(G-E);
    }
}