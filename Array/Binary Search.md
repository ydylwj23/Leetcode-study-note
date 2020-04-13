## Keyword
Array

## Problem description
```
Contiguous subarray problems:

Target sum problem: This type of problem ususally asks for some property related to subarrays with a target sum. For example, number of all subarrays that have target sum(560), or the longest subarray with a target sum(525). The universal way to solve this prolbem efficiently is to store prefix sum in a hashmap as we interate through the array. For example, prefix sum's first appearance index, or prefix sum's number of appearance. Note that we usually have to put a special prefix sum 0 in the hashtable before the iteration begins.

Monotone subarray problem: In this type of problem, the focused property of the subarray is monotone when moving the left bound or the right bound. For example, the number of unique elements in a subarray(992). For this type of problem, we can always use some variant of two pointer method to solve it since it's monotone.
```
## Template 1: 

# find 1 and only 1 element:

```java
class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
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

