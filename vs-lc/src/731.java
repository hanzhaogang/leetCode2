import java.util.ArrayList;
import java.util.List;

public class 731 {
	
}

class MyCalendarTwo {
    List<Integer> list; 
    public MyCalendarTwo() {
        list=new ArrayList<Integer>();
    }
    
    public boolean book(int start, int end) {
        int n=list.size();
        for(int i=0;i<n;i++){
            if(start<=Math.abs(list.get(i))){
                list.add(i,start);
                break;
            }
        }
        if(list.size()==n)
            list.add(start);
        n=list.size();
        for(int i=0;i<n;i++){
            if(Math.abs(end)<Math.abs(list.get(i))){
                list.add(i,0-end);
            }
        }
        if(list.size()==n)
            list.add(0-end);
        n=list.size();
        int c=0;
        for(int i=0;i<n;i++){
            if(0<=list.get(i))
                c++;
            else 
                c--;
            if(3<=c){
                list.remove((Integer)start);
                list.remove((Integer)end);
                return false;
            }
        }
        return true;
    }
}