class Solution {
    public int search(int[] nums, int target) {
        //we need the position of 7 then apply BS two times
        int s=0;
        int e=nums.length-1;
        int mid=-1;
        //find ind of smallest then biggest = pos-1
        while(s<e)
        {
             mid = s+ (e-s)/2;
            if(nums[mid]>nums[e]) //either mid is biggest elem or end is smallest elem; either case move towards right, mid cant be smallest => s=mid+1
            {
                s=mid+1;
            }
            else{
                e=mid; //mid might be the smallest
            }
        }
     mid = s+ (e-s)/2;
        int pos=(mid-1)%nums.length;
           System.out.println(pos);

        //run BS from 0 to pos + BS from pos+1 to end
        s=0;
        e=pos;
        while(s<=e)
        {
           int m=s + (e-s)/2;
            if(target<nums[m])
            {
                e=m-1;
            }
            else if(nums[m]<target)
            {
                s=m+1;
            }
            else{
                return m;
            }   
        }

        s=pos+1;
        e=nums.length-1;
        while(s<=e)
        {
           int m=s + (e-s)/2;
            if(target<nums[m])
            {
                e=m-1;
            }
            else if(nums[m]<target)
            {
                s=m+1;
            }
            else{
                return m;
            }   
        }
        return -1;
        
    }
}