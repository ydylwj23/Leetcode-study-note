## Keyword
Graph

## Problem description
```
Graph can be roughly categorized into: undirected, directed, unweighted and weighted. Graph can be represented by Adjacency List or Adjacency Matrix.

Commonly used Algorithm in graph problem:

BFS: 1. Can compute steps to complete certain task(For example, shortest path, K steps) in a unweighted undirected(occationally directed with Pruning, not recommended) graph. 2. With some advanced problems, we need to pair it with bit encoding, hashmap.

DFS: 1. Can visit connected nodes in certain components, used to compute size of certain components, each node's visited status in certain components, alter status of certain components, check if some nodes are in the same component in a unweighted undirected(occationally directed with pruning, not recommended) graph. 2. Can be used to perform graph coloring/bipartite directed or undirected unweighted graph. 3. Can detect cycles in directed unweighted graph when paired with "unvisited, visiting, visted" status records.

Union Find(DSU): 1. Can group(separate with other) components in undirected graph. Sometimes paired with HashMap to solve advanced grouping problems. 2. Cycle detection in undirected graph.

Topology sort: 1. Cycle detection in directed graph. 2. Can generate directed path through a directed graph. 3. Use In/Out degree to do certain judgements.

Dikastra: 1. Greedy algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be paired with extra step info in each node to detect shortest path within certain steps.

Bellman Ford: 1. DP algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be used with out DP by always using source node distance from the last result to detect shortest path within certain steps.

Floyd Warshall: 1. A advanced Bellman Ford algorithm to find the shortest path from every node to every other nodes in a directed(occationally undirected) weighted graph.

Euler path: 1. This is a greedy path to traverse through all the nodes with given edges(no repeats). Can be computed by treating the direted graph as a binary tree.

Tarjan: 1. Can be used to find bridges in an undirected graph. 2. Can be used to find articulation points in an undirected graph.

```
## BFS: 
# Standard BFS:
```java
class Solution {
    public int BFS(List<int[]> edges) {
        //build the graph(adjacency list) from edges if possible
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(var e : edges){
            graph.computeIfAbsent(e[0]).add(e[1]);
            graph.computeIfAbsent(e[1]).add(e[0]);
        }
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

## Notes
BFS: 1. Can compute steps to complete certain task(For example, shortest path, K steps) in a unweighted undirected(occationally directed with Pruning, not recommended) graph. 2. With some advanced problems, we need to pair it with bit encoding, hashmap.

## DFS: 
# Standard DFS
```java
class Solution {
    public boolean DFS(List<int[]> edges, int N) {
        //build the graph(adjacency list) from edges if possible
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(var e : edges){
            graph.computeIfAbsent(e[0]).add(e[1]);
            graph.computeIfAbsent(e[1]).add(e[0]);
        }
        //store different visit status of each node
        int[] visited = new int[N];
        
        //perform dfs starting from every node in the graph
        for(int i = 0; i < N; i++){
            //only start DFS on nodes with certain status
            //do things according the result of the DFS
            if(visited[i] == 0 && !dfs(graph, visited, i)) return false;
        }
        return true;
    }
    public boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int cur){
        //do things according to the status of the node
        if(visited[cur] != 1){
            return false;
        } 
        if(visited[cur] != 2){
            return true;
        } 
        //if unvisited, mark the new status of the node
        visited[cur] = 1;
        //recursively call DFS on all neighbors
        for(var nei : graph[cur]){
            //do things according to the next DFS's return
            if(!dfs(graph, visited, nei)) return false;
        }
        //sometimes, after DFS, we need to change node's status again(backtracking)
        visited[cur] = 2;
        //return this DFS's result
        return true;
    }
}
```
## Notes
DFS: 1. Can visit connected nodes in certain components, used to compute size of certain components, each node's visited status in certain components, alter status of certain components, check if some nodes are in the same component in a unweighted undirected(occationally directed with pruning, not recommended) graph. 2. Can be used to perform graph coloring/bipartite directed or undirected unweighted graph. 3. Can detect cycles in directed unweighted graph when paired with "unvisited, visiting, visted" status records.

## DSU: 
# Standard DSU
```java
class Solution {
    public boolean possibleBipartition(List<int[]> edges, int N) {
        //iterate through all edges to build DSU
        DSU dsu = new DSU(N);
        for(var e : edges){
            //union can return boolean here to detect cycles
            union(e[0], e[1]);
        }
        
        //do things according to problem's request
        //for example we can easily compute how groups are there
        int group = 0;
        for(int i = 0; i < N; i++){
            if(dsu.parent[i] == i) group++;
        }
    }
}

