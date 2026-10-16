class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
      int[] dist=new int[1001];
      for(int[] trip:trips)
      {
        dist[trip[1]]+=trip[0]; // people board at start posn 
    
        dist[trip[2]]-=trip[0]; // people depart at end posn 
      }

      int curr=0;

      for(int i=0;i<dist.length;i++)
      {
        curr+=dist[i];
        if(curr>capacity) return false;
      }
      return true;
    }
}