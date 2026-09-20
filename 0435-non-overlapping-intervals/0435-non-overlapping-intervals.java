class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort acc to end time
        int n=intervals.length;
        int ans=0;
        Interval[] myIntervals = new Interval[n];
        for(int i=0;i<n;i++)
        {
            myIntervals[i]=new Interval(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(myIntervals, (a,b)-> a.end - b.end);
        for(int i=0;i<n-1;i++)
        {
            if(myIntervals[i].end>myIntervals[i+1].st)
            {
                myIntervals[i+1]=myIntervals[i];
                ans++;
            }
        }
        return ans;
    }
}
class Interval{
    int st;
    int end;
    public Interval(int st,int end)
    {
        this.st=st;
        this.end=end;
    }
}