## LeetCode link(Easy)
https://leetcode.com/problems/implement-strstr/

## Keyword
String

## Problem description
```
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
```

## Complexity Analyze
Nested loops
Time complexity: O((n-m)*m)
Space complexity: O(1)

## Notes
This is a very basic finding substring problem.

## Things to watchout
Corner cases: if haystack or needle are empty or null
Other: in the first loop, no need to iterate beyond the point where the characters left is less than the needle's length

## 10/16/2019 Java

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack.length() == 0)
            return -1;
        int it_1 = 0, it_2 = 0, result = -1;
        
        for(; it_1 < haystack.length() - needle.length() + 1; it_1 ++){
            if(haystack.charAt(it_1) == needle.charAt(0)){
                for(it_2 = 0; it_2 < needle.length(); it_2++){
                    if(haystack.charAt(it_1 + it_2) != needle.charAt(it_2))
                        break;
                }
                if(it_2 == needle.length())
                    return it_1;
            }
        }
        return -1;
    }
}
```
