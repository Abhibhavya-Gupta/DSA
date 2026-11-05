class Solution {
    public int findMin(int[] nums) {
    int s = 0;
    int e = nums.length - 1;
    int n=nums.length;

    while (s<e) {
        int m = s + (e - s) / 2;

        if(m+1<n && nums[m]>nums[m+1])
        {
            return nums[m+1];
        }
        else if(m-1>0 && nums[m-1]>nums[m])
        {
            return nums[m];
        }

        if(nums[s]==nums[m] && nums[m]==nums[e])
        {
            if(s+1 < n && nums[s]>nums[s+1])
            {
                return nums[s+1];
            }
            s++;
            if(e-1 > 0 && nums[e-1]>nums[e])
            {
                return nums[e];
            }
            e--;
        }
        else if(nums[m]>nums[e])
        {
            s=m+1;
        }
        else{
            e=m;
        }
    }

    return nums[s]; 

    
}
}
