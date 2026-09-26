class Solution {
    public int reverse(int x) {
        
        //calc number of digits
        int ans=0;
        int original=x;
        if(original<0) x=x*-1;
        while(x!=0)
        {
            int dig=x%10;
            x/=10;

            //checking before ans becomes some -ve or +ve or random value
            //Int.max_val = 214......47
            //if ans is already = 214....4 then multip it by 10 = 214.....40 and if dig >7 => overflow INT value
            if(ans>Integer.MAX_VALUE/10 || 
            ans==Integer.MAX_VALUE/10 && dig>7)
            {
                return 0;
            }
            //Int.min_val = -214......48
            if(ans<Integer.MIN_VALUE/10 || 
            ans==Integer.MIN_VALUE/10 && dig==-9)
            {
                return 0;
            }
            ans = ans * 10 + dig;
        }
        if(original<0) ans=-1*ans;

    return ans;
    }
}