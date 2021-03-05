package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _919_meetingRoomTwo {
/*
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Example1

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)

Example2

Input: intervals = [(2,7)]
Output: 1
Explanation: 
Only need one meeting room
 */
	public int minMeetingRooms(List<Interval> intervals) {
		List<int[]> timeSpotsList=new ArrayList<>();
		for(Interval i:intervals) {
			timeSpotsList.add(new int[] {i.start,1});
			timeSpotsList.add(new int[] {i.end,-1});
		}
		
		Collections.sort(timeSpotsList,(a1,a2)->{
				return a1[0]-a2[0];});
		
		int res=0;
		int curCnt=0;
		for(int[] a:timeSpotsList) {
			if(a[1]==1) {
				curCnt++;
			}else {
				curCnt--;
			}
			
			if(res<curCnt)
				res=curCnt;
		}
		
		return res;
	}
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
    	return "start: "+start+" end: "+end;
    }
}

class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) 
        	return 0;
        if(intervals.size()==1) 
        	return 1;
        
        int[] starts=new int[intervals.size()];
        int[] ends=new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            Interval interval=intervals.get(i);
            starts[i]=interval.start;
            ends[i]=interval.end;
        }    
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int count=0,maxCount=0;
        
        for(int i=0,j=0;i<starts.length;){//we use i in the for loop.
            if(starts[i]<ends[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            } 
            maxCount=count<maxCount?maxCount:count;
        }
        return maxCount;
    }
}
