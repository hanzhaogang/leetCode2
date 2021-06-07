import java.util.ArrayList;
import java.util.List;

public class _mianshiti_08_07permutation {
    
}
/*abstractWrite a method to compute all permutations of a string of unique characters.

Example1:

 Input: S = "qwe"
 Output: ["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
Example2:

 Input: S = "ab"
 Output: ["ab", "ba"]
Note:

All charaters are English letters.
1 <= S.length <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-i-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


class Solution {
    public String[] permutation(String S) {
        List<String> list=new ArrayList<>();
        bt(list,new StringBuilder(),S,0);
        
        String[] res=new String[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    private void bt(List<String> list,StringBuilder sb,String S,int lo){

    }
}