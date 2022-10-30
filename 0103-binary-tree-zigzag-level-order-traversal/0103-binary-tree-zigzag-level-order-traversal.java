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
     static void traverse(TreeNode node, List<List<Integer>> arr) {

        if (node.left == null && node.right == null) {
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(node.val);
            arr.add(sub);
            return;
        }
		
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        int level = 0;
        while (!q.isEmpty()) {
			
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.peek();
                if (n.left != null)     q.add(n.left);
                if (n.right != null)    q.add(n.right);
                sub.add(n.val);
                q.poll();
            }
			
            if (level % 2 != 0)     Collections.reverse(sub);
            arr.add(sub);
            level++;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        List<List<Integer>> zigZag = new ArrayList<>();
        if (root == null)
            return zigZag;
        traverse(root, zigZag);
        return zigZag;
    }
}

