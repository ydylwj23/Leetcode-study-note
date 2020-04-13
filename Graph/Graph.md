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
In this code, we use f(m) condition to pinpoint the only element that meets the condition in each search. Note that the search range of such a template is [l, r). It is not recommended to do pinpoint search like this. The next code can also achieves the same goal.

# find the left most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition g(m) that a range of elements should meet. The search range here is [l, r)
            if(g(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet g(m) condition. 
        //This also expand the range to [l, r]
        return nums[l];
    }
}
```

## Notes
In this code, we use g(m) condition to find the leftmost element in a range of elements that meet condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r].

# find the right most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition `g(m) that a range of elements should meet. The search range in such a template is [l, r)
            if(g_opposite(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet `g(m), so l - 1 is the rightmost element of elements that meet g(m)
        //the range here becomes [l, r - 1]
        return nums[l - 1];
    }
}
```

## Notes
In this code, we use g(m) condition to find the leftmost element in a range of elements that meet condition `g(m) first. Then we can minus 1 on index to find the rightmost element of the opposite condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r - 1].


## Template 2: 

# find 1 and only 1 element:

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l <= r){
            int m = l + (r - l) / 2;
            //this is the condition f(m) that only 1 element should meet in the list. The search range in such a template is [l, r]
            if(f(m)) return m; //f(m) here can be nums[m] == target
            if(g(m)){ //g(m) here can be nums[m] > target
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        //search failed
        return -1;
    }
}
```

## Notes
Note that compared to template 1, the search range is [l, r]. It is still note recommended to use pinpoint search like this. The next code can also achieves the same goal.

# find the left most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition g(m) that a range of elements should meet. The search range here is [l, r]
            if(g(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet g(m) condition. 
        //This also expand the range to [l, r + 1]
        return nums[l];
    }
}
```

## Notes
In this code, we use g(m) condition to find the leftmost element in a range of elements that meet condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r + 1].

# find the right most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition `g(m) that a range of elements should meet. The search range in such a template is [l, r)
            if(g_opposite(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet `g(m), so l - 1 is the rightmost element of elements that meet g(m)
        //the range here becomes [l, r]
        return nums[l - 1];
    }
}
```

## Notes
In this code, we use g(m) condition to find the leftmost element in a range of elements that meet condition `g(m) first. Then we can minus 1 on index to find the rightmost element of the opposite condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r].

