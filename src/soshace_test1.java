public class test1 {
	public static void main(String[] args){
		test1 t=new test1;
		int[] a=new int[]{1,2,3,4};
		int res=t.getRes(a);
		
		for(int i:res){
			System.out.println(i);
		}
	}	



	public int[] getRes(int[] a){
		
		int[] res=new int[a.length];
		for(int i=0;i<res.lengh;i++){
			int temp=1;
			for(int j=0;j<a.length;j++){
				if(i!=j){
					temp=temp*a[j];
				}
				
			}
			res[i]=temp;
		}

		return res;
	}
}
