

class Solution {
    class Job{
    int enq;
    int proc;
    int id;
    public Job(int id,int enq,int proc)
    {
        this.enq=enq;
        this.proc=proc;
        this.id=id;
    }
}
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        Job[] jobs = new Job[n];
       

        for(int i=0;i<n;i++)
        {
            jobs[i]=new Job(i,tasks[i][0],tasks[i][1]);
        }
        // Array => Sort by enqueue time
        Arrays.sort(jobs, (a,b)-> a.enq - b.enq);

        // PQ => asc order of proc time; if proc is same then asc by id 
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a,b)-> a.proc==b.proc ? a.id - b.id : a.proc - b.proc
        );
        int[] ans = new int[n];
        int currTime=0;
        int idx=0,ansIdx=0;

        while(idx<n || !pq.isEmpty())
        {
            // Add all jobs available at current time
            while(idx<n && jobs[idx].enq <= currTime)
            {
                pq.offer(jobs[idx++]);
            }
            // if time is behind => get the time for the curr job
            if(pq.isEmpty()) currTime=jobs[idx].enq;
            else{
                //get the first job
                Job job = pq.poll();
                ans[ansIdx++]=job.id;
                currTime+=job.proc;
            }
            
        }
        return ans;
    }
}
