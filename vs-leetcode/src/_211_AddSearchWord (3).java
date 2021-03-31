package leetCode;
/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or 
a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class _211_AddSearchWord {
	Node210 root;
    /** Initialize your data structure here. */
    public _211_AddSearchWord() {
    	root=new Node210();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	Node210 p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			Node210 node=new Node210();
    			node.c=c;
    			p.children[c-'a']=node;
    		}
    		p=p.children[c-'a'];
    	}
    	p.isWord=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word,root);
    }
    
    private boolean search(String word,Node210 root) {
    	if(word.length()==0) {
    		if(root.isWord) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    	
    	Node210 p=root;
    	char c=word.charAt(0);
    	if(c!='.') {
    		if(p.children[c-'a']==null) {
    			return false;
    		}else {
    			return search(word.substring(1),p.children[c-'a']);
    		}
    	}else {
    		for(Node210 child:p.children) {
    			if(child!=null&&search(word.substring(1),child)) {
    				return true;
    			}
    		}
    		return false;
    	}
    }
}

class Node210{
	char c;
	boolean isWord;
	Node210[] children=new Node210[26];
}