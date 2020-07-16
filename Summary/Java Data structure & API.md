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


## **Container**
---
## *List (Interface)*

An ordered collection (also known as a *sequence*). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

- `boolean add(E e)`
Appends the specified element(or a collection of elements returned by the specified colection's iterator) to the end of this list (or at specified index).
  - `void add(int index, E element)`
  - `boolean addAll(Collection<? extends E> c)`
  - `boolean addAll(int index, Collection<? extends E> c)`

- `E remove(int index)`
Removes the element at the specified position in this list (optional operation).
  - `boolean remove(Object o)`
  - `boolean removeAll(Collection<?> c)`

- `void clear()`
Removes all of the elements from this list (optional operation). 

- `boolean contains(Object o)`
Returns true if this list contains the specified element.

- `E get(int index)`
Returns the element at the specified position in this list.

- `int indexOf(Object o)`
Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
  - `int lastIndexOf(Object o)`

- `boolean isEmpty()`
Returns true if this list contains no elements.

- `E set(int index, E element)`
Replaces the element at the specified position in this list with the specified element (optional operation).

- `int size()`
Replaces the element at the specified position in this list with the specified element (optional operation).

- `<T> T[] toArray(T[] a)`
Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array. Like the toArray() method, this method acts as bridge between array-based and collection-based APIs. Further, this method allows precise control over the runtime type of the output array, and may, under certain circumstances, be used to save allocation costs. Suppose x is a list known to contain only strings. The following code can be used to dump the list into a newly allocated array of String: String[] y = x.toArray(new String[0]);

## *ArrayList (implement List)*

Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list. (This class is roughly equivalent to Vector, except that it is unsynchronized.)

- `Constructor`
Can take `Collection<? extends E>` as parameters

- `boolean add(E e)`
  - `void add(int index, E element)`
  - `boolean addAll(Collection<? extends E> c)`
  - `boolean addAll(int index, Collection<? extends E> c)`

- `E remove(int index)`
  - `boolean remove(Object o)`
  - `boolean removeAll(Collection<?> c)`

- `void clear()`

- `boolean contains(Object o)`

- `E get(int index)`

- `int indexOf(Object o)`
  - `int lastIndexOf(Object o)`

- `boolean isEmpty()`

- `E set(int index, E element)`

- `int size()`

- `<T> T[] toArray(T[] a)`

- `void forEach(Consumer<? super E> action)`
Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception. For example: Numbers.forEach((n) -> System.out.println(n));

## *LinkedList (implement List & Deque)*

Doubly-linked list implementation of the List and Deque interfaces. Implements all optional list operations, and permits all elements (including null). All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.

- `Constructor`
Can take `Collection<? extends E>` as parameters

- `boolean add(E e)`
  - `void add(int index, E element)`
  - `boolean addAll(Collection<? extends E> c)`
  - `boolean addAll(int index, Collection<? extends E> c)`

- `E get(int index)`

- `E remove(int index)`
  - `boolean remove(Object o)`
  - `boolean removeAll(Collection<?> c)`

- `void addFirst(E e)`
  - `void addLast(E element)`
  - `boolean offerFirst(E element)`
  - `boolean offerLast(E element)`

- `E peekFirst()`null if empty
  - `E peekLast()`
  - `E getFirst()`throw if empty
  - `E getLast()`

- `void clear()`

- `E pollFirst()`null if empty
  - `E pollLast()`
  - `E removeFirst()`throw if empty
  - `E removeLast()`

- `boolean contains(Object o)`

- `int indexOf(Object o)`
  - `int lastIndexOf(Object o)`

- `boolean isEmpty()`

- `E set(int index, E element)`

- `int size()`

- `<T> T[] toArray(T[] a)`

## *Stack (extends Vector)*

The Stack class represents a last-in-first-out (LIFO) stack of objects. It extends class Vector with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.

- `Constructor`

- `E peek()`

- `E pop()`

- `void push(E e)`

- `boolean isEmpty()`

## *Queue (Interface)*

A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue implementations; in most implementations, insert operations cannot fail.

- `boolean add(E e)`
  - `boolean offer(E e)`

- `E poll()`null if empty
  - `E remove()`throw if empty

- `E peek()`

## *PriorityQueue (implement Queue)*

An unbounded priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used. A priority queue does not permit null elements. A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in ClassCastException).

- `Constructor`
Can take `Collection<? extends E>`, `Comparator<? super E>` as parameters

- `boolean add(E e)`
  - `boolean offer(E e)`

- `E poll()`null if empty
  - `E remove()`throw if empty

- `E peek()`

- `int size()`

- `boolean contains(Object o)`

- `void clear()`

- `<T> T[] toArray(T[] a)`

## *Deque (Interface)*

A linear collection that supports element insertion and removal at both ends. The name deque is short for "double ended queue" and is usually pronounced "deck". Most Deque implementations place no fixed limits on the number of elements they may contain, but this interface supports capacity-restricted deques as well as those with no fixed size limit.

- `void	addFirst(E e)`
  - `void	addLast(E e)`
  - `void	offerFirst(E e)`
  - `void	offerLast(E e)`

- `E peekFirst()`
  - `E peekLast()`
  - `E getFirst()`
  - `E getLast()`

- `E pollFirst()`null if empty
  - `E pollLast()`
  - `E removeFirst()`throw if empty
  - `E removeLast()`

- `int size()`

- `boolean contains(Object o)`

