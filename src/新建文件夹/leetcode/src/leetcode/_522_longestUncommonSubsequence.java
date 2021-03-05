/*

abcd, adefgh, abdghlmn
abced

longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int findLUSlength(String[] strs) {//["aaa","aaa","aa"];   ["aabbcc", "aabbcc","c","e","aabbcd"]
        Arrays.sort(strs,(s1,s2)->{
            return s1.length()-s2.length();
        });
        for(int i=strs.length-1;0<=i;i--){
            boolean curStrValid=true;
            for(int j=strs.length-1;0<=j;j--){
                if(i==j){
                    continue;
                }
                if(isSubsequence(strs[i],strs[j])){
                    curStrValid=false;
                    break;
                }
            }
            
            if(curStrValid){
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    /* the inputs will not be null.
    A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. 
    Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
    public boolean isSubsequence(String str1,String str2){//aaa,aaa
        if(str1.length()==0||str1.equals(str2)){
            return true;
        }

        if(str2.length()<str1.length()){
            return false;
        }

        int p1=0,p2=0;
        while((p1<str1.length())&&(p2<str2.length())){//str1 is shorter or equal to str2
            if(str1.charAt(p1)==str2.charAt(p2)){
                p1++;
                p2++;
            }else{
                p2++;
            }
        }
        
        return p1==str1.length()?true:false;
    }
}