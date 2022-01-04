public class 1185 {
	public String dayOfTheWeek(int day, int month, int year) {
		String[] week=new String[]{"Sunday", 
			"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		//2100.12.31
		//2:31;3:28:4:31;
		int[] monthDay=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int[] monthPreSum=new int[12];
		for(int i=0;i<12;i++){
			if(i==0){
				monthPreSum=0;
			}else{
				monthPreSum[i]=monthPreSum[i-1]+monthDay[i-1];
			}
		}

		int totalDay=(year-1971)*365+(month-1)	+day;
		return week[(totalDay+5)%7];
    }	
}
