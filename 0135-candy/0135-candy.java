class Solution {
    public int candy(int[] ratings) {
        //give one candy to each one of them at start
        //now give from highest to lower priority 1 - 1 candy until everyone satisfies
        int total=0;
        int n=ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        total+=n;
        // 0 0 1 1 1 2 2 3 => 0 1 2 3 treemap=> num : list[indicies]
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            int num = ratings[i];
            if(map.containsKey(num))
            {
                map.get(num).add(i);
            }
            else
            {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(num,l);
            }
        }
        boolean start=true;
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            if(start)
            {
                start=false;
                continue;
            }

            for(int i:entry.getValue())
            {
                if(i==0 && 1<n && ratings[0]>ratings[1])
                {
                    candies[0]=candies[1]+1;
                    total++;
                }
                else if(i==n-1 && n-2>=0 && ratings[n-1]>ratings[n-2])
                {
                    candies[n-1]=candies[n-2]+1;
                    total++;
                }
                else if(i>0 && i<n-1)
                {
                    if(ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1])
                    {
                        candies[i]=Math.max(candies[i-1],candies[i+1])+1;
                        total++;
                    }
                    else if(ratings[i]>ratings[i-1] || ratings[i]>ratings[i+1]){ 
                        candies[i]=(ratings[i-1]<ratings[i]?candies[i-1]:candies[i+1])+1;
                    }
                }
                

            }
        }
        total=0;
        for(int e:candies)
        {
            total+=e;
        }
        return total;
        
    }
}