package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
public class _127_wordLadder {
	public int ladderLength(String beginWord, String endWord, 
							List<String> wordList) {
		Set<String> wordSet=new HashSet<>(wordList);
		
		Set<String> visited=new HashSet<>();
		
		int count=1;
		Queue<String> q=new LinkedList<>();
		q.add(beginWord);
		visited.add(beginWord);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				String w=q.poll();
				List<String> nbs=findAllNb(w);
				for(String nb:nbs) {
					if(wordSet.contains(nb)&&nb.equals(endWord))
						return count+1;
					if(wordSet.contains(nb)&&!visited.contains(nb)) {
						q.offer(nb);
						visited.add(nb);
					}
				}
			}
			count++;
		}
		
		return 0;
    }
	
	private List<String> findAllNb(String w){
		List<String> res=new ArrayList<>();
		for(int i=0;i<w.length();i++){
			for(char c='a';c<='z';c++) {
				String nb=w.substring(0,i)+c+w.substring(i+1);
				if(!nb.equals(w))
					res.add(nb);
			}
		}
		return res;
	}
}
/*
class Solution {
	  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	    // Since all words are of same length.
	    int L = beginWord.length();

	    // Dictionary to hold combination of words that can be formed,
	    // from any given word. By changing one letter at a time.
	    Map<String, List<String>> allComboDict = new HashMap<>();

	    wordList.forEach(
	        word -> {
	          for (int i = 0; i < L; i++) {
	            // Key is the generic word
	            // Value is a list of words which have the same intermediate generic word.
	            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
	            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
	            transformations.add(word);
	            allComboDict.put(newWord, transformations);
	          }
	        });

	    // Queue for BFS
	    Queue<Pair<String, Integer>> Q = new LinkedList<>();
	    Q.add(new Pair(beginWord, 1));

	    // Visited to make sure we don't repeat processing same word.
	    Map<String, Boolean> visited = new HashMap<>();
	    visited.put(beginWord, true);

	    while (!Q.isEmpty()) {
	      Pair<String, Integer> node = Q.remove();
	      String word = node.getKey();
	      int level = node.getValue();
	      for (int i = 0; i < L; i++) {

	        // Intermediate words for current word
	        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

	        // Next states are all the words which share the same intermediate state.
	        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
	          // If at any point if we find what we are looking for
	          // i.e. the end word - we can return with the answer.
	          if (adjacentWord.equals(endWord)) {
	            return level + 1;
	          }
	          // Otherwise, add it to the BFS Queue. Also mark it visited
	          if (!visited.containsKey(adjacentWord)) {
	            visited.put(adjacentWord, true);
	            Q.add(new Pair(adjacentWord, level + 1));
	          }
	        }
	      }
	    }

	    return 0;
	  }
	}
*/