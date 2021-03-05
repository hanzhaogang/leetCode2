package fb2020;
/*
 * Design a data structure that 
 * supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) 
    Adds word to the data structure, it can be matched later.
    bool search(word) 
    Returns true if there is any string in the data structure that matches word or false otherwise. 
    word may contain dots '.' where dots can be matched with any letter.

 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

 

Constraints:

    1 <= word.length <= 500
    word in addWord consists lower-case English letters.
    word in search consist of  '.' or lower-case English letters.
    At most 50000 calls will be made to addWord and search.
 */
public class _211_DesignAddandSearchWordsDataStructure {
	TrieTreeNode root;
	
    /** Initialize your data structure here. */
    public WordDictionary() {
    	root=new TrieTreeNode('0');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieTreeNode p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			p.children[c-'a']=new TrieTreeNode(c);
    		}
    		p=p.children[c-'a'];
    		if(i==word.length()-1) {
    			p.isWord=true;
    		}
    	}
    }
    
    /** Returns if the word is in the data structure. 
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word,root);
    }
    
    private boolean search(String word,TrieTreeNode p) {
    	if(word.length()==0) {
    		return p.isWord;
    	}
    	
    	char c=word.charAt(0);
    	if(c=='.') {
    		boolean res=false;
    		for(TrieTreeNode node:p.children) {
    			if(node!=null&&search(word.substring(1),node)) {
    				res=true;
    				return res;
    			}
    		}
    		return false;
    	}else {
    		if(p.children[c-'a']==null) {
        		return false;
        	}else {
        		return search(word.substring(1),p.children[c-'a']);
        	}
    	}
    }
}

class TrieTreeNode{
	boolean isWord;
	char c;
	TrieTreeNode[] children=new TrieTreeNode[26];
	
	public TrieTreeNode(char c) {
		this.c=c;
	}
}
