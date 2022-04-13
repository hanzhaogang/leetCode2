public class 357 {
	
}

/*  Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
1位：10
2位：9*9=81
3位：
*/
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
	if(n==0) return 1;
	if(n==1) return 10;
	if(n==2) return 9*9+10;
	if (n==3) return 9*9*8+ countNumbersWithUniqueDigits(2);
	if(n==4) return 9*9*8*7+ countNumbersWithUniqueDigits(3);
	if(n==5) return 9*9*8*7*6+countNumbersWithUniqueDigits(4);
	if(n==6) return 9*9*8*7*6+countNumbersWithUniqueDigits(5);
	if(n==7) return 9*9*8*7*6+countNumbersWithUniqueDigits(6);
	if(n==8) return 9*9*8*7*6+countNumbersWithUniqueDigits(7);

	// return helper(n);
    }
//     private int helper(int n){
// 	if(n==0) return 1;
// 	if(n==1) return 10;
// 	int c=0;
// 	9*9*
// 	return helper(n-1)+c;
//     }
}