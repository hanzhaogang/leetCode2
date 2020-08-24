package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a list of unique words, 
 * find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] 
 * is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

1. BF O(n^2*k)
2 Robin-Karp O(n*k) X

"a" ""

lllt,ttlll, a,ba, cdd,c
 */
public class _336_PalindromePair {
	public static void main(String[] args) {
		_336_PalindromePair s=new _336_PalindromePair();
//		String[] words=new String[] {"","a"};
		String[] words=new String[] {"abcd","dcba","lls","s","sssll"};
		System.out.println(s.palindromePairs(words));
	}
	public List<List<Integer>> palindromePairs_bf(String[] words) {
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<words.length;i++) {
			for(int j=0;j<words.length;j++) {
				if(i==j)
					continue;
				String comb=words[i]+words[j];
				if(isPalin(comb)) {
					res.add(Arrays.asList(i,j));
				}
			}
		}
		return res;
    }
	
	public List<List<Integer>> palindromePairs_wrong(String[] words) {
		Map<String,Integer> word2index=new HashMap<>();
		for(int i=0;i<words.length;i++) {
			word2index.put(words[i], i);
		}
		Arrays.sort(words,(w1,w2)->{
			return w1.length()-w2.length();
		});
		Map<Integer,Integer> new2old=new HashMap<>();
		for(int i=0;i<words.length;i++) {
			new2old.put(i, word2index.get(words[i]));
		}
		
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<words.length;i++) {
			String curWord=words[i];
			StringBuilder surfix_r=new StringBuilder("");
			StringBuilder prefix_r=new StringBuilder(curWord).reverse();
			for(int j=curWord.length()-1;0<=j;j--) {
				
				if(word2index.containsKey(surfix_r.toString())&&
						isPalin(prefix_r.toString())) {
					int indexSur=word2index.get(surfix_r.toString());
					res.add(Arrays.asList(i,new2old.get(indexSur)));
				}
				if(word2index.containsKey(prefix_r.toString())&&
						isPalin(surfix_r.toString())) {
					int indexPre=word2index.get(prefix_r.toString());
					res.add(Arrays.asList(new2old.get(indexPre),i));
				}

                surfix_r.append(curWord.charAt(j));
				prefix_r.deleteCharAt(prefix_r.length()-1);
			}

            word2index.put(curWord, i);
		}
		
		return res;
    }
	//"","a"
	public List<List<Integer>> palindromePairs(String[] words) {//s,lls//ab,bba;ab,baa
		Map<String,Integer> word2index=new HashMap<>();
		Set<List<Integer>> res=new HashSet<>();
		for(int i=0;i<words.length;i++) {//ab,ba
			word2index.put(words[i], i);
		}
		for(int i=0;i<words.length;i++) {//abcd,dcba;"",a
			String curWord=words[i];//lls
			StringBuilder prefix=new StringBuilder("");//sll
			StringBuilder surfix=new StringBuilder(curWord);//""
			for(int j=0;j<=curWord.length();j++) {
				StringBuilder sb1=new StringBuilder(surfix).reverse();
				if(word2index.containsKey(sb1.toString())&&
						isPalin(prefix.toString())) {
					int indexSur=word2index.get(sb1.toString());
					if(indexSur!=i)
						res.add(Arrays.asList(indexSur,i));
				}
				StringBuilder sb2=new StringBuilder(prefix).reverse();
				if(word2index.containsKey(sb2.toString())&&
						isPalin(surfix.toString())) {
					int indexPre=word2index.get(sb2.toString());
					if(indexPre!=i)
						res.add(Arrays.asList(i,indexPre));
				}
				if(j<curWord.length())
						prefix.append(curWord.charAt(j));//sl
				if(0<surfix.length())
					surfix.deleteCharAt(0);//s
			}
		}
		
		return new ArrayList<List<Integer>>(res);
    }
	private boolean isPalin(String str) {
		if(str.length()<=1)
			return true;
		
		int lo=0;
		int hi=str.length()-1;
		while(lo<hi) {
			if(str.charAt(lo++)!=str.charAt(hi--)) {
				return false;
			}
		}
		
		return true;
	}
}


//class Solution {
//
//    private List<String> allValidPrefixes(String word) {
//        List<String> validPrefixes = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            if (isPalindromeBetween(word, i, word.length() - 1)) {
//                validPrefixes.add(word.substring(0, i));
//            }
//        }
//        return validPrefixes;
//    }
//
//    private List<String> allValidSuffixes(String word) {
//        List<String> validSuffixes = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            if (isPalindromeBetween(word, 0, i)) {
//                validSuffixes.add(word.substring(i + 1, word.length()));
//            }
//        }
//        return validSuffixes;
//    }
//
//    // Is the prefix ending at i a palindrome?
//    private boolean isPalindromeBetween(String word, int front, int back) {
//        while (front < back) {
//            if (word.charAt(front) != word.charAt(back)) return false;
//            front++;
//            back--;
//        }
//        return true;
//    }
//
//    public List<List<Integer>> palindromePairs(String[] words) {
//        // Build a word -> original index mapping for efficient lookup.
//        Map<String, Integer> wordSet = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            wordSet.put(words[i], i);
//        }
//
//        // Make a list to put all the palindrome pairs we find in.
//        List<List<Integer>> solution = new ArrayList<>();
//
//        for (String word : wordSet.keySet()) {
//
//            int currentWordIndex = wordSet.get(word);
//            String reversedWord = new StringBuilder(word).reverse().toString();
//
//            // Build solutions of case #1. This word will be word 1.
//            if (wordSet.containsKey(reversedWord)
//              && wordSet.get(reversedWord) != currentWordIndex) {
//                solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedWord)));
//            }
//
//            // Build solutions of case #2. This word will be word 2.
//            for (String suffix : allValidSuffixes(word)) {
//                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
//                if (wordSet.containsKey(reversedSuffix)) {
//                    solution.add(Arrays.asList(wordSet.get(reversedSuffix), currentWordIndex));
//                }
//            }
//
//            // Build solutions of case #3. This word will be word 1.
//            for (String prefix : allValidPrefixes(word)) {
//                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
//                if (wordSet.containsKey(reversedPrefix)) {
//                    solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedPrefix)));
//                }
//            }
//        }
//        return solution;
//    }
//}
