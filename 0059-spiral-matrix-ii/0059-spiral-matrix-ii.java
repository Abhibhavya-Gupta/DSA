class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int m=matrix.length;
        boolean[][] vis = new boolean[m][n];
        for(boolean[] r:vis) Arrays.fill(r,false);
        int r=0,c=0;
        int num=1;

        while(r<m && c<n && r>=0 && c>=0 && !vis[r][c])
        {
            while(c<n && !vis[r][c])
            {
                matrix[r][c]=num++;
                vis[r][c]=true;
                c++;
                
                if( c==n || vis[r][c]) 
                {
                    c--;
                    r++;
                    break;
                }
            }
            
            while( r<m && c<n && r>=0 && c>=0 && !vis[r][c])
            {
                matrix[r][c]=num++;
                vis[r][c]=true;
                r++;

                if(r==m|| vis[r][c] ) 
                {
                    c--;
                    r--;
                    break;
                }
            }
            
            while(r<m && c<n && r>=0 && c>=0 && !vis[r][c])
            {
                matrix[r][c]=num++;
                vis[r][c]=true;
                c--;
                if(c==-1 || vis[r][c]) 
                {
                    c++;
                    r--;
                    break;
                }
            }
            
            while(r<m && c<n && r>=0 && c>=0 && !vis[r][c])
            {
                matrix[r][c]=num++;
                vis[r][c]=true;
                r--;
                if(vis[r][c]) 
                {
                    c++;
                    r++;
                    break;
                }
            }
            
        }
        return matrix;
    }
}