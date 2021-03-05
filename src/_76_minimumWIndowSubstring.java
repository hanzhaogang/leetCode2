import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBEC ODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.
 

Follow up: Could you find an algorithm that runs in O(n) time?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



暴力法 n^3?

sliding window： 
Use two pointers to create a window of letters in S, which would have all the characters from T.

Since you have to find the minimum window in S which has all the characters from T, you need to expand and contract the window using the two pointers 
and keep checking the window for all the characters. This approach is also called Sliding Window Approach.

L ------------------------ R , Suppose this is the window that contains all characters of T 
                          
        L----------------- R , this is the contracted window. We found a smaller window that still contains all the characters in T

When the window is no longer valid, start expanding again using the right pointer. 

T中可能有重复字符。 
*/
/*
"""给定待查串s， 目标串t"""
need, window = {}, {}
for c in t:
    记录need            # 视具体问题而定，用于判断窗口包含的字串是否满足题目要求
left, right = 0, 0      # 初始化左右指针，窗口是左闭右开区间，[left, right)
while right < len(s):
    c = s[right]
    right += 1
    更新窗口数据
    while 满足窗口收缩条件：
        记录优化后的结果
        d = s[left]
        left += 1
        更新窗口数据
return 结果

作者：jue-qiang-zha-zha
链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/76-zui-xiao-fu-gai-zi-chuan-hua-dong-chu-9ju0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//  滑动窗口算法框架 
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;
    
    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        // debug 输出的位置 
        printf("window: [%d, %d)\n", left, right);
        
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
*/

class Solution {
    public String minWindow(String s, String t) {//a,a; Input: s = "ADOBEC ODEBANC", t = "ABC"
        Map<Character,Integer> char2count_t=new HashMap<>();
        Map<Character,Integer> char2count_window=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            char2count_t.put(c, char2count_t.getOrDefault(c, 0)+1);
        }

        int lo=0;
        int hi_ex=0;
        int res_len=Integer.MAX_VALUE;
        String res="";
        while(hi_ex<s.length()){
            char c=s.charAt(hi_ex);
            hi_ex++;
            //update window data
            if(char2count_t.containsKey(c)){
                char2count_window.put(c, char2count_window.getOrDefault(c, 0)+1);
            }

            while(isValid(char2count_window,char2count_t)){
                String curStr=s.substring(lo, hi_ex);
                if(curStr.length()<res_len){
                    res=curStr;
                    res_len=curStr.length();
                }

                char lo_c=s.charAt(lo);
                lo++;
                //update window data
                if(char2count_t.containsKey(lo_c)){
                    if(char2count_window.get(lo_c)==1){
                        char2count_window.remove(lo_c);
                    }else{
                        char2count_window.put(lo_c, char2count_window.get(lo_c)-1);
                    }
                }

                
            }
        }

        return res;
    }

    private boolean isValid(Map<Character,Integer> char2count_window,Map<Character,Integer> char2count_t){
        for(Map.Entry<Character,Integer> e:char2count_t.entrySet()){
            char c=e.getKey();
            int i=e.getValue();
            if(!char2count_window.containsKey(c) || char2count_window.get(c)<i){
                return false;
            }
        }

        return true;
    }
}