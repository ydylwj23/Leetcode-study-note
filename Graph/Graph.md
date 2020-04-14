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

Diijastra: 1. Greedy algorithm to find the shortest path from 1 node to all other nodes in a directed(occationally undirected) weighted graph. 2. Can be paired with extra step info in each node to detect shortest path within certain steps.

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
Union Find(DSU): 1. Can group(separate with other) components in undirected graph. Sometimes paired with HashMap to solve advanced grouping problems. 2. Cycle detection in undirected graph.