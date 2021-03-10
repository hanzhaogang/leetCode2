package leetcode;

import java.util.List;

/*
 * You are given an integer array nums 
 * and you have to return a new counts array. 
 * 
 * The counts array has the property 
 * where counts[i] is the number of smaller elements to the right of nums[i].

		 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 

Constraints:

    0 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
*/
/* 思路： 首先看一下数据规模：
10^5 一般是nlogn可以通过。n^2不能通过。

再看解法：
如果采用暴力法，则刚好是n^2： 对于每一个元素，依次遍历它右边的所有元素。
而对于logn的复杂度，本题并无二分查找、树形结构的可能性。
所以基本判定可以用O(n)解决问题。

直觉上可以使用单调栈解决问题。但是之前遇到的单调栈问题都是找到某个元素，而不是计算个数。

如果先排序呢（想办法使数据集合有序呢）？ 1 6 2 5
也就是说，从后往前依次遍历数组元素，1的对应答案是0；然后把1放进一个大顶堆。考虑6时，对堆做弹出操作，直到堆顶元素小于6，此时堆大小就是答案。找到答案后再对堆做压入操作。
考虑2时，堆顶元素应该为6（1）. 考虑5时，堆顶元素应该为6（2,1）

以上使用堆的方式时间复杂度并没有达到要求。最坏情况下，针对某个元素，找到答案需要nlogn。而不是我们想要的logn。
还是需要考虑二分。

----update 
二分查找是logn，但是插入操作是n。。。所以这个解法复杂度还是n^2

*/
public class _315_countOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>((b,a)->{ return a-b;});
        List<Integer> sortedList=new ArrayList<>();//insert at index 0

        List<Integer> res=new ArrayList<>();

        for(int i=nums.length-1;0<=i;i--){
            int num=nums[i];

            int insertIndex=insertIndex(sortedList,num);
            //1,2,2,2,2,3; num=1;num=2; num=3;
            //insert index=lo
            res.add(insertIndex);
            sortedList.add(insertIndex,num);
        }

        // res.reverse();
        Collections.reverse(res);
        return res;
    }

    private int insertIndex(List<Integer> sortedList,int num){
        if(sortedList.size()==0){
            return 0;
        }

        if(sortedList.get(sortedList.size()-1)<num){
            return sortedList.size();  
                          
        }

        int lo=0;
        int hi=sortedList.size()-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(num<=sortedList.get(mid)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }

        return lo;
    }
}

/*在循环体内部排除元素（重点）
while(left < right) 这种写法表示在循环体内部排除元素；
退出循环的时候 left 和 right 重合，区间 [left, right] 只剩下成 1 个元素，这个元素 有可能 就是我们要找的元素。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

思路分析：

首先，插入位置有可能在数组的末尾（题目中的示例 3），需要单独判断。如果在数组的末尾，插入位置的下标就是数组的长度；
否则，根据示例和暴力解法的分析，插入位置的下标是 大于等于 target 的第 1 个元素的位置。
因此，严格小于 target 的元素一定不是解，在循环体中将左右边界 left 和 right 逐渐向中间靠拢，最后 left 和 right 相遇，则找到了插入元素的位置。根据这个思路，可以写出如下代码。

参考代码 1：

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 特判
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 严格小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        return left;
    }
}

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/


线段树的节点记录区间最值和区间元素个数，子节点区间长度对半分。
线段树的构建过程类似于完全二叉树；
insert插入叶子节点（start = end）后更新count；
count查找区间，有现成的区间可以缩短查询次数。
总的时间复杂度O(nlog(end - start))。

作者：Utopiahiker
链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/cong-you-wang-zuo-cha-ru-pai-xu-by-utopiahiker/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) 
            return res;
        //获取区间范围 nums = [5,2,6,1]
        int start = nums[0], end = nums[0];
        for(int i = 0; i < len; i++){
            if(nums[i] < start) start = nums[i];
            if(nums[i] > end) end = nums[i];
        }//[1,6]
        //构建树
        SegmentTreeNode root = build(start, end);//此时每个节点的count值都为0
        //从右向左，边插入边计数
        for(int i = len - 1; i >= 0; i--){
            //计数小于该元素的区间，所以要减一
            res.addFirst(count(root, start, nums[i] - 1));
            insert(root, nums[i], 1);//插入叶子节点
        }
        return res;
    }
    //线段树节点，包含左右最值和该区间叶子节点数，子区间不断递减
    private class SegmentTreeNode{
        int start, end, count;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.count = 0;
            left = null;
            right = null;
        }
    }
    //构建线段树，不断递减区间长度
    private SegmentTreeNode build(int start, int end){//[1,6]
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start != end){
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }
    //插入并更新叶子节点
    private void insert(SegmentTreeNode root, int index, int val){

        if (root.start == index && root.end == index){
            root.count += val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index >= root.start && index <= mid)
            insert(root.left, index, val);
        if (index > mid && index <= root.end)
            insert(root.right, index, val);
        //更新父节点的统计数，便于正好落在区间上的查找
        root.count = root.left.count + root.right.count;
    }
    //根据区间统计
    private int count(SegmentTreeNode root, int start, int end){
        //nums[i] - 1, 排除相等的情况
        if(start > end) return 0;
        //递归到叶子节点，获取计数值
        if (start == root.start && end == root.end){
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftcount = 0, rightcount = 0;
        //统计左半区
        if (start <= mid){
            if (mid < end)
                leftcount = count(root.left, start, mid);
            else
                leftcount = count(root.left, start, end);
        }
        //统计右半区
        if (mid < end){
            if (start <= mid)
                rightcount = count(root.right, mid + 1, end);
            else
                rightcount = count(root.right, start, end);
        }
        return (leftcount + rightcount);
    }
}

作者：Utopiahiker
链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/cong-you-wang-zuo-cha-ru-pai-xu-by-utopiahiker/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。