package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.

(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
		0  0  0  0  0  1  1  0
		0  1  1  1  0  0  0  0
		0  0  1  0  0  1  1  0
		0  0  1  0  0  0  0  0
		0  0  1  0  1  1  1  0
		0  0  1  1  0  1  0  0
Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]

 

Note:

    cells.length == 8
    cells[i] is in {0, 1}
    1 <= N <= 10^9
    
    
    11000011
    00011000
    01000010
    01011010
    01100110
    00000000
    01111110
    00111100
    00011000
    
    [1,1,0,1,1,0,1,1]
	11011011
	00100100
	00100100

 */
public class _957_PrisonCellAfterNDays {
	public static void main(String[] args) {
		int[] cells= {1,0,0,1,0,0,1,0};
		int N=1000000000;
		System.out.println(Arrays.toString(new _957_PrisonCellAfterNDays().prisonAfterNDays(cells,N)));
	}
	public int[] prisonAfterNDays(int[] cells, int N) {
		Map<String,Integer> map=new HashMap<>();
		int[] today=cells;
		map.put(Arrays.toString(today),0);
		int mod=0;
		int entry=0;
		int[] entryCell=new int[cells.length];
		for(int i=1;i<=64;i++) {
			int[] tomorrow=getTomorrowPrison(today);
			if(map.containsKey(Arrays.toString(tomorrow))) {
				mod=i-map.get(Arrays.toString(tomorrow));
				entry=i%mod;
				entryCell=tomorrow;
				break;
			}
			map.put(Arrays.toString(tomorrow),i);
			System.out.println(map);
			today=tomorrow;
		}
		System.out.println("mod:"+mod+"entry"+entry+"entryCell:"+Arrays.toString(entryCell));
		
		today=cells;
		if(N<=entry+mod) {
			for(int i=1;i<=N;i++) {
				int[] tomorrow=getTomorrowPrison(today);
				today=tomorrow;
			}
			return today;
		}else {
			N=(N-entry)%mod;
			System.out.println(N);
			today=entryCell;
			for(int i=0;i<=N;i++) {
				int[] tomorrow=getTomorrowPrison(today);
				today=tomorrow;
			}
			return today;
		}
		
	}
	private int[] getTomorrowPrison(int[] today) {
		int[] tomorrow=new int[today.length];
		for(int i=1;i<=6;i++) {
			if(today[i-1]==today[i+1])
				tomorrow[i]=1;
		}
		return tomorrow;
	}
}

class Solution3{
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String,Integer> map=new HashMap<>();
        
        int value;
        if(cells[0]==cells[7]&&cells[7]==0){
            map.put(Arrays.toString(cells),0);
            int[]cur=cells;
            for(int i=1;i<=N;i++){
                int[] next=nextDay(cur);
                if(!map.containsKey(Arrays.toString(next))){
                    map.put(Arrays.toString(next),i);
                }else{
                    break;
                }
            
                cur=next;
           }//find all possible preson states.
            
            value=(N<map.size())?N:N%map.size();
        }else{
            int[]cur=cells;
            for(int i=1;i<=N;i++){
                int[] next=nextDay(cur);
                if(!map.containsKey(Arrays.toString(next))){
                    map.put(Arrays.toString(next),i);
                }else{
                    break;
                }
            
                cur=next;
           }//find all possible preson states.
            
             value=(N<=map.size())?N:N%map.size();//??
            if(value==0) value=map.size();// the value of index is too tricky!!!
        }
        
        
        if(map.size()==1) return nextDay(cells);//count is the map size.
        
       
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue().equals(value)){
                String str=e.getKey();
                str=str.substring(1,str.length()-1);
                String[] resStr=str.split(",");
                int[] res=new int[cells.length];
                for(int i=0;i<resStr.length;i++){
                    res[i]=Integer.valueOf((resStr[i]).trim());
                }
                return res;
            }
                 
        }
        
        return null;
    }
    
    private int[] nextDay(int[] cur){
        int[] nextDay=new int[cur.length];
        for(int i=1;i<cur.length-1;i++){
            if(cur[i-1]==cur[i+1])
                nextDay[i]=1;
            else
                nextDay[i]=0;
        }
        return nextDay;
    }
}

class Solution2 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }
}