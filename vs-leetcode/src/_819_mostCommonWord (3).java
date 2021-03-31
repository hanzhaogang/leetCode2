package amzn2020june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _819_mostCommonWord {
	/*
	 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  
Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

 

Note:

    1 <= paragraph.length <= 1000.
    0 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.
	 */
	
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> banSet=new HashSet<>(Arrays.asList(banned));
		//String[] words=paragraph.toLowerCase().split([" ","!","?","'",",",";"|"."]);//!?',;.
		List<String> words=split(paragraph.toLowerCase());
		
		
		Map<String,Integer> wordCount=new HashMap<>();
		String res="";
		int maxCount=0;
		//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
		for(String word:words) {
			if(!banSet.contains(word)) {
				int preCount=wordCount.containsKey(word)?wordCount.get(word):0;
				if(maxCount<preCount+1) {
					res=word;
					maxCount=preCount+1;
				}
				wordCount.put(word, preCount+1);
			}
		}
		
		return res;
    }
	
	private List<String> split(String paragraph){
		List<String> res=new ArrayList<>();
		for(int i=0,j=0;i<paragraph.length()&&j<paragraph.length();) {
			while(j<paragraph.length()&&isLetter(paragraph.charAt(j))) {
				j++;
			}
			res.add(paragraph.substring(i,j));
			while(j<paragraph.length()&&!isLetter(paragraph.charAt(j))) {
				j++;
			}
			i=j;
		}
		return res;
	}
	
	private boolean isLetter(char c) {
		return Character.getType(c)==Character.LOWERCASE_LETTER||
				Character.getType(c)==Character.UPPERCASE_LETTER;
	}
}
