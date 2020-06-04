## Keyword
BFS

## Problem description
```
BFS is commonly used to find the shortest path between nodes in a graph. But in many questions, we can treat point of interest as graph node so we can utilize BFS. A very common structure of BFS algorithm consists of 1: relationship structure between every two nodes 2: visited status holder(array or hash table) 3: a queue for traversing nodes layer by layer 4: step counter.

```
## BFS: 
# Standard BFS for graph:
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

# Standard BFS for matrix:
```java
class Solution {
    public int bfs(int[][] matrix, int sr, int sc, int tr, int tc) {
        int R = matrix.length, C = matrix[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
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
            step++;
        }
        return -1;
    }
}
```