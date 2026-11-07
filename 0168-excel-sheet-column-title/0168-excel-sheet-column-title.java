class Solution {
    public String convertToTitle(int columnNumber) {
        String s="";
        int n=columnNumber;
        while(n>0)
        {
            int rem = n%26==0?26:n%26;

            s =  ""+(char)(rem+64) + s;
           n =  n%26!=0?n/26: (n/26) -1;
        }
        return s;
    }
}