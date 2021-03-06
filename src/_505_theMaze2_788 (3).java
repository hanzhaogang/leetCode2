package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There is a ball in a maze with empty spaces and walls. 
 * The ball can go through empty spaces by rolling up, down, left or right, 
 * but it won't stop rolling until hitting a wall. 
 * When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, 
find the shortest distance for the ball to stop at the destination. 
The distance is defined by 
the number of empty spaces traveled by the ball 
from the start position (excluded) to the destination (included). 
If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 
1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.

1.There is only one ball and one destination in the maze.
2.Both the ball and the destination exist on an empty space, 
and they will not be at the same position initially.
3.The given maze does not contain border 
(like the red rectangle in the example pictures), 
but you could assume the border of the maze are all walls.
4.The maze contains at least 2 empty spaces, 
and both the width and height of the maze won't exceed 100.

Example 1:
	Input:  
	(rowStart, colStart) = (0,4)
	(rowDest, colDest)= (4,4)
	0 0 1 0 0
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 0

	Output:  12
	
	Explanation:
	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)

Example 2:
	Input:
	(rowStart, colStart) = (0,4)
	(rowDest, colDest)= (0,0)
	0 0 1 0 0
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 0

	Output:  6
	
	Explanation:
	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
 */
public class _505_theMaze2_788 {
	public static void main(String[] args) {
		_505_theMaze2_788 s=new _505_theMaze2_788();
		int[][] maze=new int[][] {{0,0,1,0,0},
			                      {0,0,0,0,0},
			                      {0,0,0,1,0},
			                      {1,1,0,1,1},
			                      {0,0,0,0,0}};
	    int[] start=new int[] {0,4};
	    int[] destination=new int[] {0,0};
		System.out.println(s.shortestDistance(maze, start, destination));
	}
	int distance=Integer.MAX_VALUE;
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		boolean [][] visited=new boolean[maze.length][maze[0].length];
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {start[0],start[1],0});
		visited[start[0]][start[1]]=true;
		int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				int[] curLoc=q.poll();
				for(int[] dir:dirs) {
					int rollDestX=curLoc[0]+dir[0];
					int rollDestY=curLoc[1]+dir[1];
					int curDistance=curLoc[2];
					curDistance++;
					while(0<=rollDestX&&rollDestX<maze.length&&
							0<=rollDestY&&rollDestY<maze[0].length&&
							maze[rollDestX][rollDestY]!=1) {
						rollDestX+=dir[0];
						rollDestY+=dir[1];
						curDistance++;
					}
					rollDestX-=dir[0];
					rollDestY-=dir[1];
					curDistance--;
					if(rollDestX==destination[0]&&rollDestY==destination[1]) {
						distance=curDistance<distance?curDistance:distance;
					}
					
					if(!visited[rollDestX][rollDestY]) {
						q.offer(new int[] {rollDestX,rollDestY,curDistance});
						visited[rollDestX][rollDestY]=true;
					}
				}
			}
		}
		return distance==Integer.MAX_VALUE?-1:distance;
    }
}
