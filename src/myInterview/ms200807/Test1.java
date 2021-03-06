package ms200807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 项目
 * http  异步vs同步请求  长连接（） 长短连接 vs 长短轮询
 * 
 * 2   3    404 401 403   500 501 503 gateway   
 * 
 *  
 *  http 鉴权  timestamp
 *  
 *  
 *  oAuth  用微信账号登录qq音乐
 *  
 *  
 *  
 *  docker  docker file， image过大如何精简
 *  
   *   本地编译再打包？？
   *   
   *   java
   *   
   *   垃圾回收
   *   
   *   
 *  *Hire Recommendation:Hire 
*Feedback:zhaogang has 7+ years working experience on Java and backend service.

He can communicate with us well, 
and he knows the technical details about his project. 
I asked some technical questions related to his project, he can answer them well.

For algorithm part, he can ask questions related to the problem, 
and communicate with us about his ideas, 
he can also consider corner cases. 
Finally he come up optimized code for the problem.

So recommended this candidate. 
 *  
 *  
 *  给定一个整数数组，找到数组中三个数字，他们相加为0，这三个数字由小到大排列
 */
public class Test1 {
	/*{-1 0 1}
	{-2 0 2}
	
		[0,0,0,0]
		[0,0,0]
	
	
	n*n*/
	
	
	public List<List<Integer>> find(int[] a){
		Arrays.sort(a);//[-2 -1 0 1   2]
		
		
		for(int i=a.length-1;2<=i;i--) {
			int third=a[i];
			int target=0-third;
		}
		
		List<List<Integer>> res=new ArrayList<>();
		return res;
	}
	
	
	
	
	
	
	
}
