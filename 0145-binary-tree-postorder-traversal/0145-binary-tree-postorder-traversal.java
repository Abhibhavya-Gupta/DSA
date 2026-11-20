/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<Boolean> vis = new Stack<>();
        List<Integer> l = new ArrayList<>();

        s.push(root);
        vis.push(false); 

        while(!s.isEmpty())
        {
            TreeNode curr=s.pop();
            boolean v = vis.pop();
            if(curr!=null)
            {
                if(v)
                {
                    l.add(curr.val);
                }
                else{
                    s.push(curr);
                    vis.push(true); //would be popped last

                    if(curr.right!=null)
                    {
                        s.push(curr.right); //would be popped second
                    vis.push(false);
                    }
                    
                    if(curr.left!=null)
                    {
                        s.push(curr.left); //would be popped first
                    vis.push(false);
                    }
                    
                }
            }
        }
        return l;
    }
}