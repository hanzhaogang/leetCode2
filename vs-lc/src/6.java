public class 6 {
	
}
/* PAYPALISHIRING 3 

"P A H N
 APLLIGGYIRnull"
 
 
 corner case:
 numRows==1时，subLen为0,会抛除数为0的异常
 拼接最终的字符串时，如果String【】【】中的String为null，需要舍弃。
 计算反向字符的index的时候，需要以subLen为周期，而不是numRows*/

 
class Solution {
    public String convert(String s, int numRows) {
	int subLen=numRows*2-2;
	String[][] arr=new String[numRows][s.length()/subLen+1];
	for(int i=0;i<s.length();i++){
		if(i%subLen==0){
			arr[0][i/subLen]=String.valueOf(s.charAt(i));
		}else if(i%subLen==numRows-1){
			arr[numRows-1][i/subLen]=String.valueOf(s.charAt(i));
		}else if(numRows-1<i%subLen){
			;
		}else{
			String t=String.valueOf(s.charAt(i));
			int j=i+2*(i/subLen*subLen+numRows-1-i);//int j=i+2*(numRows-1-i%numRows);
			if(j<s.length())
				t+=s.charAt(j);
			arr[i%subLen][i/subLen]=t;
		}
	}
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[0].length;j++){
			if(arr[i][j]!=null)
				sb.append(arr[i][j]);
		}
	}
	return sb.toString();
    }
}