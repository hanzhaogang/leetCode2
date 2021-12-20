/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
Example 4:

Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
 

Constraints:

1 <= chars.length <= 2000
chars[i] is a lower-case English letter, upper-case English letter, digit, or symbol.


How do you know if you are at the end of a consecutive group of characters?



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-compression
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



思路：
首先想到双指针。 p1指向压缩好的string的下一个位置。 p2指向待压缩的string的第一个位置。
p3用来遍历string，同时使用一个temp变量记录p3上一个char的值，如果不一样了，就压缩，同时更新p1&p2.
要注意，压缩时，如果p3-p2的值大于等于10，需要把表示个数的int值的每一位追加到p1指针指向的位置。


这道题好几遍才AC，需要注意几个指针的操作。同时注意不要out of index bound.
还需要注意在除len之前，需要把len暂存，然后除完之后再恢复。
[a,b,b,c]
[a,a,b,b,c,c,c]

[a,b,c]
*/



class Solution {
    public int compress(char[] chars) {
        int p1=0,p2=0,p3=0;
        char pre=chars[0];//a
        while(p3<=chars.length){//0,1,2
            if(p3==chars.length||chars[p3]!=pre){
                int len=p3-p2;//2
                StringBuilder sb=new StringBuilder();
                int temp=len;
                while(len!=0){
                    sb.insert(0,len%10);
                    len/=10;
                }//2
                len=temp;//2
                if(p1<chars.length){//0,1
                    chars[p1++]=pre;//[a],1
                    if(1<len){
                        for(int i=0;i<sb.length();i++){
                            chars[p1++]=sb.charAt(i);
                        }
                    }
                }

                p2=p3;
                if(p3<chars.length){
                    pre=chars[p3];
                }
                p3++;
            }else{
                p3++;//1,2
            }
        }

        /*循环结束时，需要把最后一个待压缩string压缩
        可以利用p3==chars.length来把这个操作合并到while循环中*/
        

        return p1;
    }
}