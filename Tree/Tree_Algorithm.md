## Keyword
Tree

## Problem description
```
Common algorithm for tree problems: 

1. traversal: use proper traverse order to traverse the tree, usually need to maintain global status or pass status using parameters.

2. divide and conquer: each subtree will return something for the parent.


Common type of problems in tree:

Depth problem: traverse the tree and use global variable to manage current max depth

Special order traversal: 1. BFS is good for level by level order. 2. Mix use of preorder, inorder, postorder DFS

Modify tree structue: Divide and Conquer, return modified subtree structure

Path sum problem: 1. Number or collection of path sum: DFS backtracking. 2. Min Max path sum: Divide and conquer, we need to determine each subtree contribution and update the global variables

Lowest Common Ancestor: Divide and conquer

BST: 1. divide and conquer: use the property of BST to locate a number in O(H) time. 2. inorder traversal: In a BST, inorder traversal should always be ascending order. 3. Implement API: Isvalid(), Contains(), Insert(), Delete()

Construct a tree from traversal list: 1. Two order list: Use the order of the list to construct, and hashmap to query the other list for a range of index. 2. Preorder + BST: Use preorder to construct the tree, pass value range as parameters to determine if a node should be inserted at a location.

Serialize and Deserialize Binary Tree: 1. To separate each node in the serialized form, We need delimiters. 2. To store info about the tree structure, we also need to include null node. 3. We can encode integer to 4 bytes instead of string to save space. 4. For a BST, we don't need to mark null to store tree structure info. If we encode integer to 4 bytes so they are unisize, we won't need delimiters either.

```
### Traversal: 
## DFS
# Preorder
```java
class Solution {
    //global variables
    int maxLevel;
    int sum;
    public int deepestLeavesSum(TreeNode root) {
        maxLevel = 0;
        sum = 0;
        //pass status as parameters
        helper(root, 1);
        return sum;
    }
    private void helper(TreeNode root, int level){
        //base case
        if(root == null) return;
        //update global variables
        if(level > maxLevel){
            maxLevel = level;
            sum = 0;
        }
        if(level == maxLevel) sum += root.val;
        //preorder traversal
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
```

# Inorder
```java
class Solution {
    //global variables
    Integer last = null;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }
    private void helper(TreeNode root){
        //base case
        if(root == null) return;
        //inorder traversal
        helper(root.left);
        //update global variables, note here we use Integer becuase "null" can give a uninitiated status
        if(last != null){
            ans = Math.min(ans, root.val - last);
        }
        last = new Integer(root.val);
        helper(root.right);
    }
}
```

## BFS
```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //use to queue to store level nodes
        Queue<TreeNode> nodes = new LinkedList<>();
        //initial node and depth
        nodes.add(root);
        int curDepth = 1;
        //BFS the tree
        while(!nodes.isEmpty()){
            LinkedList<Integer> current = new LinkedList<>();
            int levelSize = nodes.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = nodes.poll();
                if(node != null){
                    //add from last when depth is even
                    if(curDepth % 2 == 0) current.addFirst(node.val);
                    else current.addLast(node.val);
                    //only add non null nodes
                    if(node.left != null) nodes.add(node.left);
                    if(node.right != null) nodes.add(node.right);
                }
            }
            //only add the current list to the ans when it's not empty(corner case)
            if(!current.isEmpty()) ans.add(current);
            //update depth
            curDepth++;
        }
        return ans;
    }
}
```

## Notes
Traversal: Use proper traverse order to traverse the tree, usually need to maintain global status or pass status using parameters

### Divide and Conquer: 
## Collect info from both subtrees
```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        //divide and conquer
        return helper(root) >= 0;
    }
    private int helper(TreeNode root){
        //base case
        if(root == null) return 0;
        //get subtree heights from children
        int left = helper(root.left);
        int right = helper(root.right);
        //-1 means the subtree is not balanced
        if(left < 0 || right < 0) return -1;
        //compare subtree heights to report an unbalance or the current tree height
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
```

## Change tree structure
```java
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return root;
    //divide and conquer
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    //return a node to represent the entire subtree after changes
    return (root.val == 1 || root.left != null || root.right != null) ? root : null;
  }
}
```

## Notes
Divide and conquer: Each child subtree will return something for its parent. Some logic will be done on the parent level, then the parent will return new info to its parent.

### Common problems: 

## Traversal
```java
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        trim(root);
        return ans;
    }
    private int trim(TreeNode root){
        //base case
        if(root == null) return -1;
        //compute current node's level in relation to its subtree's furthest bottom
        int level = 1 + Math.max(trim(root.left), trim(root.right));
        //add more list to the ans
        if(ans.size() <= level) ans.add(new ArrayList<>());
        //output current level's val to corresponding level
        ans.get(level).add(root.val);
        //root.left = root.right = null;
        return level;
    }
}
```
## Notes
Use proper order to traverse the tree, collect info with global variables or passed down parameters

## Max Path Sum
```java
class Solution {
    //global variable
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return this.maxSum;
    }
    private int helper(TreeNode root){
        //base case
        if(root == null) return 0;
        //calculate left and right children's best contribution
        int leftMax = Math.max(helper(root.left), 0);
        int rightMax = Math.max(helper(root.right), 0);
        //calculate the max path sum when connecting left and right branch through node
        int maxLeftRight = leftMax + rightMax + root.val;
        //update the total max path sum
        this.maxSum = Math.max(maxLeftRight, this.maxSum);
        //return the current tree's best contribution
        return Math.max(leftMax + root.val, rightMax + root.val);
    }
}
```
## Notes
Use divide and conquer get the sum contribution from each substree, then update the global variable accordingly. Note contribution cannot be less than 0.

## Lowest Common Ancestor
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null) return null;
        //if the current node is one of the targets, we return the current node
        if(root == p || root == q) return root;
        //if the current node's both subtrees return a node, it means the current node is LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        //return whichever subtree that returns a node
        if(left != null) return left;
        if(right != null) return right;
        //this node cannot be LCA if both subtrees don't return nodes
        return null;
    }
}
```

## Notes
Use divide and conquer to find return the nearest target node from both subtrees. Return the node itself if its both subtrees contain target nodes.

## Change tree structure
```java
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return root;
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    return (root.val == 1 || root.left != null || root.right != null) ? root : null;
  }
}
```

## Notes
Use Divide and Conquer, return modified subtree structure