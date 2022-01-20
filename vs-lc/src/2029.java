public class 2029 {
	    public boolean stoneGameIX(int[] stones) {//if alice the 1st player can win
		Set<Integer> s0=new HashSet<>();
		Set<Integer> s1=		
    }
    private boolean p1win(int sum,int[] c){
	    /* sum==0,c1 c2至少有一个!=0;
	       sum==1,c0 c1至少一个；c0==0,new sum==2; c1==0,new sum==1;
	       sum==2,c0,c2至少一个；c0==0,new sum==1; c2==0,new sum==2;
	if(c[(sum+1)%3]==0&&c[(sum+2)%3]==0){
		return false;
	}else if(c[(sum+1)%3]==0){
		return !p1win();
	}




    }
}
