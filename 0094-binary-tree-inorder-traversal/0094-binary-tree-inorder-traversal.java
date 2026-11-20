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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> l = new ArrayList<>();
        TreeNode node = root;
        while(node!=null || !s.isEmpty())
        {
            while(node!=null)
            {
                s.push(node);
                node=node.left;
            }
            node = s.pop();
            l.add(node.val);
            node=node.right;
        }
        return l;
    }
}