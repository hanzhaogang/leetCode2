package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return an empty list if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

                   hit
                hot 
                dot lot 
                dog log
                dot

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 
 *
 *"red"
"tax"
["ted","tex","red","tax","tad","den","rex","pee"]



[
["red","ted","tad","tax"],
["red","ted","tex","tax"]]

[
["red","ted","tad","tax"],
["red","ted","tex","tax"],
["red","rex","tex","tax"]]

 */
public class _126_wordLadder2 {
	public static void main(String[] args) {
//		String beginWord="hit";
//		String endWord="cog";
//		List<String> wordList=Arrays.asList("hot","dot","dog","lot","log","cog");
		String beginWord="red";
		String endWord="tax";
		List<String> wordList=Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
		_126_wordLadder2 s=new _126_wordLadder2();
		System.out.println(s.findLadders(beginWord,endWord,wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, 
										  List<String> wordList) {
		Set<String> wordSet=new HashSet<>(wordList);
		
		Set<String> visited=new HashSet<>();
		Queue<TreeNode126> q=new LinkedList<>();
		TreeNode126 root=new TreeNode126(beginWord);
		q.offer(root);
		visited.add(root.str);
		List<TreeNode126> endNodes=new ArrayList<>();
		boolean found=false;
		while(!q.isEmpty()) {
			int size=q.size();
			Set<String> lvVisited=new HashSet<>();
			for(int i=0;i<size;i++) {//hot; dot,lot
				TreeNode126 curNode=q.poll();
				List<String> nbs=findAllNb(curNode.str);
				for(String str:nbs) {
					if(wordSet.contains(str)&&
							!str.equals(beginWord)&&!visited.contains(str)) {
						//hit dot lot
						q.offer(new TreeNode126(str,curNode));
						lvVisited.add(str);//hot; dog,log
					}
					if(wordSet.contains(str)&&str.equals(endWord)) {
						endNodes.add(new TreeNode126(str,curNode));
						found=true;
					}
				}
			}
			visited.addAll(lvVisited);
			if(found) {
				break;
			}
		}
		
		List<List<String>> res=new ArrayList<>();
		for(TreeNode126 end:endNodes) {
			List<String> list=new ArrayList<>();
			while(end!=null) {
				list.add(0,end.str);
				end=end.pre;
			}
			res.add(list);
		}
		
		return res;
    }
	
	private List<String> findAllNb(String word){
		List<String> res=new ArrayList<>();
		for(int i=0;i<word.length();i++) {
			for(char c='a';c<='z';c++) {
				String nb=word.substring(0,i)+c+word.substring(i+1);
				if(!nb.equals(word))
					res.add(nb);
			}
		}
		
		return res;
	}
}

class TreeNode126{
	String str;
	TreeNode126 pre;
	
	public TreeNode126(String str) {
		this.str=str;
	}
	public TreeNode126(String str,TreeNode126 pre) {
		this.str=str;
		this.pre=pre;
	}
}