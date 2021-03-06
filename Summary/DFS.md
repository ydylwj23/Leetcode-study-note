# DFS

## **Description**
DFS stands for Depth First Search, which is also called backtracking. It is a very commonly used search algorithm.

The problem it can solve includes:
- General backtracking problem. 
  -  **Combination**
  -  **Permutation**
  -  **Partition**
  -  **board game placement**
  -  **island problem**
- Tree traverse problem.
  - **Preorder**
  - **Inorder**
  - **Postorder**
- Graph traverse problem.
  - **Graph coloring**
  - **Cycle detection**
  - **Topological sort**
  - **Tarjan**

A very common structure of DFS algorithm consists of 1: visited status holder(optional) 2: base case 3: backtracking case

---

## **Coding example**

### General backtracking problem

General backtracking can be used to solve many problems where decision trees are involved. It basically brutefully traverse through every node on the entire decision tree. Prunning can help reduce general run time or even reduce time complexity. Memoization is also commonly used with backtracking so no duplicated condition would be visited again.\
Time Complexity: O(c ^ n) At each level, we need to make c choices\
Space Complexity: O(c ^ n) Total number of path and contents.
```java
class Solution {
    public List<List<Integer>> backtracking(T[] input) {
        //answer list
        List<List<T>> ans = new List<>();
        //current path
        List<T> path = new List<>();
        //call DFS with initial index
        DFS(index, ...);
        return ans;
    }
    private void DFS(int index, ...){
        //when a condition is satisfied, add the current traversal path result to the final answer list
        if (condition) {
            ans.add(curList);
            return;
        }
        
        //backtracking, start from the first available index
        for(from index to ...){
            //under certain condition, make a choice at the current decision node
            curList.add(x);
            //call backtracking for the decision node
            DFS(index + 1, ...);
            //unmake the the choice
            curList.remove(x);
        }
    }
}
```

#### *Combination*

The combination problems can be solved by backtracking especially when every possible combinations need to be output as part of the result. Note all the constraints of the problem: 1: If there are duplicates in the input. 2: If duplicate numbers can be used in the answer. 3: If there are constrains on the condition of the output list.\
Time Complexity: O(2 ^ n) for backtracking since every element may or may not be placed into a list. O(n) for putting every formed list into the asnwer.\
Space Complexity: O(2 ^ n) to store every single result.
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums, int target) {
        //create the answer list
        List<List<Integer>> ans = new ArrayList<>();
        //sort the input array if there are duplicated numbers
        **Arrays.sort(nums);
        //call DFS with initial states
        DFS(nums, ans, new ArrayList<>(), 0, target);
        return ans;
    }
    private void DFS(int[] nums, List<List<Integer>> ans, List<Integer> list, int index, int target){
        //add the current list to answer in every layer if the target list has no constraints(all subsets)
        **ans.add(new ArrayList<>(list));
        //add the current list to answer only if the constraint is satisfied
        **if (sum == n) {
            ans.add(new ArrayList<>(list));
        }
        
        //backtracking, start from the first available index
        for(int i = index; i < nums.length; i++){
            //when there are duplicates in the input, we have to skip duplicates in the same layer
            **if (i > index && nums[i] == nums[i - 1]) {
                **continue;
            **}
            //add current layer's number
            list.add(nums[i]);
            //index needs to move forward to avoid using the same exact number twice(duplicates are still allowed if there are duplicates in the list)
            **DFS(nums, ans, list, i + 1, target);
            //index doesn't move if using the same exact number in the list is allowed
            **DFS(nums, ans, list, i, target);
            //remove current layer
            list.remove(list.size() - 1);
        }
    }
}
```

#### *Permutation*
Similar to combination problems, but we need keep each element's visited status so we don't repeat the same exact number in the permutation. Also note we don't have to keep the current the index since permutation is all about the order of elements, not their appearance.\
Time Complexity: O(n!) This is the total number of permutation cases\
Space Complexity: O(n!)
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //visit status
        boolean[] visited = new boolean[nums.length];
        //sort the input array if there are duplicated numbers
        **Arrays.sort(nums);
        //call DFS with initial states
        DFS(nums, visited, ans, new ArrayList<>());
        return ans;
    }
    private void DFS(int[] nums, boolean[] visited, List<List<Integer>> ans, List<Integer> list){
        //add the current list to answer only if the constraint is satisfied
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        //backtracking, loop through all neighbors
        for(int i = 0; i < nums.length; i++){
            //skip elements that are visited
            if(visited[i]){
                continue;
            }
            //if there are duplicates in the input, need to skip the duplicates except the very first one encountered in the current layer since the same number can only be used once at the same level
            **if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            //mark as visited
            visited[i] = true;
            //add current layer
            list.add(nums[i]);
            //next layer
            DFS(nums, visited, ans, list);
            //remove current layer
            list.remove(list.size() - 1);
            //unmark as unvisited
            visited[i] = false;
        }
    }
}
```

