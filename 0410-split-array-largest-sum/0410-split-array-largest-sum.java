class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0,e=0;
        for(int i=0;i<nums.length;i++)
        {
            s=Math.max(s,nums[i]);
            e+=nums[i];
        }
         //start matlab minimum value(max number in case of k=n) and end matlab maximum value(sum of nums in case of k=1) 
        //inke beech m hi ans exixts
        //so here we will take mid as our ans everytime and reverse engineer the partition sub-arrays accordingly via Binary Search
        
        return BS(nums,k,s,e);
        
    }
    public int BS(int[] nums,int k,int s,int e)
    {
        if(s==e)
        {
            return s;
        }
        int p=0;
        int i=0;
        List<List<Integer>> l = new ArrayList<>();
        int mid = s + (e-s)/2;
        
        while(i<nums.length)
        {
            l.add(new ArrayList<>());
            int sum=0;
            while(i<nums.length)
            {
                sum+=nums[i];
                if(sum>mid) break;
               
                l.get(p).add(nums[i++]);
                
            }
            p++;
        }
        if(p<=k)
        {
            return BS(nums,k,s,mid);
        }
        return BS(nums,k,mid+1,e);
    }
}
