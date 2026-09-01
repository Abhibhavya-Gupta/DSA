class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int bal=0;
        for(int i=0;i<s.length();i++)
        {
            String c = s.substring(i,i+1);
            if(bal==0 && c.equals("("))
            {
                bal++;
                continue;
            }
            else if(bal==1 && c.equals(")"))
            {
                bal--;
                continue;
            }
            if(c.equals("(")) bal++;
            else bal--;

            sb.append(c);
        }
        return sb.toString();
    }
}