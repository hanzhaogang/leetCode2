package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Design a search autocomplete system for a search engine. 
 * Users may input a sentence 
 * (at least one word and end with a special character '#'). 
 * For each character they type except '#', 
 * you need to return the top 3historical hot sentences 
 * that have prefix the same as the part of sentence already typed. 
 * Here are the specific rules:

    The hot degree for a sentence is defined as 
    the number of times a user typed the exactly same sentence before.
    
    The returned top 3 hot sentences should be sorted by hot degree 
    (The first is the hottest one). 
    If several sentences have the same degree of hot, 
    you need to use ASCII-code order (smaller one appears first).
    
    If less than 3 hot sentences exist, then just return as many as you can.
    When the input is a special character, it means the sentence ends, 
    and in this case, you need to return an empty list.

Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): 
This is the constructor. 
The input is historical data. 

Sentences is a string array consists of previously typed sentences. 
Times is the corresponding times a sentence has been typed. 
Your system should record these historical data.

Now, the user wants to input a new sentence. 
The following function will provide the next character the user types:

List<String> input(char c): 
The input c is the next character typed by the user. 
The character will only be lower-case letters ('a' to 'z'), 
blank space (' ') or a special character ('#'). 

Also, the previously typed sentence should be recorded in your system. 
The output will be the top 3 historical hot sentences 
that have prefix the same as the part of sentence already typed.

 

Example:
Operation: 
AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], 
[5,3,2,2]) 

The system have already tracked down the following sentences and 
their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 

Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 

Explanation: 
There are four sentences that have prefix "i". 
Among them, "ironman" and "i love leetcode" have same hot degree. 
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, 
"i love leetcode" should be in front of "ironman". 
Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 


Operation: input(' ') 
Output: ["i love you","i love leetcode"] 

Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 

Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, 
the sentence "i a" should be saved as a historical sentence in system. 
And the following input will be counted as a new search. 

 

Note:

1. The input sentence will always start with a letter and end with '#', 
and only one blank space will exist between two words.
2. The number of complete sentences that to be searched won't exceed 100. 
The length of each sentence including those in the historical data 
won't exceed 100.
3. Please use double-quote instead of single-quote 
when you write test cases even for a character input.
4. Please remember to RESET your class variables declared in 
class AutocompleteSystem, 
as static/class variables are persisted across multiple test cases. 
Please see [here](https://leetcode.com/faq/#different-output) for more details.

 
 */
public class _642_SearchAutocompleteSystem {	
	TrieTree642 tree=new TrieTree642();
	Node642 p=tree.root;
	List<Character> newSentence=new ArrayList<>();
	
	public _642_SearchAutocompleteSystem(String[] sentences,int[] counts) {
		tree.build(sentences,counts);
	}
	
	public List<String> input(char c){
		List<String> top3Sentences=new ArrayList<>();
		if(c=='#') {
			p=tree.root;
			return top3Sentences;
		}else {
			int index=c==' '?26:c-'a';
			if(p.children[index]==null) {
				return top3Sentences;
			}else {
				PriorityQueue<Pair642> pq=p.children[index].pq;
				p=p.children[index];
				for(int i=0;i<3;i++) {
					if(!pq.isEmpty()) {
						top3Sentences.add(pq.poll().sentence);
					}
				}
				return top3Sentences;
			}
		}
	}
}
class TrieTree642{
	Node642 root=new Node642();
	
	public void build(String[] sentences,int[] counts){
		for(int i=0;i<sentences.length;i++) {
			String sentence=sentences[i];
			int count=counts[i];
			Node642 p=root;
			
			for(int j=0;j<sentence.length();j++) {
				char c=sentence.charAt(j);
				int index=c==' '?26:c-'a';
				if(p.children[index]==null) {
					p.children[index]=new Node642();
				}
				p.children[index].pq.add(new Pair642(sentence,count));
				p=p.children[index];
			}
		}
	}
}
class Node642{
	char c;
	PriorityQueue<Pair642> pq=new PriorityQueue<>((p1,p2)->{
		if(p1.count!=p2.count) {
			return p2.count.compareTo(p1.count);
		}else {
			return p1.sentence.compareTo(p2.sentence);
		}
	});
	Node642[] children=new Node642[27];
}
class Pair642{
	String sentence;
	Integer count;
	
	public Pair642(String sentence,int count) {
		this.sentence=sentence;
		this.count=count;
	}
}

/*
 * 看到单词匹配，首先想到的就是Tier字典树，
 * Node里面多存一个Map<String, Integer> counts用来记录frequency。
 * 
 * 每次input操作，都让Tier Tree在当前节点的孩子中找，找到了就令curr = next，找不到就返回空值，说明没有历史记录的匹配。
 * 最后在curr.counts的map中找到包含当前字符串的搜索历史，和其frequency一起组成Pair存入PriorityQueue，再对PriorityQueue进行多条件的排序，
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
取出Top3即可。
*/
/*public class AutocompleteSystem {
	class TrieNode {
		Map<Character, TrieNode> children;
		Map<String, Integer> counts;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			counts = new HashMap<String, Integer>();
		}
	}

	class Pair {
		String s;
		int c;

		public Pair(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}

	TrieNode root;
	String prefix;

	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		prefix = "";

		for (int i = 0; i < sentences.length; i++) {
			add(sentences[i], times[i]);
		}
	}

	private void add(String s, int count) {
		TrieNode curr = root;
		for (char c : s.toCharArray()) {
			TrieNode next = curr.children.get(c);
			if (next == null) {
				next = new TrieNode();
				curr.children.put(c, next);
			}
			curr = next;
			curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
		}
	}

	public List<String> input(char c) {
		if (c == '#') {
			add(prefix, 1);
			prefix = "";
			return new ArrayList<String>();
		}

		prefix = prefix + c;
		TrieNode curr = root;
		for (char cc : prefix.toCharArray()) {
			TrieNode next = curr.children.get(cc);
			if (next == null) {
				return new ArrayList<String>();
			}
			curr = next;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
		for (String s : curr.counts.keySet()) {
			pq.add(new Pair(s, curr.counts.get(s)));
		}

		List<String> res = new ArrayList<String>();
		for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
			res.add(pq.poll().s);
		}
		return res;
	}
}*/
