package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}


public class _253_meetingRoom2_919 {
	public int minMeetingRooms(List<Interval> intervals) {
		if(intervals==null)
			return 0;
		
        // Write your code here
        List<int[]> timeSpots=new ArrayList<>(); 
        for(Interval interval:intervals) {
        	timeSpots.add(new int[] {interval.start,1});
        	timeSpots.add(new int[] {interval.end,-1});
        }
        
        Collections.sort(timeSpots,(t1,t2)->{
        	if(t1[0]!=t2[0]) {
        		return Integer.compare(t1[0],t2[0]);
        	}else if(t1[1]!=t2[1]){
        		return Integer.compare(t1[1], t2[1]);
        	}else {
        		return 0;
        	}
        });
        
        int res=0;
        int curCount=0;
        for(int[] timeSpot:timeSpots) {
        	if(timeSpot[1]==1) {
        		curCount++;
        	}else {
        		curCount--;
        	}
        	
        	if(res<curCount)
        		res=curCount;
        }
        return res;
    }
}
