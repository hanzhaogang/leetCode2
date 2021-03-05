package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement the StreamChecker class as follows:

    StreamChecker(words): 
    Constructor, init the data structure with the given words.
    query(letter): 
    returns true if and only if for some k >= 1, 
    the last k characters queried 
    (in order from oldest to newest, including this letter just queried) 
    spell one of the words in the given list.

 



 

Note:

    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.
    
    
    1. Does not work.
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
	
	
	TrieTree tree;
	public _1032_StreamOfCharacters(String[] words) {
		tree=new TrieTree();
		
    	for(String word:words) {
    		tree.add(word);
    	}
//    	startNodes.add(root);
    }
    
	List<Character> stream=new ArrayList<>();
    public boolean query(char letter) {
    	stream.add(letter);
    	
    	
    }
//    public boolean query(char letter) {
//    	boolean res=false;
//    	List<Node1032> startNodeList=new ArrayList<>(startNodes);
//    	for(Node1032 startNode:startNodeList) {
//   			if(startNode.children[letter-'a']!=null&&
//   					startNode.children[letter-'a'].isWord) { 
//   				startNodes.remove(startNode);
//   				startNodes.add(startNode.children[letter-'a']);
//   				return true;
//   			}
//   			
//    		if(startNode.children[letter-'a']!=null) {
//   				startNodes.remove(startNode);
//    			startNodes.add(startNode.children[letter-'a']);
//    		}else {
//    			startNodes.remove(startNode);
//    		}
//    		
//    		startNodes.add(root);
//    	}
//    	return res;
//    }
}

class Node1032{
	char c;
	boolean isWord;
	Node1032[] children=new Node1032[26];
	public Node1032(char c) {
		this.c=c;
	}
}

class TrieTree{
	Node1032 root;
	
	public TrieTree() {
		root=new Node1032('A');
	}

//	Set<Node1032> startNodes=new HashSet<>();
	public void add(String word) {
		String reversed=new StringBuilder(word).reverse().toString();
    	Node1032 p=root;
    	for(int i=0;i<reversed.length();i++) {
    		char c=reversed.charAt(i);
    		if(p.children[c-'a']==null) {
    			p.children[c-'a']=new Node1032(c);
    		}
    		p=p.children[c-'a'];
    	}
    	p.isWord=true;
	}
	
	public boolean search(String word) {
		Node1032 p=root;
		for(int i=0;i<word.length();i++) {
			char c=word.charAt(i);
			if(p.children[c-'a']==null) {
				return false;
			}
			p=p.children[c-'a'];
			
		}
	}
}


/*
 * Copyright (c) 2021
 * Author: xiaoweixiang
 */
// Example:

// StreamChecker streamChecker = 
// new StreamChecker(["cd","f","kl"]); // init the dictionary.

// streamChecker.query('a');          // return false
// streamChecker.query('b');          // return false
// streamChecker.query('c');          // return false
// streamChecker.query('d');          // return true, because 'cd' is in the wordlist
// streamChecker.query('e');          // return false
// streamChecker.query('f');          // return true, because 'f' is in the wordlist
// streamChecker.query('g');          // return false
// streamChecker.query('h');          // return false
// streamChecker.query('i');          // return false
// streamChecker.query('j');          // return false
// streamChecker.query('k');          // return false
// streamChecker.query('l');          // return true, because 'kl' is in the wordlist
// public class StreamChecker {
//     StringBuilder stringBuilder = new StringBuilder();//存储stream
//     private TrieNode root;
//     int maxLength=0;//2

//     public StreamChecker(String[] words) {
//         /**
//          * 倒序插入
//          */
//         root = new TrieNode();
//         for (String word : words) {
//             maxLength=Math.max(maxLength,word.length());//word的最大长度
//             insert(new StringBuilder(word).reverse().toString());
//         }
//     }
/*            A
        d    f    l
      c             k

*/

//     public boolean query(char letter) {
//         stringBuilder.insert(0, letter);//a;ba;cba;dcba
//         if (stringBuilder.length()>maxLength) stringBuilder.deleteCharAt(stringBuilder.length()-1);
//         TrieNode temp=root;
//         for (int i = 0; i < stringBuilder.length(); i++) {
//             if (temp.next[stringBuilder.charAt(i)-'a']==null) return false;
//             temp=temp.next[stringBuilder.charAt(i)-'a'];
//             if(temp.isLeaf) return true;
//         }
//         return temp.isLeaf;
//     }

