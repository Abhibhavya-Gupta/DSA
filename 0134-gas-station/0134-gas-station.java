class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int tank =0,start=0;
       int total=0;
       for(int i=0;i<gas.length;i++)
       {
        int net_gas=gas[i]-cost[i];
        total+=net_gas;
        tank+=net_gas;
        if(tank<0)
        {
            //cant reach next station from here
            tank=0;
            start=i+1;
        }
        
       }
       return total>=0?start:-1;
    }
  
}