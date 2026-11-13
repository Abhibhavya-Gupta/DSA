class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target, new ArrayList<>(),0);
        return ans;
    }
    public void helper(int[] cand,int t,List<Integer> list,int index)
    {
        if(t==0)
        {
            
            List<Integer> list1 = new ArrayList<>(list);
            //if we do not create a new List here then due to multiple ref. of list object, if we modify list in any recursion call => the ans will be modified
            //Here we are creating a SHALLOW COPY of list object => list and list1 are two diff heap objects
            ans.add(list1);
        }
        if(t<=0 || index>=cand.length)
        {
            return;
        }
        for(int i=index;i<cand.length;i++){
            list.add(cand[i]);

            helper(cand,t-cand[i],list,i);

            //undo the change ( ie remove the elem which we added before the recursion) => Backtracking
            list.remove(list.size()-1);

        }
    }
    }
