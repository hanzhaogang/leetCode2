package amzn2020june;

public class _866_PrimePalindrome {
/*
 * Find the smallest prime palindrome greater than or equal to N.

Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1. 

For example, 2,3,5,7,11 and 13 are primes.

Recall that a number is a palindrome if it reads the same from left to right as it does from right to left. 

For example, 12321 is a palindrome.
 */
	public int primePalindrome(int N) {
		int curVal=N;
		while(true) {
			if(10_000_000<curVal&&curVal<100_000_000) {
				curVal=100_000_000;
			}
			if(curVal==10||curVal==11)
				return curVal;
			
			int len=digitsCount(curVal);
			if(len%2==0){
				curVal=(int)Math.pow(10,len)+1;
				continue;
			}
			/*
			 * 有两条定理，除 11 外的偶数位回文数，都能被 11 整除。除 2 和 3 外，所有的素数一定在 6 的两侧（6x -1, 6x + 1)。
			 */
			
			if(isPalindrome(curVal)&&isPrime(curVal)) {
				return curVal;
			}
			curVal++;
		}
    }
	private int digitsCount(int N) {
		int count=0;
		while(N!=0) {
			N/=10;
			count++;
		}
		return count;
	}
	private boolean isPalindrome(int N) {
		int r=0;
		int i=N;
		while(i!=0) {
			r=10*r+i%10;
			i/=10;
		}
		return r==N;
	}
	private boolean isPrime(int N) {
		if(N<=1) {
			return false;
		}
		if(N==2||N==3)
			return true;
		/*
		 * N%6= 2,3,4
		 */
		if(N%6==2||N%6==3||N%6==4)
			return false;
		
		int hi=(int)Math.sqrt(N);
		for(int i=2;i<=hi;i++) {
			if(N%i==0)
				return false;
		}
		
		return true;
	}
}
