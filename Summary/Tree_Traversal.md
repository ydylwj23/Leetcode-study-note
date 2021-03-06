## Keyword
Tree Traversal

## Problem description
```
Tree Traversal:
DFS: Preorder; Inorder; Postorder. Each can be done in recursion, iteration(stack) or Morris(O(1) space)
BFS: Can be done in iteration(queue)
```
### DFS: 
## Preorder
# recursion
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        //base case
        if(root == null) return;
        //recursive case
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }
}
```
# iteration
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //use stack for iteration
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            //skip empty nodes
            if(cur == null) continue;
            ans.add(cur.val);
            //reverse the add order to right -> left so the traverse order is left -> right
            stack.add(cur.right);
            stack.add(cur.left);
        }
        return ans;
    }
}
```
# Morris O(1) space
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //start the algorithm from the root
        TreeNode cur = root;
        //stop the algorithm when the current node is null
        while(cur != null){
            //if current's left is null, go output it and move to the right
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                //search for the predecessor
                TreeNode predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }
                //if no loop is found
                if(predecessor.right == null){
                    //link to the current node
                    predecessor.right = cur;
                    //output the current node
                    ans.add(cur.val);
                    //move on with the search to the left
                    cur = cur.left;
                }
                //if loop is found
                else{
                    //remove the link
                    predecessor.right = null;
                    //move on with the search to the right
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
```

## Inorder
# recursion
```java
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        //base case
        if(root == null) return;
        //recursive case
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
}
```
# iteration
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        //Initialize the stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //iterate through the tree using stack
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //node is going to be popped when it's left branch is fully traversed
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
```
# Morris O(1) space
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //start the algorithm from the root
        TreeNode cur = root;
        //stop the algorithm when the current node is null
        while(cur != null){
            //if current's left is null, go output it and move to the right
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                //search for the predecessor
                TreeNode predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }
                //if no loop is found
                if(predecessor.right == null){
                    //link to the current node
                    predecessor.right = cur;
                    //move on with the search to the left
                    cur = cur.left;
                }
                //if loop is found
                else{
                    //remove the link
                    predecessor.right = null;
                    //output the current node
                    ans.add(cur.val);
                    //move on with the search to the right
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
```

## Postorder
# recursion
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        //base case
        if(root == null) return;
        //recursive case
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }
}
```
# iteration
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //use stack to traverse by iteration
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null) continue;
            //insert the answer in the reverse order
            ans.add(0, cur.val);
            //add children in the reverse order of preorder
            stack.add(cur.left);
            stack.add(cur.right);
        }
        return ans;
    }
}
```
# Morris O(1) space
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //start the algorithm from the root
        TreeNode cur = root;
        //stop the algorithm when the current node is null
        while(cur != null){
            //if current's left is null, go output it and move to the right
            if(cur.right == null){
                ans.add(0, cur.val);
                cur = cur.left;
            }
            else{
                //search for the predecessor
                TreeNode predecessor = cur.right;
                while(predecessor.left != null && predecessor.left != cur){
                    predecessor = predecessor.left;
                }
                //if no loop is found
                if(predecessor.left == null){
                    //link to the current node
                    predecessor.left = cur;
                    //output the current node
                    ans.add(0, cur.val);
                    //move on with the search to the right
                    cur = cur.right;
                }
                //if loop is found
                else{
                    //remove the link
                    predecessor.left = null;
                    //move on with the search to the left
                    cur = cur.left;
                }
            }
        }
        return ans;
    }
}
```