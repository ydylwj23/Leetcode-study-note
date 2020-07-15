# Data structure and API

## **Description**
---
A collection of common java data structure and APIs

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



## **Utility Class**
---
## *Collections (all method static)*

This class consists exclusively of static methods that operate on or return collections.

- `int binarySearch(List<? extends Comparable<? super T>> list, T key)`
Return index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key, or list.size() if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found. Also, array must be sorted and target must be unique. Note that comparator option is only for object type.
  - `int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`

- `void copy(List<? super T> dest, List<? extends T> src)`
Copies all of the elements from one list into another. The destination list must be at least as long as the source list. If it is longer, the remaining elements in the destination list are unaffected.  

- `void reverse(List<?> list)`
Reverses the order of the elements in the specified list.  

- `void sort(List<T> list)`
Sorts the specified list into ascending order, according to the natural ordering of its elements. This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.
  - `void sort(List<T> list, Comparator<? super T> c)`

- `void swap(List<?> list, int i, int j)`
Swaps the elements at the specified positions in the specified list.

- `Comparator<T> reverseOrder()`
Returns a comparator that imposes the reverse of the natural(or specified) ordering on a collection of objects that implement the Comparable interface. (The natural ordering is the ordering imposed by the objects' own compareTo method.) This enables a simple idiom for sorting (or maintaining) collections (or arrays) of objects that implement the Comparable interface in reverse-natural-order. For example, suppose a is an array of strings. Then: Arrays.sort(a, Collections.reverseOrder()).
  - `Comparator<T> reverseOrder(Comparator<T> cmp)`

## *Arrays (all method static)*

This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.

- `static int binarySearch({primitive}[] a, {primitive} key)`
Return index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found. Also, array must be sorted and target must be unique. Note that comparator option is only for object type.
  - `int binarySearch({primitive}[] a, int fromIndex, int toIndex, {primitive} key)`
  - `int binarySearch(T[] a, T key, Comparator<? super T> c)`
  - `int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)`


- `List<T> asList(T... a)`
Returns a fixed-size list backed by the specified array. This method acts as bridge between array-based and collection-based APIs, in combination with Collection.toArray(). This method also provides a convenient way to create a fixed-size list initialized to contain several elements: List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");

- `{primitive}[] copyOf({primitive}[] original, int newLength)`
Copies the specified array, truncating or padding with nulls(default value for primitive types) (if necessary) so the copy has the specified length.Range: [from, to)   
  - `T[] copyOf(T[] original, int newLength)`
  - `{primitive}[] copyOfRange({primitive}[] original, int from, int to)`
  - `T[] copyOfRange(T[] original, int from, int to)`

- `void fill({primitive}[] a, {primitive} val)`
Assigns the specified value to each element of the specified array. Range: [from, to) 
  - `void fill({primitive}[] a, int fromIndex, int toIndex, {primitive} val)`
 

- `void sort({primitive}[] a)`
Sorts the specified array into ascending numerical order. Note only object type can and must have comparator specified. And This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort. Range: [from, to).
  - `void sort({primitive}[] a, int from, int to)`
  - `void sort(T[] a, Comparator<? super T> c)`
  - `void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)`

- `String toString({primitive}[] a)`
Returns a string representation of the contents of the specified array. The string representation consists of a list of the array's elements, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (a comma followed by a space). Elements are converted to strings as by String.valueOf(int). Returns "null" if a is null.  

## *Integer*

The Integer class wraps a value of the primitive type int in an object. An object of type Integer contains a single field whose type is int.

- `int bitCount(int i)`
Return the number of one-bits in the two's complement binary representation of the specified int value.

- `static int compare(int x, int y)`
Compares two int values numerically. The value returned is identical to what would be returned by: Integer.valueOf(x).compareTo(Integer.valueOf(y))

- `int compareTo(Integer anotherInteger)`
Returns the value 0 if this Integer is equal to the argument Integer; a value less than 0 if this Integer is numerically less than the argument Integer; and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison).

- `Static String toString(int i)`
Returns a String object representing the specified integer.

- `Static int parseInt(String s)`
Parses the string argument as a signed decimal integer.

- `Static Integer valueOf(int i)`
Returns an Integer instance representing the specified int value.

