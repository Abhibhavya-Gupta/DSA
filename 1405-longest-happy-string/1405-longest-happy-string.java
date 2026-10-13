class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] cnt = {a,b,c};
        StringBuilder sb = new StringBuilder();
        boolean added=true;
        while(added)
        {
            added = false;
            Integer[] idx={0,1,2};
            Arrays.sort(idx,(x,y)->cnt[y]-cnt[x]);
            for(int i:idx)
            {
                if(cnt[i]==0) break;

                char ch = (char)('a'+i);
                int n=sb.length();
                if(n>=2 && sb.charAt(n-1)==ch && sb.charAt(n-2)==ch)
                 continue;

                 sb.append(ch);
                 cnt[i]--;
                 added=true;
                 break;
            }

        }
        return sb.length()==0?"":sb.toString();
    }
}