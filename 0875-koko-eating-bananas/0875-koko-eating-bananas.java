class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=0,e=0;
        int sum=0;
        for(int i=0;i<piles.length;i++)
        {
            sum+=piles[i];
            e=Math.max(e,piles[i]);
        }
        s=(int)Math.ceil((double)sum/h);
        System.out.println("s="+s+"e="+e);
        return BS(piles,h,s,e);
    }
    public int BS(int[] piles,int h,int s,int e)
    {
        if(s>e)
        {
            return -1;
        }
        //simulate 
        int h1=0;
        int k=s + (e-s)/2;

        for(int i=0;i<piles.length;i++)
        {
            int bananas=piles[i];
            h1+=(int)Math.ceil((double)bananas/k);
           
           if(h1>h) break;
        }
        
         if(h1<=h)
        {
            int min = BS(piles,h,s,k-1);
            if(min==-1) return k;
            return min;
        }
        
        return BS(piles,h,k+1,e);
    }
}