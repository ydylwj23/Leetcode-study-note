# BFS

## **Description**
BFS stands for Breadth First Search. It is a very commonly used search algorithm.

The problem it can solve includes:
- General backtracking problem.
  - **Find shortest path**
  - **island problem**
- Tree traverse problem.
  - **Level order traversal**
- Graph traverse problem.
  - **Graph coloring**
  - **Cycle detection**

A very common structure of BFS algorithm consists of 1: visited status holder 2: queue to hold the current layer result and a step counter 3: While loop which stops if queue is empty or target is found

---

## **Coding example**

### General BFS problem

BFS is commonly used to find the shortest path between pointes or two groups.\
Time complexity: O(n) We might need to visit every single element\
Space complexity: O(n) All elements might be in the same layer
```java
class Solution {
    public int backtracking(group) {
        //A hashmap or array to mark visited points
        Set<Integer> seen = new HashSet<>();
        //An queue to keep points of one layer of search
        Queue<Integer> q = new LinkedList<>();
        //start the search with some points
        q.add(start);
        seen.add(start);
        //keep track of steps
        int step = 0;
        //BFS loop
        while(!q.isEmpty()){
            //one layer a time
            for(int size = q.size(); size > 0; --size){
                //work on each point
                int cur = q.poll();
                //the current point might be the target point
                if (cur == target) {
                    return step;
                }
                //add more connected, unvisited points for next layer of search
                for(every connected points){
                    //only add unvisited points
                    if(!seen.contains(next)){
                        q.add(next);
                        seen.add(next);
                    }
                }
            }
            //update step
            ++step;
        }
        //search fails
        return -1;
    }
}
```

#### *Find shortest path*

When needed, BFS can be used to record all shortest path to a target point, the key difference is about how to handle the cases where multiple points lead to the same next one. Since we are building the path edges as we do BFS, we cannot just skip visited nodes during 1 layer of search. Instead, if the visited nodes's timestamp is the same as the current step number, which means that the node has just been visited in this layer of search, we still need to use it to expand the path edge. But to avoid duplicated search, we still can only add unvisited next nodes into the visited and queue.
```java
class Solution {
    public int backtracking(group) {
        //A hashmap or array to mark visited points
        Map<Integer, Integer> seen = new HashMap<>();
        //An queue to keep points of one layer of search
        Queue<Integer> q = new LinkedList<>();
        //relationship found during the search
        Map<Integer, Integer> relationship = new HashMap<>();
        //start the search with some points
        q.add(start);
        seen.put(start, 0);
        //a flag to indicate if the target has been found or not
        boolean isFound = false;
        //count steps
        int step = 0;
        //BFS loop
        while(!q.isEmpty()){
            //one layer a time
            for(int size = q.size(); size > 0; --size){
                //work on each point
                int cur = q.poll();
                //the current point might be the target point
                if (cur == target) {
                    return step;
                }
                //add more connected, unvisited points for next layer of search
                for(every connected points){
                    //only interested in points that are not visited or just visited in the current layer
                    if (unvisited points || visited but step is the same as the current step) {
                        //if the target is found, mark the flag
                        if (next == target) {
                            isFound = true;
                        }
                        //only add unvisited points
                        if(!seen.containsKey(next)){
                            q.add(next);
                            seen.add(next, step);
                        }
                        //update the path relationship
                        addRelationship(cur, next);
                    }
                }
            }
            if(isFound) break;
            //update step
            ++step;
        }
        //use DFS to reconstruct all shotest path
        DFS();
    }
}
```

#### *island problem*
BFS can do layer by layer search on a 2D board.\
Time Complexity: O(m * n) the grid size\
Space Complexity: O(1) if we can modify the grid
```java
class Solution {
    public int bfs(int[][] matrix) {
        int[] rowDir = new int[] {0, 1, 0, -1};
        int[] colDir = new int[] {1, 0, -1, 0};
        //use queue for bfs
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc});
        //use array to store visited status
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        //count steps
        int step = 0;
        while (!queue.isEmpty()) {
            //traverse layer by layer
            for(int size = queue.size(); size > 0; --size){
                //current cell
                int[] cur = queue.poll();
                //target reached, return shortest path
                if (cur[0] == tr && cur[1] == tc) return step;
                //try go to 4 neighbors
                for (int di = 0; di < 4; ++di) {
                    int nr = cur[0] + dr[di];
                    int nc = cur[1] + dc[di];
                    //discard invalid cell and visited cell
                    if (0 <= r && r < R && 0 <= c && c < C && !seen[nr][nc] && matrix[nr][nc] > 0) {
                        //mark as visited
                        seen[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            //update step
            ++step;
        }
        return -1;
    }
}
```
### Tree traverse problem
BFS can be applied to traverse tree structures level by level. For more details, check Tree summary.\
Time Complexity: O(n) each node gets visited once\
Space Complexity: O(n) 
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //corner case
        if(root == null) return ans;
        //create queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //use iteration to BFS the tree
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            //iterate through all nodes on the same level
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
```

### Graph traverse problem
BFS: 1. Can compute steps to complete certain task(For example, shortest path, K steps) in a unweighted undirected(occationally directed with Pruning, not recommended) graph. 2. With some advanced problems, we need to pair it with bit encoding, hashmap. 3. Can be used to find the shortest path in weightest path in Dijkstra algorithm.
Time Complexity: O(n) each node gets visited once\
Space Complexity: O(n) for visited status
```java
class Solution {
    public int BFS(graph) {
        //A hashmap or array to mark visited nodes
        Set<Integer> seen = new HashSet<>();
        //An queue to keep current visiting nodes
        Queue<Integer> q = new LinkedList<>();
        //start the search with some nodes
        q.add(start);
        seen.add(start);
        //keep track of steps
        int step = 0;
        //BFS loop
        while(!q.isEmpty()){
            //1 step a time
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                //add more nodes for further search
                for(var nei : graph.get(cur)){
                    //only add unvisited nodes
                    if(!seen.contains(nei)){
                        q.add(nei);
                        seen.add(nei);
                    }
                }
            }
            //update step
            step++;
        }
        //search fails
        return -1;
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








# BFS with rolling DP:
```java
class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        //corner case
        if(digits.length() == 0) return ans;
        //build the number-digit relation map
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        //BFS
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            //a temparay list to hold all new results
            List<String> tmp = new ArrayList<>();
            //for every string built previously
            for(var s : ans){
                //add all possible new letter
                for(var c : map.get(digits.charAt(i))){
                    tmp.add(s + c);
                }
            }
            //rotate lists, tmp is now the new answer list
            ans = tmp;
        }
        return ans;
    }
}
```

## Notes
In this example, we are building combination using BFS by rolling two containers. One container stores results from the last search, and the other container stores result of this search as we compute results using the last container.