//Disjoint Set Union data structure
class DSU{
    int[] parent;
    int[] rank;
    public DSU(int n){
        parent = new int[n];
        //initial parents are themselves
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        rank = new int[n];
    }
    public int find(int i){
        //recursion path compression
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }
    public boolean union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        //failed union
        if(root == rooty){
            return false;
        }
        //union according to ranks
        if(rank[rootx] < rank[rooty]){
            parent[rootx] = rooty;
        }else if(rank[rootx] > rank[rooty]){
            parent[rooty] = rootx;
        }else{
            parent[rootx] = rooty;
            rank[rooty]++;
        }
        return true;  
    }
}

```
## Notes
Union Find(DSU): 1. Can group(separate with other) components in undirected graph. Sometimes paired with HashMap to solve advanced grouping problems. 2. Cycle detection in undirected graph.

## Topology Sort: 
# Standard Topology Sort
```java
class Solution {
  public int[] topologySort(int N, int[][] edges) {
    //build the graph, store in-degress
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
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

    //record the sorted order if needed
    int[] topologicalOrder = new int[numCourses];
    int index = 0;
    // Process until the q becomes empty
    while (!q.isEmpty()) {
        int cur = q.poll();
        //update the order
        topologicalOrder[index++] = node;

        // Reduce the in-degree of each next node by 1
        if (adjList.containsKey(node)) {
            for (Integer neighbor : adjList.get(node)) {
                indegree[neighbor]--;

                // If in-degree of a neighbor becomes 0, add it to the q
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }

    // Number node sorted can reveal if there's a cycle in the directed graph
    if (index == numCourses) {
        return topologicalOrder;
    }

    //sort failed because there's a cycle
    return new int[0];
  }
}
```
## Notes
Topology sort: 1. Cycle detection in directed graph. 2. Can generate directed path through a directed graph. 3. Use In/Out degree to do certain judgements.

## Dijkstra's Algorithm
# Standard Dijkstra
```java
class Solution
    public int Dijkstra(int[][] edges, int N, int Source) {
        //build the graph
        List<int[]>[] graph = new ArrayList[N];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(var edges : times){
            graph[edges[0]].add(new int[]{edges[1], edges[2]});
        }
        //use priority queue to keep nodes in search
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        //start the algorithm from the source
        heap.add(new int[]{Source, 0});
        //use a hashmap to store distance to reach each node
        Map<Integer, Integer> distance = new HashMap<>();
        //use Dijkstra's Algorithm to travel from Source to all other nodes
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            //if the node time is already in the hash table, the recorded time must be shorter than the current time
            if(distance.containsKey(cur[0])) continue;
            //update a shorter path distance for the current node
            distance.put(cur[0], cur[1]);
            //put new node in the queue
            for(var edge : graph[cur[0]]){
                //if node has already been extract from the heap before, which means the distance to it is already the smallest, we don't need add any other edge that leads to it
                if(!time.containsKey(edge[0])){
                    heap.add(new int[]{edge[0], edge[1] + cur[1]});
                }
            }
        }
        //some nodes cannot be reached
        if(heap.size() < N) return -1;
    }
}
```
# Shortest path to target node within K steps Dijkstra
```java
class Solution {
    public int DijkstraWithSingleDestiny(int n, int[][] edges, int src, int dst, int K) {
        //build the graph
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(var edge : edges) graph[edge[0]].add(new int[]{edge[1], edge[2]});
        //use the priority queue for store path
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        //{srouce node, cost so far, remaining steps}
        pq.add(new int[]{src, 0, K});
        //use a hash set to store the visited status
        Set<Integer> visited = new HashSet<>();
        //Dijkstra Algorithm.
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            //if the node time is already in the hash table, the recorded time must be shorter than the current time
            if(visited.contains(cur[0])) continue;
            int cur = c[0], cost = c[1], steps = c[2];
            //best route found
            if(cur == dst){
                return cost;
            }
            for(var edge : graph[cur]){
                //make sure we don't go out of steps and don't visit visited nodes
                if(steps > 0 && !visited.contains(edge[0]) pq.add(new int[]{edge[0], cost + edge[1], steps - 1});
            }
        }
        //no route exists
        return -1;
    }
}
```
## Notes
Dijkstra: 1. Greedy algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be paired with extra step info in each node to detect shortest path within certain steps.

Time complexity: O(NlogN + E)  E for building the graph, NlogN for the algorithm\
Space complexity: O(N + E)  E for the graph, N for the heap

## Bellman Ford's Algorithm
# Standard Bellman Ford
```java
class Solution {
    public int BellmanFord(int[][] edges, int N, int start) {
        //use an array to store distance to reach each node from the source
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        //initial value for the DP
        distance[start] = 0;
        //Use bellman ford algorithm to find min distance to reach each node
        for(int i = 0; i < N - 1; i++){
            for(var edge : edges){
                int src = edge[0], des = edge[1], wei = edge[2];
                //make sure there's no overflow
                if(distance[src] != Integer.MAX_VALUE){
                    distance[des] = Math.min(distance[des], distance[src] + wei);
                }
            }
        }
        //check for the max distance to reach all nodes
        int ans = 0;
        for(int i = 1; i <= N; i++){
            //if any nodes cannot be reached;
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
```
# Shortest path to target node within K steps BellmanFord
```java
class Solution {
    public int BellmanFordWithSingleDestiny(int[][] edges, int N, int start, int destiny, int K) {
        //use an array to store distance to reach each node from the source
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        //initial value for the DP
        distance[start] = 0;
        //Use bellman ford algorithm to find min distance to reach each node
        for(int i = 0; i < K; i++){
            //make a copy for the previous search result so the update result in the array won't effect other searches
            int[] temp = Arrays.copyOf(distance, N);
            for(var edge : edges){
                int src = edge[0], des = edge[1], wei = edge[2];
                //make sure there's no overflow
                if(distance[src] != Integer.MAX_VALUE){
                    temp[des] = Math.min(temp[des], distance[src] + wei);
                }
            }
            //update the dp array
            distance = temp;
        }
        //check for the max distance to reach all nodes
        int ans = 0;
        for(int i = 1; i <= N; i++){
            //if any nodes cannot be reached;
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
```
## Notes
Bellman Ford: 1. DP algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be used with out DP by always using source node distance from the last result to detect shortest path within certain steps.

Time complexity: O(NE)  NE times for two nested loop\
Space complexity: O(N)  E for the graph, N for the DP array

## Floyd Warshall's Algorithm
# Standard Floyd Warshall
```java
class Solution {
    public int FloydWarshall(int[][] edges, int N) {
        //use a 2D array to store distance from every node to every other node
        int[][] distance = new int[N][N];
        for(var i : distance) Arrays.fill(i, Integer.MAX_VALUE);
        //initial status for the DP
        for(int i = 0; i < N; i++){
            distance[i][i] = 0;
        }
        //place all edges in the DP array
        for(var edge : edges){
            distance[edge[0]][edge[1]] = edge[2];
        }
        //use Floyd Warshall Algorithm to update distance to reach every node
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    //condition to make sure there's no overflow
                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE){
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        //post-processing
    }
}
```

## Notes
Floyd Warshall: 1. A advanced Bellman Ford algorithm to find the shortest path from every node to every other nodes in a directed(occationally undirected) weighted graph.

Time complexity: O(N^3)  N^3 for the 3 nested loops\
Space complexity: O(N^2)  N^2 for the 2D array