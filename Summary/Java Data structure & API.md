# Data structure and API

## **Description**
---
A collection of common java data structure and AIPs

![image](https://static.javatpoint.com/images/java-collection-hierarchy.png)

![image](https://static.javatpoint.com/images/core/java-map-hierarchy.png)

The problem it can solve includes:
- **Collection** 
  -  **List**
     -  **ArrayList**
     -  **LinkedList**
     -  **Vector**
        -  **Stack**
  -  **Queue**
     -  **PriorityQueue**
     -  **Deque**
        -  ArrayDeque
  -  **Set**
     -  **HashSet**
     -  **TreeSet**
- Map
  - TreeMap
  - HashMap
    - LinkedHashMap   



## **Coding example**
---
## *Collections*

This class consists exclusively of static methods that operate on or return collections.

- `int binarySearch(List<? extends Comparable<? super T>> list, T key)`
- `int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`
Searches the specified list for the specified object using the binary search algorithm. The list must be sorted into ascending order according to the natural ordering of its elements (as by the sort(List) method) prior to making this call. If it is not sorted, the results are undefined. If the list contains multiple elements equal to the specified object, there is no guarantee which one will be found.  
***Return*** the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key, or list.size() if all elements in the list are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.

- `void copy(List<? super T> dest, List<? extends T> src)`
Copies all of the elements from one list into another. After the operation, the index of each copied element in the destination list will be identical to its index in the source list. The destination list must be at least as long as the source list. If it is longer, the remaining elements in the destination list are unaffected.  

- `void reverse(List<?> list)`
Reverses the order of the elements in the specified list.  

- `void sort(List<T> list)`
- `void sort(List<T> list, Comparator<? super T> c)`
Sorts the specified list into ascending order, according to the natural ordering of its elements. All elements in the list must implement the Comparable interface. Furthermore, all elements in the list must be mutually comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and e2 in the list).
This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.

- `void swap(List<?> list, int i, int j)`
Swaps the elements at the specified positions in the specified list. (If the specified positions are equal, invoking this method leaves the list unchanged.)

- `Comparator<T> reverseOrder()`
- `Comparator<T> reverseOrder(Comparator<T> cmp)`
Returns a comparator that imposes the reverse of the natural(or specified) ordering on a collection of objects that implement the Comparable interface. (The natural ordering is the ordering imposed by the objects' own compareTo method.) This enables a simple idiom for sorting (or maintaining) collections (or arrays) of objects that implement the Comparable interface in reverse-natural-order. For example, suppose a is an array of strings. Then: Arrays.sort(a, Collections.reverseOrder()); 
***Return*** A comparator that imposes the reverse of the natural(or specified) ordering on a collection of objects that implement the Comparable interface.

## *Arrays*

This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.

- `int binarySearch({primitive}[] a, {primitive} key)`
- `int binarySearch({primitive}[] a, int fromIndex, int toIndex, {primitive} key)`
- `int binarySearch(T[] a, T key, Comparator<? super T> c)`
- `int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)`
Searches the specified array of ints for the specified value using the binary search algorithm. The array must be sorted (as by the sort() method) prior to making this call. If it is not sorted, the results are undefined. If the array contains multiple elements with the specified value, there is no guarantee which one will be found. Note that comparator option is only for object type.
***Return*** index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.

- `List<T> asList(T... a)`
Returns a fixed-size list backed by the specified array. (Changes to the returned list "write through" to the array.) This method acts as bridge between array-based and collection-based APIs, in combination with Collection.toArray(). The returned list is serializable and implements RandomAccess.
This method also provides a convenient way to create a fixed-size list initialized to contain several elements: List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
***Return*** a list view of the specified array

- `{primitive}[] copyOf({primitive}[] original, int newLength)`
- `T[] copyOf(T[] original, int newLength)`
Copies the specified array, truncating or padding with nulls(default value for primitive types) (if necessary) so the copy has the specified length. For all indices that are valid in both the original array and the copy, the two arrays will contain identical values. For any indices that are valid in the copy but not the original, the copy will contain null. Such indices will exist if and only if the specified length is greater than that of the original array. The resulting array is of exactly the same class as the original array.  
***Return*** a copy of the original array, truncated or padded with nulls(default value for primitive type) to obtain the specified length

- `{primitive}[] copyOfRange({primitive}[] original, int from, int to)`
- `T[] copyOfRange(T[] original, int from, int to)`
Copies the specified range of the specified array into a new array. The initial index of the range (from) must lie between zero and original.length, inclusive. The value at original[from] is placed into the initial element of the copy (unless from == original.length or from == to). Values from subsequent elements in the original array are placed into subsequent elements in the copy. The final index of the range (to), which must be greater than or equal to from, may be greater than original.length, in which case null is placed in all elements of the copy whose index is greater than or equal to original.length - from. The length of the returned array will be to - from. Range: [from, to)  
***Return*** a new array containing the specified range from the original array, truncated or padded with nulls to obtain the required length

- `void fill({primitive}[] a, int fromIndex, int toIndex, {primitive} val)`
Assigns the specified int value to each element of the specified range of the specified array of ints. The range to be filled extends from index fromIndex, inclusive, to index toIndex, exclusive. (If fromIndex==toIndex, the range to be filled is empty.)Range: [from, to)  

- `void sort({primitive}[] a)`
- `void sort({primitive}[] a, int from, int to)`
- `void sort(T[] a, Comparator<? super T> c)`
- `void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)`
Sorts the specified range of the array into ascending order. The range to be sorted extends from the index fromIndex, inclusive, to the index toIndex, exclusive. If fromIndex == toIndex, the range to be sorted is empty. Note only object type can and must have comparator specified. And This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort. Range: [from, to).

- `String toString(primitive[] a)`
Returns a string representation of the contents of the specified array. The string representation consists of a list of the array's elements, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (a comma followed by a space). Elements are converted to strings as by String.valueOf(int). Returns "null" if a is null.  
***Return*** a string representation of a