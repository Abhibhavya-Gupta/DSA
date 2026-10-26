/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int s=0;
        int e=mountainArr.length()-1;
        int m=-1;
        while(true)
        {

            m=s + (e-s)/2;
            int e1=mountainArr.get(m);
            if(m+1 <=e && e1<mountainArr.get(m+1))
            {
                s=m+1;
            }
            else if(m-1>=0 && e1<mountainArr.get(m-1))
            {
                e=m-1;
            }
            else{
                break;
            }
        }
        int peak = m;
        
        //got the peak elem ind
        //res = BS from 0 to peak + BS from peak+1 to e

        s=0;
        e=peak;
        int res1=-1;
        while(s<=e)
        {
            m=s + (e-s)/2;
            int e1=mountainArr.get(m);
            if(target<e1)
            {
                e=m-1;
            }
            else if(e1<target)
            {
                s=m+1;
            }
            else{
                return m;
            }   
        }

        
        s=peak+1;
        e=mountainArr.length()-1;
        int res2=-1;
        while(s<=e)
        {
            m=s + (e-s)/2;
            int e1=mountainArr.get(m);
            if(target<e1)
            {
                s=m+1;
            }
            else if(e1<target)
            {
                e=m-1;
            }
            else{
                return m;
            }   
        }

       return -1;
        


    }
}