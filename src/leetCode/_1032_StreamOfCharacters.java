package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Implement the StreamChecker class as follows:

    StreamChecker(words): 
    Constructor, init the data structure with the given words.
    query(letter): 
    returns true if and only if for some k >= 1, 
    the last k characters queried 
    (in order from oldest to newest, including this letter just queried) 
    spell one of the words in the given list.

 

Example:

StreamChecker streamChecker = 
new StreamChecker(["cd","f","kl"]); // init the dictionary.

streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

 

Note:

    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.
    
    
    Put the words into a trie, 
    and manage a set of pointers within that trie.
    
    ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query"]
[[["ab","ba","aaab","abab","baa"]],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]
 */

public class _1032_StreamOfCharacters {
	public static void main(String[] args) {
		String[] words=new String[] {"cd","f","kl"};
		words=new String[] {"ab","ba","aaab","abab","baa"};
		String queryStr="aaaaabababbbababbbbababaaabaaa";
		_1032_StreamOfCharacters s=new _1032_StreamOfCharacters(words);
		
		for(int i=0;i<queryStr.length();i++){
			System.out.println(s.query(queryStr.charAt(i)));
		}
	}
	Node1032 root=new Node1032('A');
	Set<Node1032> startNodes=new HashSet<>();
	private void add(String word) {
    	Node1032 p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			p.children[c-'a']=new Node1032(c);
    		}
    		p=p.children[c-'a'];
    	}
    	p.isWord=true;
	}
	public _1032_StreamOfCharacters(String[] words) {
    	for(String word:words) {
    		add(word);
    	}
    	startNodes.add(root);
    }
    
    public boolean query(char letter) {
    	boolean res=false;
    	List<Node1032> list=new ArrayList<>(startNodes);
    	for(Node1032 startNode:list) {
   			if(startNode.children[letter-'a']!=null&&
   					startNode.children[letter-'a'].isWord) 
    			res=true;
   			if(!startNode.equals(root))
   				startNodes.remove(startNode);
    		if(startNode.children[letter-'a']!=null) {
    			startNodes.add(startNode.children[letter-'a']);
    		}
    	}
    	return res;
    }
}

class Node1032{
	char c;
	boolean isWord;
	Node1032[] children=new Node1032[26];
	public Node1032(char c) {
		this.c=c;
	}
}
[null,false,false,false,false,false,true,true,true,true,true,false,false,true,true,true,true,false,false,false,false,true,true,true,true,true,false,true,true,true,false]
[null,false,false,false,false,false,true,true,true,true,true,false,false,true,true,true,true,false,false,false,true,true,true,true,true,true,false,true,true,true,false]
		
["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query"]
				[[["ab","ba","aaab","abab","baa"]],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]
["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query"]
				[[["ab","ba","aaab","abab","baa"]],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]

