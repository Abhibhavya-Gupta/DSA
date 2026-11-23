class Solution {
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {

        //ini src node

        List<int[]> [] graph = new ArrayList[n];
        //[ [ [] [],... ], [ [] [],... ], ... ]
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        long[] ans = new long[n];
        Arrays.fill(ans,-1);
        ans[0]=0;// 0th node is visited at t=0

        int[] received = new int[n]; // show no. of received signals to a particular node
        Arrays.fill(received,0);

        for(int[] e:edges)
        {
            graph[e[0]].add(new int[]{e[1],e[2]}); //adding nei for every node
        }

        //min heap acc to delay time
        PriorityQueue<long[]> pq = new PriorityQueue<>(
           (a,b) -> Long.compare(a[0],b[0]));

        for(int[] nei : graph[0])
        {
            pq.offer(new long[]{nei[1],nei[0]}); // (delay,node)
        }

        while(!pq.isEmpty())
        {
            long[] curr = pq.poll(); //curr node k sabse nearest nei node chahiye

            long time = curr[0]; //nei node tak jaane ka time from starting node
            int node = (int)curr[1]; // nei node

            //ne node is our curr node as we are operating on this node only

            if(ans[node]!=-1) continue;

            received[node]++;

            if(received[node]>=requiredSignals[node]) // check if node is satisfied
            {
                ans[node]=time;

                // now node is satisfied then only now we will see its nei nodes

                for(int[] nei:graph[node]) //satisfied node will send signal now to its every nei thats why add them in pq also 
                {
                    int next = nei[0]; 
                    int delay = nei[1];

                   pq.offer(new long[]{time + delay ,next}); 
                }
            }

        }
        return ans;
        
    }
}