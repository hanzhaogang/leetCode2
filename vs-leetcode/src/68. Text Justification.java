import java.util.ArrayList;
import java.util.List;

public class 68. Text Justification {
	
}
/* Given an array of strings words and a width maxWidth, 
format the text such that each line has exactly maxWidth characters 
and is fully (left and right) justified（对齐）.

You should pack your words in a greedy approach; 
that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line does not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, 
it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", 
because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/text-justification
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
首先确定每一行都应该包含哪些单词。
然后给每一行填入对应的单词。
最后按照要求调整这些单词的位置。*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] lens=new int[words.length];
        for(int i=0;i<words.length;i++){
            String word=words[i];
            lens[i]=word.length();
        }
        List<List<String>> list=new ArrayList<>(); 
        List<String> line=new ArrayList<>();
        int count=0;
        List<Integer> extr_sp_cnt=new ArrayList<>();
        for(String word:words){
            //如果当前行width+word.length()==maxWidth,...如果。。。
            if(count+word.length()==maxWidth||count+word.length()==maxWidth-1){
                line.add(word);
                list.add(new ArrayList<String>(line));
                line.clear();
                count=0;
            }else if(count+word.length()<maxWidth-1){
                line.add(word);
                count+=word.length()+1;
            }else{
                list.add(new ArrayList<String>(line));
                line.clear();
                count=0;
            }            
        }
        //按照规则调整每一行中单词的位置
        List<String> res=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<String> ln=list.get(i);
            
            StringBuilder sb=new StringBuilder();
            if(i==list.size()-1){
                for(int j=0;j<ln.size();j++){
                    if(j==ln.size()-1){
                        sb.append(ln.get(j));
                    }else{
                        sb.append(ln.get(j)).append(" ");
                    }
                }
            }else{
                int charCount=0;
                for(String word:ln){
                    charCount+=word.length();
                }
                int wordCount=ln.size();            
                int spaceCount=maxWidth-charCount;
                List<String> spc_list=new ArrayList<>();
                if()
            }
        }
        return res;
    }
}