//     public void insert(String word) {//trie tree的插入操作
//         if (word == null || word.length() == 0) return;
//         TrieNode node = root;
//         int len = word.length();
//         for (int i = 0; i < len; i++) {
//             char c = word.charAt(i);
//             TrieNode tmp = node.next[c - 'a'];
//             if (tmp == null) {
//                 tmp = new TrieNode();
//                 node.next[c - 'a'] = tmp;
//             }
//             node = node.next[c - 'a'];
//         }
//         node.isLeaf = true;
//     }
//     public class TrieNode {
//         boolean isLeaf;
//         TrieNode[] next;

//         public TrieNode() {
//             next = new TrieNode[26];
//         }
//     }
// }

// 作者：xiaoweixiang
// 链接：https://leetcode-cn.com/problems/stream-of-characters/solution/bu-nan-biao-zhun-mo-ban-de-shao-wei-gai-iu3rt/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//1）从words中提取word，将word反向，建立后缀树。
// 2）在查询的时候，我们将每个字符保存在一个字符串中，每次每个字符都插入到该字符串的首部。然后我们直接在后缀树中查找该字符串的最短前缀能否表示成一个字符串就行了。

// 作者：xiaoneng
// 链接：https://leetcode-cn.com/problems/stream-of-characters/solution/hen-jian-dan-de-qian-zhui-shu-ban-zi-by-xiaoneng/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 


// 题目要求按从旧到新顺序查询，因此可以将从旧到新的 query 存起来形成一个单词 stream。

// 比如：


// streamChecker.query("a"); // stream： a
// streamChecker.query("b"); // stream：ba
// streamChecker.query("c"); // stream：cba
// 这里有两个小的点需要注意：

// 如果用数组来存储， 由于每次都往数组头部插入一个元素，因此每次 query 操作的时间复杂度为 O(N)，其中 N 为截止当前执行 query 的次数，我们可以使用双端队列进行优化。
// 由于不必 query 形成的查询全部命中。比如 stream 为 cba 的时候，找到单词 c， bc， abc 都是可以的。
// 如果是找到 c，cb，cba 比较好吧，现在是反的。
// 其实我们可以反序插入是，类似的技巧在211.add-and-search-word-data-structure-design 也有用到。
// 之后我们用拼接的单词在 words 中查询即可， 最简单的方式当然是每次 query 都去扫描一次，这种方式毫无疑问会超时。

// 我们可以采用构建 Trie 的形式，即已空间环时间， 其代码和常规的 Trie 类似，
// 只需要将 search(word) 函数做一个简单修改即可，我们不需要检查整个 word 是否存在， 而已 word 的前缀存在即可。

// 提示：可以通过对 words 去重，来用空间换区时间。

// 具体算法：

// init 中 构建 Trie 和 双端队列 stream
// query 时，往 stream 的左边 append 即可。
// 调用 Trie 的 search（和常规的 search 稍有不同， 我上面已经讲了）

// 作者：fe-lucifer
// 链接：https://leetcode-cn.com/problems/stream-of-characters/solution/tong-su-yi-dong-trie1032-zi-fu-liu-by-fe-lucifer/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class StreamChecker {
	TrieTree tree;
	int maxWordLen=0;
	StringBuilder sb=new StringBuilder();

    public StreamChecker(String[] words) {
		tree=new TrieTree();
		for(String word:words){
			tree.insert(new StringBuilder(word).reverse().toString());
			if(maxWordLen<word.length()){
				maxWordLen=word.length();
			}
		}
    }
    
    public boolean query(char letter) {
		sb.insert(0, letter);
		if(maxWordLen<sb.length()){
			sb.deleteCharAt(sb.length()-1);
		}
		//f e
		TrieTreeNode p=tree.root;
    	for(int i=0;i<sb.length();i++) {
    		char c=sb.charAt(i);
    		if(p.children[c-'a']==null) {
    			return false;
    		}else {
    			p=p.children[c-'a'];
				if(p.isWord)
					return true;
    		}
    	}
    	
    	return false;
    }
}
class TrieTree {
	TrieTreeNode root;
	
	/** Initialize your data structure here. */
	public TrieTree() {
        root=new TrieTreeNode();
        root.isWord=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieTreeNode p=root;
    	for(int i=0;i<word.length();i++) {
    		char c=word.charAt(i);
    		if(p.children[c-'a']==null) {
    			TrieTreeNode node=new TrieTreeNode();
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
    	TrieTreeNode p=root;
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
    	TrieTreeNode p=root;
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
    	for(TrieTreeNode child:p.children) {
    		if(child!=null)
    			return true;
    	}
    	return false;
    }
}

class TrieTreeNode{
	char c;
	boolean isWord;
	TrieTreeNode[] children=new TrieTreeNode[26];
}