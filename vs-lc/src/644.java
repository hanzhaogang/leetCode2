public class 644 {
	
}

class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
    	double l = -10000, r = 10000, mid, ans;
    	while(r-l > 1e-6)
    	{
    		mid = (l+r)/2.0;
    		if(isok(nums, mid, k))
    		{
    			l = mid;
    			ans = mid;
    		}
    		else
    			r = mid;
    	}
    	return ans;
    }
    bool isok(vector<int> nums, double avg, int k)
    {	//存在长度至少为k，且均值 >= avg 吗？
    	double sum = 0, prev = 0, minprev = 0;//前面最小的前缀和0（长度为0时）
    	for(int i = 0; i < k; ++i)
    		sum += nums[i]-avg;//每个数减去平均值，求和 >= 0 存在即ok
    	if(sum >= 0) 
    		return true;
    	for(int i = k; i < nums.size(); ++i)
    	{
    		sum += nums[i]-avg;
    		prev += nums[i-k]-avg;
    		minprev = min(minprev, prev);//前面最小的和（减去avg后的）
    		if(sum-minprev >= 0)//存在区间，使得减去avg后sum>=0
    			return true;
    	}
    	return false;
    }
};

