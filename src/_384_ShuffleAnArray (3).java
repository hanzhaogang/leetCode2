package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. 
 * Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();


The solution expects that we always use the original array to shuffle() 
else some of the test cases fail. (Credits; @snehasingh31)
/*

//// 得到一个在闭区间 [min, max] 内的随机整数
//int randInt(int min, int max);
//
//// 第一种写法
//void shuffle(int[] arr) {
//    int n = arr.length();
//    /******** 区别只有这两行 ********/
//    for (int i = 0 ; i < n; i++) {
//        // 从 i 到最后随机选一个元素
//        int rand = randInt(i, n - 1);
//        /*************************/
//        swap(arr[i], arr[rand]);
//    }
//}
//
//// 第二种写法
//    for (int i = 0 ; i < n - 1; i++)
//        int rand = randInt(i, n - 1);
//
//// 第三种写法
//    for (int i = n - 1 ; i >= 0; i--)
//        int rand = randInt(0, i);
//
//// 第四种写法
//    for (int i = n - 1 ; i > 0; i--)
//        int rand = randInt(0, i);

/*
 * 暴力算法简单的来说就是把每个数放在一个 ”帽子“ 里面，每次从 ”帽子“ 里面随机摸一个数出来，
 * 直到 “帽子” 为空。
 * 
 * 下面是具体操作，首先我们把数组 array 复制一份给数组 aux，
 * 之后每次随机从 aux 中取一个数，为了防止数被重复取出，每次取完就把这个数从 aux 中移除。
 * 重置 的实现方式很简单，只需把 array 恢复称最开始的状态就可以了。
 * 
 * 
 * Fisher-Yates 洗牌算法跟暴力算法很像。
 * 在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
 * 接下来，将当前元素和随机选出的下标所指的元素互相交换 -
 *  这一步模拟了每次从 “帽子” 里面摸一个元素的过程，
 *  其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了。
 *  此外还有一个需要注意的细节，当前元素是可以和它本身互相交换的 - 否则生成最后的排列组合的概率就不对了

 */
public class _384_ShuffleAnArray {
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3,4,5,6};
		_384_ShuffleAnArray s=new _384_ShuffleAnArray(nums);
		int[] res=s.shuffle2();
		for(int i:res) {
			System.out.println(i);
		}
	}
	
	List<Integer> list=new LinkedList<>();
	int[] backup;
	int[] array;
	Random r=new Random();
    public _384_ShuffleAnArray(int[] nums) {
    	backup=nums.clone();
    	array=nums.clone();
    	for(int num:nums) {
    		list.add(num);
    	}
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	list.clear();
    	for(int num:backup) {
    		list.add(num);
    	}
    	
    	array=backup.clone();
    	return backup;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	list.clear();
    	for(int num:backup) {
    		list.add(num);
    	}
    	
    	int[] res=new int[list.size()];
    	
    	int j=0;
    	while(list.size()!=0) {
    		int size=list.size();
    		int i=r.nextInt(size);
    		res[j++]=list.remove(i);
    	}
    	return res;
    }
    
    public int[] shuffle2() {
    	for(int i=0;i<array.length;i++) {
    		int index=i+r.nextInt(array.length-i);
    		int temp=array[index];
    		array[index]=array[i];
    		array[i]=temp;
    	}
    	
    	return array;
    }
}
