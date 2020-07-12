# Monotonic Queue

## **Description**
Monotonic Queue keeps index-sorted data in monotonic order. The queue can be implemented by Stack or Deque.

The problem it can solve includes:
- min/max of a sliding window
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

### min/max of a sliding window
The problem can be described as `S[i] = min(A[j:k]) + C` where `j < k <= i` and `C` is a constant.

The sliding max/min window problem belongs to this type.

Problem statement: return the max elements in a sliding window of certain length.

Key observation: Given input array `A`, when `A[l] < A[r]` for `l < r`, then `A[l]` should never be retuned as the sliding max, if `A[r]` has entered the sliding window.

So we maintain a monotonic array with index **increasing** and value **decreasing**.

For example, with sliding window of fixed length 3,
> `A = [3, 1, 4, 3, 8] => [3], [3, 1], [4], [4, 3], [8]` 
> when element `4` enters, we remove `[3, 1]` because they are on the left and smaller than `4`, no chance being chosen as the max element.

The head of the increasing queue is the sliding max!

As simple as it is, we have a sliding window of elements, 
the only unique thing here is that we can keep the elements in the window sorted. It brings great benefits because it takes O(1) to obtain the min/max element in the window.

That's why any DP problem where `S[i] = max(A[j:k]) + C` for `j < k <= i` can be solved by Monotonic Queue.
Time Complexity: O(n)\
Space Complexity: O(n)
```java
class Solution {
    Deque<Integer> dq;
    int[] nums;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        this.nums = nums;
        //use deque to store index of the window
        dq = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            addNew(i, k);
        }
        ans[0] = nums[dq.getFirst()];
        
        //iterate through the array with the sliding window
        for(int i = k; i < nums.length; i++){
            addNew(i, k);
            ans[i - k + 1] = nums[dq.getFirst()];
        }
        return ans;
    }
    private void addNew(int i, int k){
        //remove index that are not part of the window
        while(!dq.isEmpty() && dq.getFirst() <= i - k) dq.removeFirst();
        
        //remove index of elements smaller than the new coming element from right
        while(!dq.isEmpty() && (nums[dq.getLast()] < nums[i]) ) dq.removeLast();
        
        //add the new element
        dq.addLast(i);
    }
}
```

Nearest larger/smaller element
---
Given element `A[i]`, the task is to find the maximum index `j < i` such that `A[j] > A[i]`. Namely, `A[j]` is the nearest larger element on the left of `A[i]`.

Key observation: given `A[k] < A[j] > A[i]` for `k < j < i`, `A[k]` never become the **nearest** element larger than `A[i]` because of `A[j]`.

So we should have a decreasing monotonic queue here. The arrow indicates that the mapping from element on the right to the nearest element on the left larger than it. The elements in the valley are ignored.

![alt text](https://imgur.com/ZfQSOag.png)

Time Complexity: O(n)\
Space Complexity: O(n)
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        //use stack to keep track of histograms
        Stack<Integer> stack = new Stack<>();
        //add index -1 as the left bound
        stack.push(-1);
        int size = 0;
        int n = heights.length;
        //interate through all the histogram
        for(int i = 0; i < n; ++i){
            //if the new histogram is equal or lower than the current top, extract a rectangle formed by the top index's height and the width difference between the second top index and the new histogram
            while(stack.size() > 1 && heights[stack.peek()] >= heights[i]){
                size = Math.max(size, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        //run the same popping algorithm on all the remaining histograms
        while(stack.size() > 1){
            size = Math.max(size, heights[stack.pop()] * (n - 1 - stack.peek()));
        }
        return size;
    }
}
```