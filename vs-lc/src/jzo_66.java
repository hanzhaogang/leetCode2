public class jzo_66 {
	    public int[] constructArr(int[] a) {
		int n=a.length;
		int[] ml=new int[n];
		int[] mr=new int[n];
		for(int i=0;i<n;i++){
			if(i==0)
				ml[i]=a[i];
			else{
				ml[i]=ml[i-1]*a[i];
			}
		}
		for(int i=n-1;0<=i;i--){
			if(i==n-1)
				mr[i]=a[i];
			else{
				mr[i]=mr[i+1]*a[i];
			}
		}
		int[] res=new int[n];
		for(int i=0;i<n;i++){
			if(i==0){
				if(1<n)
					res[i]=mr[i+1];
				else
					res[i]=1;
			}else if(i==n-1){
				if(n==1)
					res[i]=1;
				else
					res[i]=ml[i-1];
			}else{
				res[i]=ml[i-1]*mr[i+1];
			}
		}
		return res;
    }	
}
