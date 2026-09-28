class Solution {
    public boolean canJump(int[] nums) {
        int farthest=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>farthest) return false;
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1) return true;
        }
        return false;
    }

    //-------TLE-------
    // boolean jump(int[] arr,int i)
    // {
    //     if(i==arr.length-1) return true;

    //     for(int j=1;j<=arr[i];j++)
    //     {
    //        if(jump(arr,i+j)){
    //         return true;
    //        }
    //     }
    //     return false;
    // }
}