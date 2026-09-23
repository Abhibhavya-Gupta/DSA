class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> ans = new ArrayList<>();
        int n=intervals.length;
        Interval[] myIntervals = new Interval[n];
        for(int i =0;i<n;i++)
        {
            myIntervals[i]=new Interval(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(myIntervals, (a,b)-> a.st - b.st);
        
        for(int i=0;i<n-1;i++)
        {
            Interval prev = myIntervals[i];
            Interval curr = myIntervals[i+1];
            if(prev.end>=curr.st) //over
            {
                curr.st=Math.min(curr.st,prev.st);
                curr.end=Math.max(curr.end,prev.end);
            }
            else{
                ans.add(prev);
            }
        }
        ans.add(myIntervals[n-1]);
        int[][] finalArray=new int[ans.size()][2];
        int k=0;
        for(Interval i:ans)
        {
            finalArray[k][0]=i.st;
            finalArray[k][1]=i.end;
            k++;
        }
        return finalArray;
    }
}
class Interval{
    int st,end;
    public Interval(int st,int end)
    {
        this.st=st;
        this.end=end;
    }
}