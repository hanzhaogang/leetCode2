package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
1
2
3
4
5
6
	
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

Example 2:
1
2
	
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn’t include intervals like [5, 5] in our answer, as they have zero length.

Note:

    schedule and schedule[i] are lists with lengths in range [1, 50].
    0 <= schedule[i].start < schedule[i].end <= 10^8.

 */
public class _759_employeeFreeTime {
	public static void main(String[] args) {
		_759_employeeFreeTime s=new _759_employeeFreeTime();
		List<List<Interval759>> schedule=Arrays.asList(
				Arrays.asList(new Interval759(1,3),new Interval759(6,7)),
				Arrays.asList(new Interval759(2,4)),
				Arrays.asList(new Interval759(2,5),new Interval759(9,12)));
		System.out.println(s.employeeFreeTime(schedule));
	}
	public List<Interval759> employeeFreeTime(List<List<Interval759>> schedule) {	
		List<Interval759> oriIntervals=new ArrayList<>();
		for(List<Interval759> sch:schedule) {
			oriIntervals.addAll(sch);
		}
		
		Collections.sort(oriIntervals,(i1,i2)->{
			return Integer.compare(i1.start, i2.start);
		});
		
		List<Interval759> res=new ArrayList<>();
		for(int i=1;i<oriIntervals.size();i++) {
			Interval759 pre=oriIntervals.get(i-1);
			Interval759 cur=oriIntervals.get(i);
			if(pre.end<cur.start) {
				res.add(new Interval759(pre.end,cur.start));
			}else {
				cur.end=Math.max(cur.end, pre.end);
			}
		}
		
		return res;
//		if(oriIntervals.size()<=1) {
//			return oriIntervals;
//		}
//		
//		List<Interval759> mergedList=new ArrayList<>();
//		mergedList.add(oriIntervals.get(0));
//		for(int i=1;i<oriIntervals.size();i++) {
//			Interval759 mergedE=mergedList.get(mergedList.size()-1);
//			Interval759 unsortedH=oriIntervals.get(i);
//			if(mergedE.end<unsortedH.start) {
//				mergedList.add(unsortedH);
//			}else {
//				mergedList.remove(mergedList.size()-1);
//				Interval759 interval=new Interval759(
//						Math.min(mergedE.start, unsortedH.start),
//						Math.max(mergedE.end, unsortedH.end));
//				mergedList.add(interval);
//			}
//		}
//		
//		List<Interval759> res=new ArrayList<>();
//		for(int i=1;i<mergedList.size();i++) {
//			res.add(new Interval759(
//					mergedList.get(i-1).end,mergedList.get(i).start ));
//		}
//		return res;
	}
}

class Interval759 {
    int start, end;
    Interval759(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
    	return "start: "+start+" end: "+end;
    }
}
