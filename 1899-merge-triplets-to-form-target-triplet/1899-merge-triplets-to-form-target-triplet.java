class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] ans=new boolean[3];
        for(int i=0;i<triplets.length;i++)
        {
            if(triplets[i][0]<=target[0] && 
            triplets[i][1]<=target[1] && 
            triplets[i][2]<=target[2])
            {
                if(triplets[i][0]==target[0]) ans[0]=true;
                if(triplets[i][1]==target[1]) ans[1]=true;
                if(triplets[i][2]==target[2]) ans[2]=true;
            }
        }
        return ans[0] && ans[1] && ans[2];
    }
}