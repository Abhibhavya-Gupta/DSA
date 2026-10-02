class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;

        Arrays.sort(hand);
        for(int i=0;i<n;i++)
        {
            int idx=i;
            int size=groupSize;
            while(idx<n && hand[idx]==-1) 
            {
                idx++;//get starting index
            }
            if(idx==n) return true;

            int num=hand[idx];
            hand[idx]=-1;
            idx++;
            size--;
            while(idx<n && size>0)
            {
                if(hand[idx]==num+1) 
                {
                    size--;
                    num++;
                    hand[idx]=-1;
                }
                idx++;
            }
            if(size>0) return false;

        }
        return true;
    }
}