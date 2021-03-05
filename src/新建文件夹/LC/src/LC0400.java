
public class LC0400 {
	public int findNthDigit(int n) {
        int result=0;
        int index=0;
        for(int i=1;i<=n;i++){
            String s=((Integer)i).toString();
            index+=s.length();
            if(index<n)
                continue;
            else{
                return s.charAt(s.length()-1-(index-n))-'0';
            }
        }
        return result;
    }
}

 /* 400. Nth Digit
Easy

238

751

Favorite

Share
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */






