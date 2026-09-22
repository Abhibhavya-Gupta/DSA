class Solution {
    public int leastInterval(char[] tasks, int n) {
        //konsa char(process) kitni bar aaya hai uska pata hona chahiye
        int[] freq = new int[26];
        PriorityQueue<Task> pq= new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(char c: tasks)
        {
            freq[c-65]++;
        }
        for(int i=0; i<26;i++)
        {
            char c=(char)('A'+i);

            if(freq[i]>0)
            pq.offer(new Task(c,freq[i]));
        }
        int time=0;
        while(!pq.isEmpty())
        {
            int cycle=n+1;
            List<Task> l = new ArrayList<>();
            int taskCount=0;

            while(cycle-- >0 && !pq.isEmpty())
            {
                Task task=pq.poll();
               
                if(task.freq>1)
                {
                    task.freq--;
                    l.add(task);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            l.forEach(pq::offer);

            time+= pq.isEmpty()?taskCount:n+1;

        }
        return time;
    }
}

class Task{
    char id;
    int freq;
    public Task(char id,int freq)
    {
        this.id=id;
        this.freq=freq;
    }
}