#### *Partition*
At each backtracking layer, we decide what how many elements from the input go into the current layer's partition.\
Time Complexity: O(2 ^ p) p the total number of partition\
Space Complexity: O(2 ^ p)
```java
class Solution {
    Map<Integer, List<List<String>>> map;
    public List<List<String>> partitionDP(String input) {
        //use hash map to store partition result of substring starting from index i
        map = new HashMap<>();
        //backtracking
        return DFS(input, 0);
    }
    private List<List<String>> DFS(String s, int start){
        //if the current substring result has already been computed
        if(map.containsKey(start)){
            return map.get(start);
        }
        //the division result of substring starting from index "start"
        List<List<String>> res = new ArrayList<>();
        //if the start is out of bound, the list would only contian an empty string(it needs to contain an empty string)
        if(start == input.length()){
            res.add(new ArrayList<>());
        }
        //backtracking
        for(int end = start + 1; end <= input.length(); ++end){
            String curr = input.substring(start, end);
            //if the substring [start, end) is valid
            if(isValid(curr)){
                //get division result from the right substring
                List<List<String>> list = DFS(s, end);
                //for each result from the right substring, we can form a new result for the current layer
                for(var l : list){
                    List<String> copy = new ArrayList<>(l);
                    copy.add(0, curr);
                    ans.add(copy);
                }
            }
        }
        //store current division result
        map.put(start, res);
        return res;
    }
}
```
```java
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        DFS(index, ...);
        return ans;
    }
    private void DFS(int index, ...){
        //if the we have reach the end and under certain condition, we can collect the current parition
        if(reachEnd && condition){
            ans.add(curPartition);
            return;
        }
        //backtracking
        for(int i = index; i < length; i++){
            //extract the current segment substring
            String curString = input.substring(index, i + 1);
            //if the current substring satisfys certain condition, move on to the next call
            if (condition){
                DFS(i + 1, ...);
            }
        }
    }
}
```

#### *board game placement*
At each backtracking layer, we decide where to put a piece on a board, this usually makes some other placement impossible.\
Time Complexity: O(n!) n ways to put the first piece, n - 1 ways for the second piece...\
Space Complexity: O(n) for visited status
```java
class Solution {
    //marks for placement that cannot be picked
    boolean[] marks;
    public List<List<String>> solveNQueens(int n) {
        //answer list
        List<List<String>> ans = new ArrayList<>();
        
        //dfs for all answers
        DFS(index, ...);
        
        return ans;
    }
    //do DFS row by row
    private void DFS(int index, ...){
        //if the we have reach the end and under certain condition, we can collect the current parition
        if(reachEnd && condition){
            ans.add(curPlacement);
            return;
        }
        //backtracking
        for(int i = 0; i < n; i++){
            //check if the new placement is valid
            if(newPlacement == valid){
                marks[x] = true;
                list.add(new String(row));
                //next layer
                DFS(i + 1, ...);
                list.remove(list.size() - 1);
                marks[x] = false;
            }
        }
    }
}
```
#### *island problem*
dfs can traverse an area of cells with certain condition\
Time Complexity: O(m * n) the grid size\
Space Complexity: O(1) if we can modify the grid
```java
class Solution {
    int[] rowDir = new int[] {0, 1, 0, -1};
    int[] colDir = new int[] {1, 0, -1, 0};
    void dfs(char[][] grid, int row, int col) {
        //mark as not conditioned for the search
        grid[row][col] = !condition;
        //dfs on four neighbor cells
        for (int i = 0; i < 4; ++i) {
            int nextRow = row + rowDir[i];
            int nextCol = col + colDir[i];
            //only dfs valid cells that is under certain condition
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == condition) {
                dfs(grid, nextRow, nextCol);
            }
        }
    }
}
```
### Tree traverse problem
DFS can be applied to traverse tree structures. This includes preorder, inorder and postorder. For more details, check Tree summary.\
Time Complexity: O(n) each node gets visited once\
Space Complexity: O(h) tree height in stack
```java
class Solution {
    public void treeTraversal(TreeNode root) {
        DFS(root);
    }
    private void DFS(TreeNode root){
        //base case
        if(root == null) return;
        //recursive case
        **handle(root.val); //preorder
        DFS(root.left);
        **handle(root.val); //inorder
        DFS(root.right);
        **handle(root.val); //postorder
    }
}
```

