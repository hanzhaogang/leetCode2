package leetCode;
/*
 * Given an 2D board, 
 * count how many battleships are in it. 
 * The battleships are represented with 'X's, 
 * empty slots are represented with '.'s. 
 * You may assume the following rules:

    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. 
    In other words, 
    they can only be made of the shape 1xN (1 row, N columns) 
    or Nx1 (N rows, 1 column), 
    where N can be of any size.
    At least one horizontal or vertical cell separates 
    between two battleships - 
    there are no adjacent battleships.

Example:

X..X
...X
...X

In the above board there are 2 battleships.

Invalid Example:

...X
XXXX
...X

This is an invalid board that you will not receive - 
as battleships will always have a cell separating between them.

Follow up:
Could you do it in one-pass, 
using only O(1) extra memory 
and without modifying the value of the board?
 */
public class _419_BattleshipsInAboard {
    public int countBattleships(char[][] board) {
    	//[["X","X","X"]]
    	int count=0;
    	int m=board.length;
    	int n=board[0].length;
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(board[i][j]=='X'&&
    					(i==0&&j==0 || 
    					 i==0&&board[i][j-1]=='.' ||
    					 0==j&&board[i-1][j]=='.' ||
    					 i!=0&&j!=0&&board[i-1][j]=='.'&&board[i][j-1]=='.')) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
}
