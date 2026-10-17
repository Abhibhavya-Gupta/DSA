class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] projects = new int[n][2];

        for (int i = 0; i < projects.length; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0])); //capital by asc

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max heap for profit that we can get at current capital

        int idx=0;
       for(int i=0;i<k;i++)
       {
        //unlock all the projects we can afford
        while(idx<n && projects[idx][0]<=w)
        {
            pq.offer(projects[idx][1]);
            idx++;
        }

        //if our capital is less than needed for further projects 
        if(pq.isEmpty()) break;

        w+=pq.poll();
       }

        return w;
    }
}

class Pair {
    int p;
    int c;

    public Pair(int p, int c) {
        this.p = p;
        this.c = c;
    }
}