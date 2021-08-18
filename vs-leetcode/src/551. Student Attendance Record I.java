public class 551. Student Attendance Record I {
	
}
/* You are given a string s representing an attendance record for a student 
where each character signifies whether the student was absent, late, or present on that day. 
The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
The student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Return true if the student is eligible for an attendance award, or false otherwise.

 

Example 1:

Input: s = "PPALLP"
Output: true
Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
Example 2:

Input: s = "PPALLL"
Output: false
Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 

Constraints:

1 <= s.length <= 1000
s[i] is either 'A', 'L', or 'P'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/student-attendance-record-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public boolean checkRecord(String s) {
	int a_count=0;
	int l_count=0;
	for(int i=0;i<s.length();i++){
		char c=s.charAt(i);
		if(c=='A'){
			a_count++;
			l_count=0;//note this line.
			if(a_count==2){
				return false;
			}
		}else if(c=='L'){
			l_count++;
			if(3<=l_count){
				return false;
			}
		}else {
			l_count=0;
		}
	}
	return true;
    }
}