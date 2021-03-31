package leetCode;

public class _208_implementTrieTree {
	Node_208 root;
	
	/** Initialize your data structure here. */
	public _208_implementTrieTree() {
        root=new Node_208();
        root.isWord=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Node_208 p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			Node_208 node=new Node_208();
    			node.c=c;
    			p.children[c-'a']=node;
    			p=p.children[c-'a'];
    		}else {
    			p=p.children[c-'a'];
    		}
    	}
    	
    	p.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Node_208 p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			return false;
    		}else {
    			p=p.children[c-'a'];
    		}
    	}
    	
    	return p.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node_208 p=root;
    	for(int i=0;i<prefix.length();i++) {
    		char c=prefix.charAt(i);
    		if(p.children[c-'a']==null) {
    			return false;
    		}else {
    			p=p.children[c-'a'];
    		}
    	}
    	
    	if(p.isWord)
    		return true;
    	for(Node_208 child:p.children) {
    		if(child!=null)
    			return true;
    	}
    	return false;
    }
}

class Node_208{
	char c;
	boolean isWord;
	Node_208[] children=new Node_208[26];
}