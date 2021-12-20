import java.util.ArrayList;
import java.util.List;

/*
Write a method to return all subsets of a set. The elements in a set are pairwise distinct.

Note: The result set should not contain duplicated subsets.

Example:

 Input:  nums = [1,2,3]
 Output: 
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-set-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class _mianshiti_0804PowerSet {
    
}


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        bt2(res,new ArrayList<Integer>(),nums,0);
        return res;
    }

    private void bt(List<List<Integer>> res,List<Integer> temp,int[] nums,int lo){
        if(lo==nums.length){
            List<Integer> set=new ArrayList<>(temp);
            res.add(set);

            return;
        }

        int num=nums[lo];
        temp.add(num);
        bt(res,temp,nums,lo+1);
        temp.remove(temp.size()-1);
        bt(res,temp,nums,lo+1);
    }


    private void bt2(List<List<Integer>> res,List<Integer> temp,int[] nums,int lo){
        if(lo==nums.length){
            List<Integer> set=new ArrayList<>(temp);
            res.add(set);

            return;
        }
        /*
        每个步骤中的每个选择，只有选或者不选两种。
        */
        for(int i=lo;i<nums.length;i++){
            temp.add(nums[i]);
            bt2(res,temp,nums,lo+1);
            temp.remove(temp.size()-1);
        }
    }


public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    //先排序
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    //注意这里没有写终止条件，不是说递归一定要有终止条件的吗，这里怎么没写，其实这里的终止条件
    //隐含在for循环中了，当然我们也可以写if(start>nums.length) rerurn;只不过这里省略了。
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
        //做出选择
        tempList.add(nums[i]);
        //递归
        backtrack(list, tempList, nums, i + 1);
        //撤销选择
        tempList.remove(tempList.size() - 1);
    }
}

    /*
    决策树，每一个步骤，如果有2个选择，那么就是二叉树；
    如果有多个选择，那么就是n叉树。
    */
    private void bt3(List<List<Integer>> res,List<Integer> temp,int[] nums,int lo){
        if(lo==nums.length){
            List<Integer> set=new ArrayList<>(temp);
            res.add(set);

            return;
        }
        /*
        每个步骤中的每个选择，只有选或者不选两种。
        */
        for(int i=0;i<1;i++){
            temp.add(nums[i]);
            bt2(res,temp,nums,lo+1);
            temp.remove(temp.size()-1);
        }
    }
}

/*
回溯模板
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择


        回溯是一种算法思想，它是用递归实现的
*/