public class _278_firstBadVersion {
}

   public class Solution extends VersionControl {//套用模板，模板不判断mid即查找目标，直接返回mid的情况
    public int firstBadVersion(int n) {
        int l = 1 , r = n;
        while (l < r){
         int mid = l+(r-l)/2;
         if (!isBadVersion(mid)) 
             l = mid + 1;
         else 
             r = mid;
        }
        return l;
    }

  }