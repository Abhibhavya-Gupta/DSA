class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Freq> pq = new PriorityQueue<>((a,b)-> b.f-a.f);
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            pq.offer(new Freq(entry.getKey(),entry.getValue()));
        }
        String s1="";
        while(pq.size()>0)
        {
            Freq obj = pq.poll();
            s1+=obj.c;
            obj.f--;
            
            Freq obj1=null;
            if(!pq.isEmpty())
            {
            obj1 = pq.poll();
            s1+=obj1.c;
            obj1.f--;
            }
            if(obj.f>0) pq.offer(obj);
            if(obj1!=null && obj1.f>0) pq.offer(obj1);

        }
        for(int i=1;i<s1.length();i++)
        {
            if(s1.charAt(i)==s1.charAt(i-1))
            {
                return "";
            }
        }
        return s1;
    }
}
class Freq{
    char c;
    int f;
    public Freq(char c,int f){
        this.c=c;
        this.f=f;
    }
}