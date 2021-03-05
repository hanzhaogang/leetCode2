package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, 
but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, 
determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 
1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.
Example

Example 1:

Input:
map = 
[
 [0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]
]
start = [0,4]
end = [3,2]
Output:
false

Example 2:

Input:
map = 
[[0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]
]
start = [0,4]
end = [4,4]
Output:
true

Notice

1.There is only one ball and one destination in the maze.
2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
5.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 
 */
public class _490_theMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[maze.length][maze[0].length];//missing dimension
        q.offer(start);
        visited[start[0]][start[1]]=true;//==?
        
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};//up down left right
        while(q.size()!=0){
        	int size=q.size();
        	for(int k=0;k<size;k++) {
        		int[] loc=q.poll();
        		//visited.add(loc);
                int i=loc[0];
                int j=loc[1];
                
                for(int[] dir:dirs){
                    while(i+dir[0]<maze.length&&0<=i+dir[0]&&
                            j+dir[1]<maze[0].length&&0<=j+dir[1]&&
                            maze[i+dir[0]][j+dir[1]]==0){
                        i=i+dir[0];
                        j=j+dir[1];
                    }
                    int[] temp={i,j};
                    if(Arrays.equals(temp,destination))//wrote target here
                        return true;
                    if(!visited[temp[0]][temp[1]]){
                        visited[i][j]=true;
                        q.offer(temp);
                    }
                    i=loc[0];
                    j=loc[1];
                }
                
            }
        }
        return false;
    }
}
