/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        // if there's no valid BST
        if (n < 1)
            return new ArrayList<>();
        // use recursion to generate all BST
        List<TreeNode> list = buildTree(1, n);
        return list;
    }

    private List<TreeNode> buildTree(int l, int r) {
        List<TreeNode> curList = new ArrayList<>();
        // when the range is not valid
        if (l > r) {
            curList.add(null);
        }
        // pick a root node
        for (int i = l; i <= r; ++i) {
            // compute all possible left and right subtrees
            List<TreeNode> leftTree = buildTree(l, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, r);
            // connect the current root to all subtrees
            for (var left : leftTree) {
                for (var right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    curList.add(root);
                }
            }
        }
        return curList;
    }
}