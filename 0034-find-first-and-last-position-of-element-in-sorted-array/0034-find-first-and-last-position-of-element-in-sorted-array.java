class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0
        || target>nums[nums.length-1]
        || target<nums[0]) return new int[]{-1,-1};
        /**
            aplly BS 2 times :
            1st time to get the first posn
            2nd time -> last posn
         */ 
         int[] ans = new int[2];
         ans[0]=bsFirst(nums,target);
         ans[1]=bsLast(nums,target);
         return ans;
        
    }

    public int bsFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
          
            int mid = start + (end - start) / 2;

            if (target < arr[mid] || arr[mid]==target) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }
        return arr[start]==target?start:-1;
    }

     public int bsLast(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
          
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid] || arr[mid]==target) {
                start = mid + 1;
            }
        }
         return arr[end]==target?end:-1;
    }
}