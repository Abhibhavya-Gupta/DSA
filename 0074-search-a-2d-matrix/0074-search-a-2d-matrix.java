class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=matrix.length*matrix[0].length;
        return BS(matrix,target,0,l-1);
    }
    public boolean BS(int[][] matrix, int t,int l,int h)
    {
        if(l>h)
        {
            return false;
        }
        int m= l + (h-l)/2;
        int r=m/matrix[0].length;
        int c=m%matrix[0].length;
        if(t<matrix[r][c])
        {
            return BS(matrix,t,l,m-1);
        }
        else if (t>matrix[r][c]){
           return BS(matrix,t,m+1,h);
        }
        else{
            return true;
        }
    }
}