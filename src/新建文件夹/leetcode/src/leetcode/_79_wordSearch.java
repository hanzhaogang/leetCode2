package leetcode;
/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 

Constraints:

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3
    
    [["A","B","C","E"],
     ["S","F","E","S"],
     ["A","D","E","E"]]


 */
public class _79_wordSearch {
	public static void main(String[] args) {
		char[][] board=new char[][] {};
		
		String word="ABCESEEEFS";
		_79_wordSearch s=new _79_wordSearch();
		System.out.println(s.exist(board, word));
	}
   	boolean found;
   	boolean[][] visited;
    public boolean exist(char[][] board, String word) {
    	int m=board.length;
    	int n=board[0].length;
    	visited=new boolean[m][n];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(word.charAt(0)==board[i][j]) {
    				dfs(i,j,board,word,0);
    				if(found)
    					return true;
    			}
    		}
    	}
    	return found;
    }
    int[][] dirs=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(int x,int y,char[][] board,String word,int lo) {
    	if(lo==word.length()) {
    		found=true;
    		return;
    	}
    	
    	if(x<0||y<0||board.length<=x||board[0].length<=y||board[x][y]!=word.charAt(lo)||
    			visited[x][y])
    		return;
    	visited[x][y]=true;
    	for(int[] dir:dirs) {
    		if(!found)
    			dfs(x+dir[0],y+dir[1],board,word,lo+1);
    	}
    	visited[x][y]=false;
    }
}


class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))
                    if(dfsFrom(board,i,j,word,0,visited)) 
                        return true;
                    
            }
        }
        
        return false;
    }
    
    public boolean dfsFrom(char[][] board,int i,int j,String word,int k,int[][] visited){
        if(board.length<=i||board[0].length<=j||i<0||j<0||
                board[i][j]!=word.charAt(k)||visited[i][j]==1)
            return false;
        
        if(k==word.length()-1){
            if(visited[i][j]==0)
                return true;
            else
                return false;
        }
        visited[i][j]=1;
            
        boolean found=dfsFrom(board,i+1,j,word,k+1,visited)||
            dfsFrom(board,i-1,j,word,k+1,visited)||
            dfsFrom(board,i,j+1,word,k+1,visited)||
            dfsFrom(board,i,j-1,word,k+1,visited);
        
        visited[i][j]=0;
        return found;
    }
}
