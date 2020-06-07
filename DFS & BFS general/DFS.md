## Keyword
DFS

## Problem description
```
DFS is commonly used to implement backtracking algorithm. The problem it can solve includes: Combination; Permutation; Partition. A very common structure of DFS algorithm consists of 1: visited status holder(optional) 2: base case 3: backtracking case

```
## DFS: 
# Combination:
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
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            //add current layer
            list.add(nums[i]);
            //index needs to move forward to avoid using the same exact number twice(duplicates are still allowed if there are duplicates in the list)
            **DFS(nums, ans, list, i + 1, target);
            //index doesn't move if duplicates in the list are allowed
            **DFS(nums, ans, list, i, target);
            //remove current layer
            list.remove(list.size() - 1);
        }
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

# Record node relationship along the path:
```java
class Solution {
    public Map<String, List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //remove the begin word from the word list
        Set<String> set = new HashSet<>(wordList);
        //use hashmap to store visit status and visited steps
        Map<String, Integer> visited = new HashMap<>();
        //use hashmap to keep neighbor status
        Map<String, List<String>> neighbor = new HashMap<>();
        //use queue to do bfs
        Queue<String> q = new LinkedList<>();
        //initial status
        q.add(beginWord);
        int step = 0;
        //flag for if shortest path is found
        boolean isFound = false;
        //BFS
        while(!q.isEmpty()){
            for(int size = q.size(); size > 0; --size){
                //poll a node
                String cur = q.poll();
                //get all possible neighbors
                ArrayList<String> neighbors = getNeighbors(cur, set);
                //find all possible next step words that are not visited and add them into the queue for the next search
                for(var s : neighbors){
                    //nodes that are visited but is in the same step of search should also be added into path neighbor list
                    if((!visited.containsKey(s) || visited.get(s) == step)){
                        //if the answer is reached, we move on to build the graph after the current search
                        if(s == endWord) isFound = true;
                        //only add to the queue if this node is not visited
                        if(!visited.containsKey(s)) q.add(s);
                        //update neighbor list
                        neighbor.computeIfAbsent(cur, x -> new ArrayList<>()).add(s);
                        //mark as visited with current step
                        visited.put(s, step);
                    }
                }
            }
            if(isFound) break;
            step++;
        }
        return neightbor;
    }
}
```

## Notes
In this example, since we are building the path relation as we do BFS, we cannot just skip visited nodes during 1 layer of search. Instead, if the visited nodes's timestamp is the same as the current step number, which means that the node has just been visited in this layer of search, we still need to use it to expand the path relationship.

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