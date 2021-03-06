package leetCode;
/*
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|

Follow up:
Could you do better than O(n2) per move() operation?
 */
public class _348_TicTacToe {
	int[] p1Rows;
	int[] p2Rows;
	int[] p1Cols;
	int[] p2Cols;
	int p1lr;
	int p1rl;
	int p2lr;
	int p2rl;
	int n;
	public _348_TicTacToe(int n) {
		this.n=n;
		p1Rows=new int[n];
		p1Cols=new int[n];
		p2Rows=new int[n];
		p2Cols=new int[n];
		p1lr=0;
		p1rl=0;
		p2lr=0;
		p2rl=0;
	}
	
	public int move(int row, int col, int player) {
		if(player==1) {
			p1Rows[row]++;
			p1Cols[col]++;
			if(row==col) {
				p1lr++;
			}
			if(row==n-1-col) {
				p1rl++;
			}
		}else {
			p2Rows[row]++;
			p2Cols[col]++;
			if(row==col) {
				p2lr++;
			}
			if(row==n-1-col) {
				p2rl++;
			}
		}
		
		if(p1Rows[row]==n||p1Cols[col]==n||p1lr==n||p1rl==n) {
			return 1;
		}
		if(p2Rows[row]==n||p2Cols[col]==n||p2lr==n||p2rl==n) {
			return 2;
		}
		
		return 0;
	}
}
class TicTacToe_internet {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }

        if (col + row == cols.length - 1) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size) {
            return player;
        }

        return 0;
    }
}