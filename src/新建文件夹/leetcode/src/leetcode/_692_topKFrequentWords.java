package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.

Follow up:

    Try to solve it in O(n log k) time and O(n) extra space.
 */
public class _692_topKFrequentWords {
	public static void main(String[] args) {
		_692_topKFrequentWords s=new _692_topKFrequentWords();
		String[] words= {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
		int k=14;		
		s.topKFrequent(words, k);
	}
	public List<String> topKFrequent(String[] words, int k) {
		Map<String,Integer> wordFres=new HashMap<>();
		for(String word:words) {
			if(wordFres.containsKey(word)) {
				wordFres.put(word, wordFres.get(word)+1);
			}else {
				wordFres.put(word, 1);
			}
		}
		
		System.out.println(wordFres);
		Integer i1=137;
		Integer i2=137;
		System.out.println(i1==i2);
		
		Integer i11=37;
		Integer i21=37;
		System.out.println(i11==i21);
		
		PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)->(a.getValue()==b.getValue())?//why == works here?
                b.getKey().compareTo(a.getKey())://string compareTo
                Integer.compare(a.getValue(),b.getValue()));
		
		for(Map.Entry<String, Integer> e:wordFres.entrySet()) {
			if(pq.size()<k) {
				pq.offer(e);
			}else if(pq.size()==k) {
				pq.offer(e);
				pq.poll();
			}
		}
		
		List<String> res=new ArrayList<>();
		for(Map.Entry<String, Integer> e:pq) {
			res.add(0,e.getKey());
		}
		return res;
    }
}
