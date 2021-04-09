
import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
一道典型的回溯问题。
首先写出回溯函数。

其次考虑如何在每一次递归中，确定可能的皇后的位置。
每次确定的时候，需要遍历每个方块（n^2），如果当前方块满足以下条件则跳过：
在同一行
在同一列
在同一对角线:i==j相等 || i==(n-j)

*/

public class _51_nQueen {
    public static void main(String[] args){
        Solution_51 s=new Solution_51();
        s.solveNQueens(3);
    }
}
class Solution_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        
        //initialize temp 
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        for(int i=0;i<n;i++){
            temp.add(sb.toString());
        }

        bt(res,temp,n,0,new int[n],new int[n],new int[2*n-1],new int[2*n-1]);
        return res;

    }

    /* k is the number has placed.
       matrix is n-sized. index is 0~n-1
    */
    private void bt(List<List<String>> res,List<String> temp,int n,int k,
                    int[] row,int[] col,int[] dia, int[] antiDia){
        
        if(k==n){
            System.out.println(k);
            List<String> solution=new ArrayList<>(temp);
            res.add(solution);
            // temp.clear();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!(row[i]==1 || col[j]==1 || dia[n-1-(i-j)]==1 || antiDia[i+j]==1)){
                    //find a grid(i,j) to place the (k+1)th queen
                    row[i]=1;
                    col[j]=1;
                    dia[n-1-(i-j)]=1;
                    dia[i+j]=1;
                    String str=temp.get(i);
                    temp.set(i,str.substring(0,j)+"Q"+str.substring(j+1));
                    System.out.println(k);
                    bt(res,temp,n,k+1,row,col,dia,antiDia);
                    temp.set(i,str);
                    row[i]=0;
                    col[j]=0;
                    dia[n-1-(i-j)]=0;
                    dia[i+j]=0;
                }
            }
        }

    }
} 