## *ArrayDeque (implement Deque)*

Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. They are not thread-safe; in the absence of external synchronization, they do not support concurrent access by multiple threads. Null elements are prohibited. This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.

- `Constructor`
Can take `Collection<? extends E>` as parameters

- `void	addFirst(E e)`
  - `void	addLast(E e)`
  - `void	offerFirst(E e)`
  - `void	offerLast(E e)`

- `E peekFirst()`null if empty
  - `E peekLast()`
  - `E getFirst()`throw if empty
  - `E getLast()`

- `void clear()`

- `E pollFirst()`null if empty
  - `E pollLast()`
  - `E removeFirst()`throw if empty
  - `E removeLast()`

- `int size()`

- `boolean contains(Object o)`

- `<T> T[] toArray(T[] a)`

## *Set (Interface)*

A collection that contains no duplicate elements. More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), and at most one null element. As implied by its name, this interface models the mathematical set abstraction.

- `boolean	add(E e)`
  - `boolean	addAll(Collection<? extends E> c)`

- `boolean remove(Object o)`
  - `boolean	removeAll(Collection<?> c)`

- `boolean contains(Object o)`
  - `boolean	containsAll(Collection<?> c)`

- `void clear()`

- `int size()`

- `boolean isEmpty()`

- `<T> T[] toArray(T[] a)`

## *HashSet (implement Set)*

This class implements the Set interface, backed by a hash table (actually a HashMap instance). It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. This class permits the null element.

- `Constructor`
Can take `Collection<? extends E>` as parameters

- `boolean	add(E e)`

- `boolean remove(Object o)`

- `boolean contains(Object o)`

- `void clear()`

- `int size()`

- `boolean isEmpty()`

## *TreeSet (implement SortedSet)*

A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.

- `Constructor`
Can take `Collection<? extends E>`, `Comparator<? super E>` as parameters

- `boolean add(E e)`
  - `boolean addAll(Collection<? extends E> c)`

- `E ceiling(E e)`Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
  - `E higher(E e)`greater
  - `E floor(E e)`lower or equal
  - `E lower(E e)`lower

- `E pollFirst()`null if empty
  - `E pollLast()`

- `E first()`throw if empty
  - `E last()`

- `boolean remove(Object o)`

- `boolean contains(Object o)`

- `void clear()`

- `int size()`

- `boolean isEmpty()`

## *Map (Interface)*

An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.

- `V put(K key, V value)`
  - `void putAll(Map<? extends K,? extends V> m)`
  - `V putIfAbsent(K key, V value)`

- `V remove(Object key)`
  - `boolean	remove(Object key, Object value)`Removes the entry for the specified key only if it is currently mapped to the specified value.

- `V get(Object key)`
  - `V getOrDefault(Object key, V defaultValue)`

- `V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).
  - `V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)`If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.
  - `V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.

- `Set<K> keySet()`
- `Set<Map.Entry<K,V>> entrySet()`
- `Collection<V> values()`


- `boolean containsKey(Object key)`
  - `boolean containsValue(Object value)`

- `void forEach(BiConsumer<? super K,? super V> action)`Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.

- `void clear()`

- `int size()`

- `boolean isEmpty()`

## *HashMap (implement Map)*

Hash table based implementation of the Map interface. This implementation provides all of the optional map operations, and permits null values and the null key. (The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.) This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.

- `Constructor`
Can take `Map<? extends K,? extends V>` as parameters

- `V put(K key, V value)`
  - `void putAll(Map<? extends K,? extends V> m)`
  - `V putIfAbsent(K key, V value)`

- `V remove(Object key)`
  - `boolean remove(Object key, Object value)`

- `V get(Object key)`
  - `V getOrDefault(Object key, V defaultValue)`

- `V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`.
  - `V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)`
  - `V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`

- `Set<K> keySet()`
- `Set<Map.Entry<K,V>> entrySet()`
- `Collection<V> values()`

- `boolean containsKey(Object key)`
  - `boolean containsValue(Object value)`

- `void forEach(BiConsumer<? super K,? super V> action)`

- `void clear()`

- `int size()`

- `boolean isEmpty()`

## *TreeMap (implement SortedSet)*

A Red-Black tree based NavigableMap implementation. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.

- `Constructor`
Can take `Map<? extends K,? extends V>`, `Comparator<? super E>` as parameters

- `V put(K key, V value)`
  - `void putAll(Map<? extends K,? extends V> map)`

- `boolean containsKey(Object key)`
  - `boolean containsValue(Object value)`

- `Set<K> keySet()`in key's order
- `Set<Map.Entry<K,V>> entrySet()`in key's order
- `Collection<V> values()`in key's order

- `K ceilingKey(K key)`greter or equal
  - `K higherKey(K key)`greater
  - `K floorKey(K key)`lower or equal
  - `K lowerKey(K key)`lower

- `Map.Entry<K,V> ceilingEntry(K key)`greter or equal
  - `Map.Entry<K,V> higherEntry(K key)`greater
  - `Map.Entry<K,V> floorEntry(K key)`lower or equal
  - `Map.Entry<K,V> lowerEntry(K key)`lower

- `Map.Entry<K,V> pollFirstEntry()`null if empty
  - `Map.Entry<K,V> pollLastEntry()`

- `K firstKey()`throw if empty
  - `K lastKey()`

- `Map.Entry<K,V> firstEntry()`nullif empty
  - `Map.Entry<K,V> lastEntry()`

- `void forEach(BiConsumer<? super K,? super V> action)`

- `void clear()`

- `int size()`

- `boolean isEmpty()`





