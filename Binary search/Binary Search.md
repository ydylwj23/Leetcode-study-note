## Keyword
Binary search

## Problem description
```
Binary search is used to find an element usually in a sorted list of elements. By utilizing binary search, we can reduce the time complexity of linear search from O(n) to o(logn).\
Most of the time, we are asked to find the 1 and only 1 element in the list that meets condition f(m). But sometimes we have to find the most left element of a range of elements that meet condition g(m) or the most right of such condition.
```
## Template: find 1 and only 1 element

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition f(m) that only 1 element should meet in the list. The search range in such a template is [l, r)
            if(f(m)) return m; //f(m) here can be nums[m] == target
            if(g(m)){ //g(m) here can be nums[m] > target
                r = m;
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

## Complexity Analyze
\
Time complexity: O(logn)\
Space complexity: O(1)

## Notes
In this template, we use f(m) condition to pinpoint the only element that meets the condition in each search. Note that the search range of such a template is [l, r)

## Key points
Corner cases:
API: 

## Template: find the left most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition g(m) that a range of elements should meet. The search range in such a template is [l, r]
            if(g(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet g(m) condition
        return nums[i];
    }
}
```

## Complexity Analyze
\
Time complexity: O(logn)\
Space complexity: O(1)

## Notes
In this template, we use g(m) condition to find the leftmost element in a range of elements that meet condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r].

## Key points
Corner cases:
API: 

## Template: find the right most element in a range of elements that meet certain condition

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            //this is the condition `g(m) that a range of elements should meet. The search range in such a template is [l, r]
            if(g_opposite(m)){  //g(m) can be nums[m] >= target
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        //l pointer is always on leftmost element of elements that meet `g(m), so l - 1 is the rightmost element of elements that meet g(m)
        //the range here becomes [l, r - 1]
        return nums[i - 1];
    }
}
```

## Complexity Analyze
\
Time complexity: O(logn)\
Space complexity: O(1)

## Notes
In this template, we use g(m) condition to find the leftmost element in a range of elements that meet condition `g(m) first. Then we can minus 1 on index to find the rightmost element of the opposite condition g(m). The key point of this search is to rely on postprocessing because the left pointer will always point at such element when the search ends. Note that the search range of such a template is [l, r - 1].

## Key points
Corner cases:
API: 
