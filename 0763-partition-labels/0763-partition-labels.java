class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();//pehla character aur uska last occurence index
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        //we get last occ. of every char
        //now start with first char of every partition and check its last occ.
        int k=0;
        List<Integer> ans = new ArrayList<>();
        int size=0,end=0;
        while(k<s.length())
        {
            size++;
            end=Math.max(end,map.get(s.charAt(k)));
            if(k==end)
            {
                ans.add(size);
                size=0;
            }
            k++;
        }
        return ans;

    }
}