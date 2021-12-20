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
最后按照要求调整这些单词的位置。

码后检查&corner case的思路：
可以直接看代码，在看的时候，针对每一步操作，考虑corner case。注意，这并不能代替跑test case。

*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> full_text=new ArrayList<>(); 
        List<String> line=new ArrayList<>();
        int cur_word_c=0;
        for(String word:words){
            //如果当前行width+word.length()==maxWidth,...如果。。。
            if(cur_word_c+word.length()==maxWidth||cur_word_c+word.length()==maxWidth-1){
                line.add(word);
                full_text.add(new ArrayList<String>(line));
                line.clear();
                cur_word_c=0;
            }else if(cur_word_c+word.length()<maxWidth-1){
                line.add(word);
                cur_word_c+=word.length()+1;
            }else{//换一行
                full_text.add(new ArrayList<String>(line));
                line.clear();
                line.add(word);
                cur_word_c=word.length();
                if(cur_word_c==maxWidth||cur_word_c==maxWidth-1){
                    full_text.add(new ArrayList<String>(line));
                    line.clear();
                    cur_word_c=0;
                }else{
                    cur_word_c++;
                }
            }            
        }
        if(line.size()!=0)
            full_text.add(line);
        //按照规则调整每一行中单词的位置
        List<String> res=new ArrayList<>();
        for(int i=0;i<full_text.size();i++){
            List<String> ln=full_text.get(i);
            StringBuilder sb=new StringBuilder();
            if(ln.size()==1){
                    sb.append(ln.get(0));
                    for(int j=0;j<maxWidth-ln.get(0).length();j++){
                        sb.append(" ");
                    }
            }else if(i==full_text.size()-1){
                int cur_c_c=0;
                for(int j=0;j<ln.size();j++){
                    if(j==ln.size()-1){
                        sb.append(ln.get(j));
                        cur_c_c+=ln.get(j).length();
                        for(int k=0;k<maxWidth-cur_c_c;k++){
                            sb.append(" ");
                        }
                    }else{
                        sb.append(ln.get(j)).append(" ");
                        cur_c_c+=ln.get(j).length()+1;
                    }
                }
            }else{
                int charCount=0;
                for(String word:ln){
                    charCount+=word.length();
                }
                int wordCount=ln.size();            
                int spaceCount=maxWidth-charCount;
                if(spaceCount%(wordCount-1)==0){
                    for(int j=0;j<wordCount-1;j++){
                        sb.append(ln.get(j));
                        int c=spaceCount/(wordCount-1);
                        for(int k=0;k<c;k++){
                            sb.append(" ");
                        }
                    }
                }else{
                    for(int j=0;j<wordCount-1;j++){
                        sb.append(ln.get(j));
                        int spc_c=spaceCount/(wordCount-1);
                        for(int k=0;k<spc_c;k++){
                            sb.append(" ");
                        }
                        int frst_c=spaceCount%(wordCount-1);
                        if(j<frst_c){
                            sb.append(" ");
                        }
                    }
                }
                sb.append(ln.get(wordCount-1));
            }
            res.add(sb.toString());
        }
        return res;
    }
}
