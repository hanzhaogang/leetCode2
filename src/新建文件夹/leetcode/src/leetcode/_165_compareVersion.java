package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _165_compareVersion {
	public int compareVersion1(String version1, String version2) {
	    String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? 
	    			Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? 
	    			Integer.parseInt(levels2[i]) : 0;
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
	}

    public int compareVersion(String version1, String version2) {
        List<String> ver1Nums=new ArrayList(Arrays.asList(version1.split("\\.")));
        List<String> ver2Nums=new ArrayList(Arrays.asList(version2.split("\\.")));

        if(ver1Nums.size()<ver2Nums.size()){
            int diff=ver2Nums.size()-ver1Nums.size();
            for(int i=0;i<diff;i++){
                ver1Nums.add("0");
            }
        }
        if(ver2Nums.size()<ver1Nums.size()){
            int diff=ver1Nums.size()-ver2Nums.size();
            for(int i=0;i<diff;i++){
                ver2Nums.add("0");//ver2Nums.size() will be changed here.
            }
        }
        
        int i=0;
        while(i<ver1Nums.size()&&i<ver2Nums.size()){
            int i1=Integer.parseInt(ver1Nums.get(i));
            int i2=Integer.parseInt(ver2Nums.get(i));
            if(i1<i2)
                return -1;
            else if(i2<i1)
                return 1;  
            else
                i++;
        }
        
        return 0;
    }
}
	