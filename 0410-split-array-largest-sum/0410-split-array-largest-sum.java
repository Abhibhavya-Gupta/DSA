class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0,e=0;
        for(int i=0;i<nums.length;i++)
        {
            s=Math.max(s,nums[i]);
            e+=nums[i];
        }
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