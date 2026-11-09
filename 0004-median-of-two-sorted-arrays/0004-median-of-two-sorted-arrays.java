class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //making sure that 1st array( ie X array) is smaller or equal in size than 2nd array
        if(nums1.length>nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int len1 = nums1.length, len2 = nums2.length;
        int left =0, right = len1;

        while(left<=right)
        {
            int part1 = (left+right)/2;
            int part2 = (len1 + len2 + 1)/2 - part1;
            //leftsize = part1 + part2 => (l1 + l2 + 1)/2

            //left part indicies = x1, y1
            int x1 = (part1==0)?Integer.MIN_VALUE : nums1[part1-1];
            int y1 = (part2==0)?Integer.MIN_VALUE : nums2[part2-1];

            //right part indicies = x2, y2
            int x2 = (part1==len1)?Integer.MAX_VALUE : nums1[part1];
            int y2 = (part2==len2)?Integer.MAX_VALUE : nums2[part2];

            if(x1<=y2 && y1<=x2)
            {
                if((len1+len2)%2==0)
                {
                    return ((double)Math.max(x1,y1)+(double)Math.min(x2,y2))/2;
                }
                return (double)Math.max(x1,y1);
            }
            else if(x1>y2)
            {
                //move in X array towards the left of part1
                right = part1-1;
            }
            else{
                // y1>x2
                // move in X array towards the right of part1
                left=part1+1;
            }

        }
        return 0.0;
    }
}
