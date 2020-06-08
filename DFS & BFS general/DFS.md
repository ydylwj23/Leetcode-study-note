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
            **if (i > index && nums[i] == nums[i - 1]) {
                **continue;
            **}
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
## Notes
The combination problems can be solved by backtracking especially when every possible combinations need to be output as part of the result. Note all the constraints of the problem: 1: If there are duplicates in the input. 2: If duplicate numbers can be used in the answer. 3: If there are constrains on the condition of the output list.\
Time Complexity: O(2 ^ n) for backtracking since every element may or may not be placed into a list. O(n) for putting every formed list into the asnwer.
Space Complexity: O(2 ^ n) to store every single result.

# Permutation:
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
            **if(visited[i]){
                continue;
            }
            //if there are duplicates in the input, need to skip: 1. elements that are visited 2. the duplicates except the the very first one encountered in the current layer since the same number can only be used once at the same level
            **if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])){
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
## Notes
The combination problems can be solved by backtracking especially when every possible combinations need to be output as part of the result. Note all the constraints of the problem: 1: If there are duplicates in the input. 2: If duplicate numbers can be used in the answer. 3: If there are constrains on the condition of the output list.\
Time Complexity: O(2 ^ n) for backtracking since every element may or may not be placed into a list. O(n) for putting every formed list into the asnwer.
Space Complexity: O(2 ^ n) to store every single result.