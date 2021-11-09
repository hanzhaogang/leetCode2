import java.util.HashMap;
import java.util.Map;

/*面试题 16.02. Words Frequency LCCI
Design a method to find the frequency of occurrences of any given word in a book. 
What if we were running this algorithm multiple times?

You should implement following methods:

WordsFrequency(book) constructor, parameter is a array of strings, representing the book.
get(word) get the frequency of word in the book. 
Example:

WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
wordsFrequency.get("you"); //returns 0，"you" is not in the book
wordsFrequency.get("have"); //returns 2，"have" occurs twice in the book
wordsFrequency.get("an"); //returns 1
wordsFrequency.get("apple"); //returns 1
wordsFrequency.get("pen"); //returns 1
Note:

There are only lowercase letters in book[i].
1 <= book.length <= 100000
1 <= book[i].length <= 10
get function will not be called more than 100000 times.
*/
class WordsFrequency {
    Map<String,Integer> map=new HashMap<>();
    public WordsFrequency(String[] book) {
        
        for(String word:book){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }
    }
    
    public int get(String word) {
        return map.getOrDefault(word,0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */