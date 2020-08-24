package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 17 Letter Combinations of a Phone Number tbd
/*
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class _17_LetterCombOfAPhoneNumber {
	public static void main(String[] args) {
		String digits="";
		_17_LetterCombOfAPhoneNumber s=new _17_LetterCombOfAPhoneNumber();
		System.out.println(s.letterCombinations(digits));
	}
    String[] map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//map vs array!!!!!
    

	public List<String> letterCombinations(String digits) {
		List<String> combList=new ArrayList<>();
		if(digits.length()==0)
			return combList;
		
		Map<String,String> digit2char=new HashMap<>();
		String[] lettersArray=new String[] {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		for(int i=2;i<=9;i++) {
			digit2char.put(String.valueOf(i), lettersArray[i-2]);
		}
		bt(combList,new StringBuilder(),digits,0,digit2char);
		return combList;
	}
	
	private void bt(List<String> combList,StringBuilder sb,String 
					digits,int lo,Map<String,String> digit2char) {
		if(lo==digits.length()) {
			String combStr=sb.toString();
			combList.add(combStr);
			return;
		}
		
		String curDigit=String.valueOf(digits.charAt(lo));
		String curCharStr=digit2char.get(curDigit);
		for(int i=0;i<curCharStr.length();i++) {
			char c=curCharStr.charAt(i);
			sb.append(String.valueOf(c));
			bt(combList,sb,digits,lo+1,digit2char);
			sb.delete(sb.length()-1,sb.length());
		}
	}
}