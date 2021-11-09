package leetcode;
/*
 * Convert a non-negative integer to its English words representation. 
 * Given input is guaranteed to be less than 231 - 1.

For example,

123 -> "One Hundred Twenty Three"
12 345 -> "Twelve Thousand       
           Three Hundred Forty Five"
1 234 567 -> "One Million        
              Two Hundred Thirty Four Thousand 
              Five Hundred Sixty Seven"

1 234 567 899

Hint:

    Did you see a pattern in dividing the number into chunk of words? 
    For example, 123 and 123000.
    Group the number by thousands (3 digits). 
    You can write a helper function that takes a number less than 1000 
    and convert just that chunk to words.
    There are many edge cases. 
    What are some good test cases? 
    Does your code work with input such as 0? Or 1000010? 
    (middle chunk is zero and should not be printed out)

 */
public class _273_integer2englishWord {
	String[] digit=new String[] {
			"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	public String numberToWords(int num) {
		
		if(num==0)
			return "Zero";
		
		String[] surfix=new String[] {"Billion","Million","Thousand"};
		StringBuilder sb=new StringBuilder();
		if(num/1000000000!=0) {
			sb.append(_3digits2word(num/1000000000));
			sb.append(" Billion ");
		}
		
		num%=1000000000;
		if(num/1000000!=0) {
			sb.append(_3digits2word(num/1000000));
			sb.append(" Million ");
		}
		
		num%=1000000;
		if(num/1000!=0) {
			sb.append(_3digits2word(num/1000));
			sb.append(" Thousand ");
		}
		
		num%=1000;
		sb.append(_3digits2word(num/1));
		
		return sb.toString().trim();
	}
	private String _3digits2word(int num) {//0,10,100,101,999
		StringBuilder sb=new StringBuilder();

		if(num/100!=0) {
			sb.append(digit[num/100]);
			sb.append(" Hundred");
		}

		num%=100;
		String[] ty=new String[] {
				"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
		String[] teen=new String[] {
				"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
				"Seventeen","Eighteen","Nineteen"};
		if(1==num/10) {
			sb.append(" ");
			sb.append(teen[num%10]);
		}else {
			if(1<num/10) {
				sb.append(" ");
				sb.append(ty[num/10-2]);
			} 
			num%=10;
			sb.append(" ");
			sb.append(digit[num]);
		}
		return sb.toString().trim();
	}
}