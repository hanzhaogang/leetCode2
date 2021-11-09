package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. 
Each revision consists of digits and may contain leading zeros. 
Every revision contains at least one character. 
Revisions are 0-indexed from left to right, 
with the leftmost revision being revision 0,
 the next revision being revision 1, and so on. 
 For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. 
Revisions are compared using their integer value ignoring any leading zeros. 
This means that revisions 1 and 001 are considered equal. 
If a version number does not specify a revision at an index, 
then treat the revision as 0. 
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, 
but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 

Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
Example 4:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 5:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
 

Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compare-version-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路:
这道题不是考察算法基本功、思维，而是考察coding基本功。
把version1、version2先分割成为string类型的reversion数组
*/

public class _165_compareVersion {
    public int compareVersion1(String version1, String version2) {
        String[] str1=version1.split("\\.");
        String[] str2=version2.split("\\.");
        int i=0;
        while(i<str1.length&&i<str2.length){
            if(Integer.compare(Integer.parseInt(str1[i]), Integer.parseInt(str2[i]))
        }
    }

	public int compareVersion1(String version1, String version2) {
	    String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? 
	    			Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? 
	    			Integer.parseInt(levels2[i]) : 0;
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
	}

    public int compareVersion(String version1, String version2) {
        List<String> ver1Nums=new ArrayList(Arrays.asList(version1.split("\\.")));
        List<String> ver2Nums=new ArrayList(Arrays.asList(version2.split("\\.")));

        if(ver1Nums.size()<ver2Nums.size()){
            int diff=ver2Nums.size()-ver1Nums.size();
            for(int i=0;i<diff;i++){
                ver1Nums.add("0");
            }
        }
        if(ver2Nums.size()<ver1Nums.size()){
            int diff=ver1Nums.size()-ver2Nums.size();
            for(int i=0;i<diff;i++){
                ver2Nums.add("0");//ver2Nums.size() will be changed here.
            }
        }
        
        int i=0;
        while(i<ver1Nums.size()&&i<ver2Nums.size()){
            int i1=Integer.parseInt(ver1Nums.get(i));
            int i2=Integer.parseInt(ver2Nums.get(i));
            if(i1<i2)
                return -1;
            else if(i2<i1)
                return 1;  
            else
                i++;
        }
        
        return 0;
    }
}
	