- `int MAX_VALUE`
A constant holding the maximum value an int can have, 2^31-1.   

- `int MIX_VALUE`
A constant holding the maximum value an int can have, -2^31.   

## *Character*

The Character class wraps a value of the primitive type char in an object. An object of type Character contains a single field whose type is char.

- `static int compare(int x, int y)`
Compares two char values numerically. The value returned is identical to what would be returned by: Character.valueOf(x).compareTo(Character.valueOf(y))

- `int compareTo(Character anotherCharacter)`
Returns the value 0 if this Character is equal to the argument Character; a value less than 0 if this Character is numerically less than the argument Character; and a value greater than 0 if this Character is numerically greater than the argument Character (signed comparison).

- `static String toString(char c)`
Returns a String object representing the specified integer.

- `static Character valueOf(char c)`
Returns an Integer instance representing the specified int value.

- `static boolean isDigit(char ch)`

- `static boolean isLetter(char ch)`

- `static boolean isLetterOrDigit(char ch)`

- `static boolean isLowerCase(char ch)`

- `static boolean toUpperCase(char ch)`

- `static boolean toLowerCase(char ch)`

## *String*

The String class represents character strings. All string literals in Java programs, such as "abc", are implemented as instances of this class.

- `Constructor`
Can take `char[]`, `String`, `StringBuilder` as parameters

- `char charAt(int index)`

- `int compareTo(String anotherString)`
Return the value 0 if the argument string is equal to this string; a value less than 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument.

- `boolean equals(Object anObject)`
Return true if the given object represents a String equivalent to this string, false otherwise

- `boolean contains(CharSequence s)`
CharSequence includes `StringBuilder` and `String`

- `boolean isEmpty()`

- `int length()`

- `String[] split(String regex, int limit)`
limit: 0(as many times as possible, no trailing empty strings); -1(as many times as possible, with trailing empty strings)
  - `String[] split(String regex)`
Same as split(String regex, 0)   

- `int indexOf(int ch)` Return the index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur. 
  - `int indexOf(int ch, int fromindex)`
  - `int indexOf(String str)`
  - `int indexOf(String str, int fromindex)`
  - `int lastIndexOf(int ch)`
  - `int lastIndexOf(int ch, int fromindex)`
  - `int lastIndexOf(String str)`
  - `int lastIndexOf(String str, int fromindex)`

- `String substring(int beginIndex)` Returns a new string that is a substring of this string. [beginIndex, N/A]
  - `String substring(int beginIndex, int endIndex)` Returns a new string that is a substring of this string. [beginIndex, endIndex)

- `char[] toCharArray()` Converts this string to a new character array.

- `String toLowerCase()` Converts all of the characters in this String to lower case using the rules of the default locale.

- `String toUpperCase()` Converts all of the characters in this String to upper case using the rules of the default locale.

- `String trim()` Returns a copy of the string, with leading and trailing whitespace omitted.

- `static String valueOf({primitive})` Returns the string representation of the {primitive} argument.

## *StringBuilder*

A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.

- `Constructor`
Can take `String`, `StringBuilder` as parameters

- `StringBuilder append({primitive})`
Appends the string representation of the {primitive} argument to this sequence.
  - `StringBuilder append(String str)`
  - `StringBuilder append(char[] str)`

- `StringBuilder delete(int start, int end)`
Range: [start, end)

- `StringBuilder deleteCharAt(int index)`

- `int indexOf(String str)` Return the index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur. 
  - `int indexOf(String str, int fromindex)`
  - `int lastIndexOf(String str)`
  - `int lastIndexOf(String str, int fromindex)`

- `StringBuilder insert(int offset, {primitive})`
Inserts the string representation of the {primitive} into this sequence.
  - `StringBuilder insert(int offset, String str)`

- `int length()`

- `StringBuilder reverse()`

- `void setCharAt(int index, char ch)` Set the character at the specified index is set to ch.

- `String substring(int beginIndex)` Returns a new string that is a substring of this sequence. [beginIndex, N/A]
  - `String substring(int beginIndex, int endIndex)` Returns a new string that is a substring of this sequence. [beginIndex, endIndex)

- `toString()`
Returns a string representing the data in this sequence.




