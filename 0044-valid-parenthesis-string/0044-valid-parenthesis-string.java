class Solution {
    int n;
    String str;
    Boolean[][] dp;
    public boolean checkValidString(String s) {
       n=s.length();
       dp = new Boolean[n][n];
       str=s;
       return backtrack(0,0);

    }
    boolean backtrack(int i, int bal)
    {
        if(bal<0) 
       {
        return false;
       }
        
        if(i==n) 
        {
            return bal==0;
        }
       
        if(dp[i][bal]!=null)
        {
            return dp[i][bal];
        }


         if(str.charAt(i)=='(')
         {
          dp[i][bal] = backtrack(i+1,bal+1);
         }
          else if(str.charAt(i)==')')
          {
          dp[i][bal] = backtrack(i+1,bal-1);
         }
         else{
            dp[i][bal]=backtrack(i+1,bal+1) 
            || backtrack(i+1,bal-1)
            || backtrack(i+1,bal);
         }
          
          return dp[i][bal];

    }
}