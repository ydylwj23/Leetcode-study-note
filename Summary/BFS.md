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
  - **Topological sort**
  - **Dijkstra**

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
#### *Topological sort*
Topological sort is BFS with in-degree. It sorts a directed graph in order and can be used to find loop.
```java
class Solution {
    public int[] topologySort(int[][] edges) {
        // build the graph, store in-degree
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for (var edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.computeIfAbsent(from, x -> new ArrayList<Integer>()).add(to);
            // Record in-degree of each vertex
            indegree[to]++;
        }
        // Add all nodes with 0 in-degree to the queue to start the topology sort
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        // record the sorted order if needed
        int[] topologicalOrder = new int[N];
        int index = 0;
        // Process until the q becomes empty
        while (!q.isEmpty()) {
            int cur = q.poll();
            // update the order
            topologicalOrder[index++] = cur;
            // Reduce the in-degree of each next node by 1
            for (all neighbors) {
                //reduce indegree of neighbors
                indegree[neighbor]--;
                // If in-degree of a neighbor becomes 0, add it to the q
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        // Number of nodes will be less than N if there's a cycle in the directed graph
        if (index == N) {
            return topologicalOrder;
        }
    }
}
```
#### *Dijkstra*
Dijkstra is a greedy algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be paired with extra step info in each node to detect shortest path within certain steps.
```java
class Solution
    public int Dijkstra(graph, source) {
        //use priority queue to keep nodes during the search
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        //start the algorithm from the source and distance of 0
        heap.add(new int[]{Source, 0});
        //use a hashmap to store distance to reach each node
        Map<Integer, Integer> distance = new HashMap<>();
        //use Dijkstra's Algorithm to travel from Source to all other nodes
        while(!heap.isEmpty()){
            curNode = heap.poll();
            //if the node time is already in the hash table, the recorded time must be shorter than the current time
            if(distance.containsKey(curNode)) continue;
            //update a shorter path distance for the current node
            distance.put(curNode, dis);
            //put new node in the queue
            for(all neighbors){
                //if node has already been extract from the heap before, which means the distance to it is already the smallest, we don't need add any other edge that leads to it
                if(!time.containsKey(neightbor)){
                    heap.add({neighbor, dis + disOf(curNode, neighbor)});
                }
            }
        }
        //some nodes cannot be reached
        if(distance.size() < N) return -1;
    }
}
```
