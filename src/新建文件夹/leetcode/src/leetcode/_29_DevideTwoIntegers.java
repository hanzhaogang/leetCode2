package leetcode;
/*
 * Given two integers dividend and divisor, 
 * divide two integers without using 
 * multiplication, division and mod operator.
 * 

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, 
which means losing its fractional part. 
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Note:

    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    
    Assume we are dealing with an environment 
    which could only store integers within 
    the 32-bit signed integer range: [−231,  231 − 1]. 
    For the purpose of this problem, 
    assume that your function returns 231 − 1 
    when the division result overflows.

 */
public class _29_DevideTwoIntegers {
	public static void main(String[] args) {
		_29_DevideTwoIntegers s=new _29_DevideTwoIntegers();
		int dividend=17;
		int divisor=3;
		System.out.println(s.div_rec(dividend, divisor));
	}
    public int divide(int dividend, int divisor) {
    	  	
    	if(0<dividend&&0<divisor)
    		return (int)div_rec(dividend,divisor);
    	long div_res=0L;
    	if(dividend<0&&divisor<0) {
    		div_res=div_rec(0L-(long)dividend,0L-(long)divisor);
    		
    	}else if(dividend<0) {//-1/1
    		div_res=0L-div_rec(0L-(long)dividend,divisor);
    	}else {
    		div_res=0L-div_rec((long)dividend,0L-(long)divisor);
    	}
    	
    	return (long)Integer.MIN_VALUE<=div_res&&
    							div_res<=(long)Integer.MAX_VALUE?
    			(int)div_res:Integer.MAX_VALUE;
    }
    
    /*11/3;4/3;;17/3
    */
    private long div_rec(long dividend,long divisor) {//both larger than 0
    	//10,3//4,3
    	if(dividend<divisor)
    		return 0L;
    	if(dividend==divisor)
    		return 1L;
    	
    	long temp_divisor=divisor;//3
    	
    	long sum=0;
    	long count=1;
    	while(temp_divisor<dividend) {//3<10
    		sum=temp_divisor;//3
    		temp_divisor=temp_divisor+temp_divisor;//6
    		
    		count=count+count;//1
    	}//temp_divisor=12;count=2;
    	count=count>>1;
    	
    	long res=0;
    	res=res+count+div_rec(dividend-sum,divisor);
    	return res;
    }
}
