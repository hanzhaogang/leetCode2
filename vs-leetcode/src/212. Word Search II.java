import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 212. Word Search II {
	
}
/* Given an m x n board of characters and a list of strings words, 
return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], 
words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
首先看数据规模：word数30000，word长度小于10.这是一个典型的字典数据结构。可以考虑用字典树（前缀树）

除此之外，还可以把words数组按照字典序排序，然后从后往前遍历、判断。
如果当前word是前一个word的substring，那么可以直接返回true。

-----
暴力dfs加一个提前验证过程，直接可以时间击败98%。
即：如果word里面含有boards中不存在的字符，或者某种字符的数量比boards中该字符数量更多，
则根本不用进入dfs回溯，因为肯定无法形成该word。


---- 
数据范围只有 12，且 words 中出现的单词长度不会超过 10，可以考虑使用「回溯算法」。
30000*12*12*10^4

----
最外层循环，不是遍历words，而是遍历board中的每个格子。
针对每一个格子，做dfs，在dfs的每一步，检查当前路径是否是words中的某个word。
*/
class Solution {
	boolean found=false;
    public List<String> findWords(char[][] board, String[] words) {
	Arrays.sort(words,(String s1,String s2)->{
		return s1.compareTo(s2);
	});
	List<String> res=new ArrayList<>();
	boolean pre=false;
	for(int i=words.length-1;0<=i;i--){
		found=false;
		
		String word=words[i];
		if(pre&&word.length()<words[i+1].length()&&
				word.equals(words[i+1].substring(word.length()))){
			res.add(word);
		}else{
			
			for(int j=0;j<board.length;j++){
				for(int k=0;k<board[0].length;k++){
					
					if(!found&&board[j][k]==word.charAt(0)){
						boolean[][] visited=new boolean[board.length][board[0].length];
						dfs(word,0,board,j,k,visited);
					}
				}
			}
			if(found){
				pre=true;
				res.add(word);
			}
		}
	}
	return res;
    }

    int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private void dfs(String word,int i,char[][] board,int x,int y,boolean[][] visited){
	if(word.length()<=i||x<0||board.length<=x||y<0||board[0].length<=y||visited[x][y]||
			board[x][y]!=word.charAt(i)){
		return;
	}
	if(i==word.length()-1){
		found=true;
		return;
	}
	visited[x][y]=true;	
	for(int[] dir:dirs){
		dfs(word,i+1,board,x+dir[0],y+dir[1],visited);
	}
	visited[x][y]=false;
    }
}
