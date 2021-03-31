
public class Company_Grab_1 {
	
	/*
	 * there are two numbers, and we have the array of all their devisors.
	 * output these two numbers. 
	 */
	public int[] findNums(int[] array) {
		/*
		 * 
		 * NOTE: whether the number can be negative???
		 * the answer should be NO.
		 * If yes, for [8,9] and [-8,-9]
		 * the array should be the same. 
		 * 
		 * find the largest num, which should be one of the results.
		 * 
		 * if these two numbers can not be devided by the other:
		 * the largest number which cannot devide the first number is the second.
		 * 
		 * else:
		 * the second largest number is the second answer.
		 * 
		 * TC:O(n)
		 * SC:O(1)
		 */
		int largest=Integer.MIN_VALUE;
		for(int i:array) {
			largest=largest<i?i:largest;
		}
		
		int largestUD=0;
		int secondD=0;
		for(int i:array) {
			if(largest%i!=0) {
				largestUD=largestUD<i?i:largestUD;
			} else {
				if(i!=largest)
					secondD=secondD<i?i:secondD;
			}
				
		}
		
		return new int[] {largest,largestUD};
	}
}
/*
 * 
 * [1,2,4,8,3,9]    8,9
 * [1,2,4,8,16]     8,16
 */


