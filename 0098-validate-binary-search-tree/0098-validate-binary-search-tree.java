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
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<long[]> b = new ArrayDeque<>();

        q.offer(root);
        b.offer(new long[]{Long.MIN_VALUE,Long.MAX_VALUE});

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                long[] bound = b.poll();
                
                if(node.val<=bound[0] || node.val>=bound[1]) return false;

                if(node.left!=null)
                {
                    q.offer(node.left);
                    b.offer(new long[]{bound[0],node.val});
                }
                
                if(node.right!=null)
                {
                    q.offer(node.right);
                    b.offer(new long[]{node.val,bound[1]});
                }
                
            }
        }
        return true;
    }
}