# [LeetCode](https://leetcode.com/problems/implement-strstr/)

# Problem description: 
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



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
