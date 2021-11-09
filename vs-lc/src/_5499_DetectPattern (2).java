package leetCode;
/*
 * [3,2,2, 1,2,2, 1,1,1, 2,3,2, 2]
3
2
 */
public class _5499_DetectPattern {
	public static void main(String[] args) {
		_5499_DetectPattern s=new _5499_DetectPattern();
		int[] arr= {2,2};
		int m=1;
		int k=2;
		System.out.println(s.containsPattern(arr, m, k));
	}
    public boolean containsPattern(int[] arr, int m, int k) {//1,2,1,2,1,1,1,3 m=2 k=3;
        //2,2; m=1; k=2;
        //1,2,3,1,2; m=2;k=2;
        //[3,2,2,1,2,2,1,1,1,2,3,2,2] 3 2 
        for(int i=0;i<=arr.length-m;i++){
        	int count=0;
        	String prePattern="";
            for(int j=i;j<=arr.length-m;j+=m){
            	StringBuilder sb=new StringBuilder();
            	for(int l=j;l<j+m;l++) {
            		sb.append(arr[l]);
            	}
            	if(prePattern.equals(sb.toString())){
            		count++;
            	}else{
            		count=1;
            		prePattern=sb.toString();
            	}
            	if(count==k)
            		return true;
            }
        }
        /*
         * 三百五十六
         */
        return false;
    }
}
