package fb2020;
import java.util.HashMap;
import java.util.Map;

/*
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
 * The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", 
because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

 

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.
    
    遍历words，依次判断是不是有序。定义一个单独的判断有序的函数。
    
    注意使用数组代替哈希表可以提高速度。
    
 */
public class _953_VerifyAllienDict {
    public boolean isAlienSorted(String[] words, String order) {
//    	Map<Character,Integer> char2index=new HashMap<>();
//    	char2index.put('#', -1);
//    	for(int i=0;i<order.length();i++) {
//    		char2index.put(order.charAt(i), i);
//    	}
//    	
//    	for(int i=0;i<words.length-1;i++) {
//    		char[] pair=getPair(words[i],words[i+1]);
//    		if(char2index.get(pair[1])<char2index.get(pair[0])) {
//    			return false;
//    		}
//    	}
//    	
//    	return true;
    	
    	
    	Map<Character,Integer> char2Index=getIndex(order);
    	
    	for(int i=1;i<words.length;i++) {
    		if(!isOrdered(words[i-1],words[i],char2Index)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    
    
    
    
    
    private Map<Character,Integer> getIndex(String order){
    	Map<Character,Integer> char2Index=new HashMap<>();
    	for(int i=0;i<order.length();i++) {
    		char2Index.put(order.charAt(i), i);
    	}
    	
    	return char2Index;
    }
    private boolean isOrdered(String word1,String word2,Map<Character,Integer> char2Index) {
    	boolean isOrdered=true;
    	
    	for(int i=0;i<Math.min(word1.length(), word2.length());i++) {
    		char c1=word1.charAt(i);
    		char c2=word2.charAt(i);
    		if(char2Index.get(c1)>char2Index.get(c2)) {
    			return false;
    		}else if(char2Index.get(c1)<char2Index.get(c2)) {
    			return true;
    		}
    	}
    	
    	if(word1.length()<=word2.length()) {
    		return true;
    	}else 
    		return false;
    }
    
    
    
    
    
    
    
    
    
    private char[] getPair(String word1,String word2) {
    	int p=0;
    	while(p<word1.length()&&p<word2.length()) {
    		if(word1.charAt(p)!=word2.charAt(p)) {
    			return new char[] {word1.charAt(p),word2.charAt(p)};
    		}
    		p++;
    	}
    	
    	if(word1.length()==word2.length()) {
    		return new char[] {'#','#'};
    	}else if(word1.length()<word2.length()) {
    		return new char[] {'#',word2.charAt(p)};
    	}else {
    		return new char[] {word1.charAt(p),'#'};
    	}
    }
}
