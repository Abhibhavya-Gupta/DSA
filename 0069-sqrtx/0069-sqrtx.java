class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        long num=1;
        while((num*num)<x)
        {
            num*=2;
        }
        long s = num/2, e = num;
        
        int ans = (int)BS(x,s,e);
        if(ans*ans <= x) return ans;
        return ans-1;
    }
    public long BS(long x,long s,long e)
    {
        if(s>=e) return s;
        long m=s + (e-s)/2;
        if(m*m < x)
        {
            return BS(x,m+1,e);
        }
        else if(m*m>x)
        {
            return BS(x,s,m-1);
        }
        else{
            return m;
        }
    }
}