### Graph traverse problem
DFS is a very common algorithm to be used in graph. Actually, most problems that DFS can solve can be viewed as graph problem, including tree problem. After all, it depth first searches a data structure and visite all nodes where they are connected with each other through some edges. DFS can be used to compute size of the component, check or alter status of a component, check if some nodes are in the same component in an unweighted undirected(occationally directed with pruning, not recommended) graph

Time Complexity: O(n) each node gets visited once\
Space Complexity: O(n) for visited status
```java
class Solution {
    public boolean DFS(Map<Integer, List<Integer>> graph) {
        //store different visit status of each node
        int[] visited = new int[N];
        //try to perform dfs starting from every node in the graph
        for(every node){
            //only start DFS on nodes with certain condition
            if(visited[node] == unvisited) {
                dfs(node);
            }
        }
    }
    private void dfs(curNode){
        //mark current node's status
        visited[curNode] = status;
        //recursively call DFS on all children
        for(every child of curNode){
            //perform dfs on children
            if(visited[child] == unvisited) {
                dfs(child);
            }
        }
    }
}
```
#### *Graph coloring*
DFS can perform graph coloring/bipartite in directed or undirected unweighted graph.
```java
class Solution {
    public boolean bipartite(Map<Integer, List<Integer>> graph) {
        //store different visit status of each node
        int[] color = new int[N];
        //try to perform dfs starting from every node in the graph
        for(every node){
            //only start DFS on nodes with certain condition
            if(color[node] == noColor) {
                if (!dfs(node, color1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(curNode, color){
        //check if the current node has been painted and if the color matches the intended color
        if (color[curNode] != noColor) {
            return color[curNode] == color;
        }
        //paint the current node
        color[curNode] = color1;
        //recursively call DFS on all children
        for(every child of curNode){
            //try paint children with the opposite color
            if (!dfs(node, oppositeOrNext(color))) {
                    return false;
                }
        }
        return true;
    }
}
```
#### *Cycle detection*
DFS can detect cycles in directed unweighted graph when paired with "unvisited, visiting, visted" status.
```java
class Solution {
    public boolean Cycle(Map<Integer, List<Integer>> graph) {
        //store different visit status of each node
        int[] visitStatus = new int[N];
        //try to perform dfs starting from every node in the graph
        for(every node){
            //only start DFS on nodes with certain condition
            if(visitStatus[node] != visited) {
                if (!dfs(node)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(curNode){
        //if we encouter a node that is being visited, we found a cycle
        if (visitStatus[curr] == visiting) {
            return true;
        }
        //mark current node's status as visiting
        visitStatus[curNode] = visiting;
        //recursively call DFS on all children
        for(every child of curNode){
            //only perform dfs on unvisited children
            if(visitStatus[child] != visited) {
                if (dfs(child)) {
                    return true;
                }
            }
        }
        //mark current node as visited
        visitStatus[curr] = visited;
        return false;
    }
}
```
#### *Topological sort*
DFS perform topological sort when used with stack
```java
class Solution {
    //use stack to record reverse order of nodes
    Stack<Integer> stack = new Stack<>();
    public boolean topologicalSort(Map<Integer, List<Integer>> graph) {
        //store different visit status of each node
        int[] visitStatus = new int[N];
        //try to perform dfs starting from every node in the graph
        for(every node){
            //only start DFS on nodes with certain condition
            if(visitStatus[node] != visited) {
                if (dfs(node)) {
                    return hasCycle;
                }
            }
        }
        return reverse(stack.pop());
    }
    private boolean dfs(curNode){
        //if we encouter a node that is being visited, we found a cycle
        if (visitStatus[curr] == visiting) {
            return true;
        }
        //mark current node's status as visiting
        visitStatus[curNode] = visiting;
        //recursively call DFS on all children
        for(every child of curNode){
            //only perform dfs on unvisited children
            if(visitStatus[child] != visited) {
                if (dfs(child)) {
                    return true;
                }
            }
        }
        //mark current node as visited
        visitStatus[curr] = visited;
        //push the current node into the stack in post order
        stack.push(curNode);
        return false;
    }
}
```
#### *Tarjan*
Tarjan treats an undirected graph as a directed one and can find bridges or articulation points in it.
```java
class Solution {
    boolean[] visited;
    int[] id;
    int[] low;
    int idCount = 0;
    **int outEdgeCount;
    //if a node is articulation point
    **isArt = new boolean[n];
    public List<edge> Tarjan(Map<Integer, List<Integer>> graph) {
        //try to perform dfs starting from every node in the graph
        dfs(0, -1);
        **//if the the starting node has more than one out going node, it's an articulation point
        **isArt[0] = outEdgeCount > 1;
    }
    private void dfs(curNode, parent){
        **//update origin point's out going edge count
        **if(parent == 0) outEdgeCount++;
        //update current node's id, low-link value and visited state
        id[cur] = idCount++;
        visited[cur] = true;
        low[cur] = id[cur];
        //recursively call DFS on all possible children
        for(every child of curNode){
            //cannot go back to parent
            if(child == parent) continue;
            //if the child is not visited, it's a forward edge
            if(!visited[to]){
                //recursion
                DFS(graph, to, cur);
                //update low-link value
                low[cur] = Math.min(low[cur], low[to]);
                //if current node's id is smaller than child's low-link value, it means there's no backward edge to the current node's component if the bridge is to be cut. And the current node is an articulation point
                if(id[cur] < low[to]){
                    bridge.add(currentEdge);
                    **isArt[cur] = true;
                }
                **//articulation point found via cycle
                **if(id[cur] == low[to]){
                    **isArt[cur] = true;
                **}
            }
            //if the child is visited, it's a backward edge
            else{
                //update low-link value
                low[cur] = Math.min(low[cur], id[to]);
            }
        }
    }
}
```
#### *Eulerian Path*
The algorithm to build the Eulerian path is a greedy post-order tree traversal algorithm where each node only has two nodes. It is based on the fact that there's always a possible Eulerian path.
```java
class Solution {
    public List<String> EulerianPath(edges, source) {
        //build the graph using hashmap and priority queue
        Map<T, PriorityQueue<T>> graph = new HashMap<>();
        for(all edges){
            graph.computeIfAbsent(from, x -> new PriorityQueue<>()).add(to);
            graph.computeIfAbsent(to, x -> new PriorityQueue<>());
        }
        //use recursion to travser the graph in post order like a tree
        postOrder(source);
        //reversed the traverse result is the right order of Eulerian Path
        Collections.reverse(list);
        return list;
    }
    public void postOrder(curNode){
        PriorityQueue<T> children = graph.get(curNode);
        //the priority queue helps to use greedy order to recursively visit children
        while(!children.isEmpty()){
            //every visited child is polled from the heap
            postOrder(children.poll());
        }
        //post order to add traverse result
        list.add(cur);
    }
}
```