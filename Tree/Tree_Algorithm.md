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

Serialize and Deserialize Binary Tree: 1. To separate each node in the serialized form, We need delimiters. 2. To store info about the tree structure, we also need to include null node. 3. We can encode integer to 4 bytes instead of string to save space.

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