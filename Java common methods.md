# Java common data structure and methods

## Math
#### static:
```
int abs(int i): Returns the absolute value of an int value.
int max(int a, int b): Returns the greater of two int values.
int min(int a, int b): Returns the smaller of two int values.
long round(double a): Returns the closest long to the argument, with ties rounding to positive infinity.
int round(float a): Returns the closest int to the argument, with ties rounding to positive infinity.
double pow(double a, double b): Returns the value of the first argument raised to the power of the second argument.
double floor(double a): Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.
double ceil(double a): Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.
```
#### non-static:
```
```

## Integer
#### static:
```
int MAX_VALUE: 2^31-1
int MIN_VALUE: -2^31
int compare(int x, int y): Compares two int values numerically.
int parseInt(String s): Parses the string argument as a signed decimal integer.
String toString(int i): Returns a String object representing the specified integer.
Integer valueOf(int i): Returns an Integer instance representing the specified int value.
Integer valueOf(String s): Returns an Integer object holding the value of the specified String.
String toBinaryString(int i): Returns a string representation of the integer argument as an unsigned integer in base 2.
```
#### non-static:
```
int compareTo(Integer anotherInteger): Compares two Integer objects numerically.
int intValue(): Returns the value of this Integer as an int.
```

## String
#### static:
```
String join(CharSequence delimiter, CharSequence... elements): Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified delimiter.
String valueOf(int i): Returns the string representation of the int argument.
```
#### non-static:
```
int length(): Returns the length of this string.
String[] split(String regex, int n): Splits this string around matches of the given regular expression. If n is non-positive then the pattern will be applied as many times as possible and the array can have any length. If n is zero then the pattern will be applied as many times as possible, the array can have any length, and trailing empty strings will be discarded.
String substring(int beginIndex, int endIndex): Returns a string that is a substring of this string.
char[] toCharArray(): Converts this string to a new character array.
int compareTo(String anotherString): Compares two strings lexicographically.
```

## Character
#### static:
```
boolean isDigit(char ch): Determines if the specified character is a digit.
boolean isLetter(char ch): Determines if the specified character is a letter.
boolean isUpperCase(char ch): Determines if the specified character is a uppercase character.
boolean isLowerCase(char ch): Determines if the specified character is a lowercase character.
```
#### non-static:
```
```

## StringBuilder
#### static:
```
```
#### non-static:
```
StringBuilder append(String str): Appends the specified string to this character sequence.
char charAt(int index): Returns the char value in this sequence at the specified index.
StringBuilder insert(int offset, String str): Inserts the string into this character sequence.
void setCharAt(int index, char ch): The character at the specified index is set to ch.
StringBuilder deleteCharAt(int index): Removes the char at the specified position in this sequence.
StringBuilder reverse(): Causes this character sequence to be replaced by the reverse of the sequence.
```

## java.util.Random
#### static:
```
```
#### non-static:
```
int nextInt(int bound): Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive), drawn from this random number generator's sequence.
```

## java.util.Collections
#### static:
```
void sort(List<T> list, Comparator<? super T> c): Sorts the specified list according to the order induced by the specified comparator.
void reverse(List<?> list): Reverses the order of the elements in the specified list.
Comparator reverseOrder(): Returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface.
```
#### non-static:
```
```

## java.util.Arrays
#### static:
```
int[] copyOf(int[] original, int newLength): Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.
void fill(int[] a, int val): Assigns the specified int value to each element of the specified array of ints.
void sort(T[] a, Comparator<? super T> c): Sorts the specified array of objects according to the order induced by the specified comparator. (Note the array cannot be primitive to be sorted!!!)
List<T> asList(T... a): Returns a fixed-size list backed by the specified array. (new ArrayList<T>(Arrays.asList(T... a)))
```
#### non-static:
```
```

## java.util.List (implemented by java.util.ArrayList)
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
boolean add(E e): Appends the specified element to the end of this list (optional operation).
E get(int index): Returns the element at the specified position in this list.
E set(int index, E element): Replaces the element at the specified position in this list with the specified element.
E remove(int index): Removes the element at the specified position in this list (optional operation).
int size(): Returns the number of elements in this list.
<T>T[] toArray(T[] a): Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
```

## java.util.Stack (implemented by Stack)
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
E peek(): Looks at the object at the top of this stack without removing it from the stack.
E pop(): Removes the object at the top of this stack and returns that object as the value of this function.
E push(E item): Pushes an item onto the top of this stack.
```

## java.util.Queue (implemented by LinkedList or PriorityQueue)
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
E peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
boolean offer(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
```

## java.util.Deque (implemented by java.util.ArrayDeque)
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
boolean offerFirst(E e): Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
boolean offerLast(E e): Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
E peekFirst(): Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
E peekLast(): Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
E pollFirst(): Retrieves and removes the first element of this deque, or returns null if this deque is empty.
E pollLast(): Retrieves and removes the last element of this deque, or returns null if this deque is empty.
```

## java.util.Set (implemented by java.util.HashSet)
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
void clear(): Removes all of the mappings from this map (optional operation).
boolean add(E e): Adds the specified element to this set if it is not already present (optional operation).
boolean contains(Object o): Returns true if this set contains the specified element.
```

## java.util.TreeSet
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
void clear(): Removes all of the mappings from this map (optional operation).
boolean add(E e): Adds the specified element to this set if it is not already present.
boolean contains(Object o): Returns true if this set contains the specified element.
E ceiling(E e): Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
E floor(E e): Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
E higher(E e): Returns the least element in this set strictly greater than the given element, or null if there is no such element.
E lower(E e): Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
E first(): Returns the first (lowest) element currently in this set.
E last(): Returns the last (highest) element currently in this set.
```

## java.util.Map (implemented by java.util.HashMap)
#### static:
```
Map.Entry<K, V> entry(K k, V v): Returns an unmodifiable Map.Entry containing the given key and value.
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
void clear(): Removes all of the mappings from this map (optional operation).
V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction): If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.
boolean containsKey(Object key): Returns true if this map contains a mapping for the specified key.
Set<Map.Entry<K,V>> entrySet(): Returns a Set view of the mappings contained in this map.
V get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
V getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
V put(K key, V value): Associates the specified value with the specified key in this map (optional operation).
V remove(Object key): Removes the mapping for a key from this map if it is present (optional operation).
Set<K> keySet(): Returns a Set view of the keys contained in this map.
Collection<V> values(): Returns a Collection view of the values contained in this map.
```

## java.util.TreeMap
#### static:
```
```
#### non-static:
```
boolean isEmpty(): Test if the list is empty.
int size(): Returns the number of elements in this list.
void clear(): Removes all of the mappings from this map (optional operation).
K ceilingKey(K key): Returns the least key greater than or equal to the given key, or null if there is no such key.
K floorKey(K key): Returns the greatest key less than or equal to the given key, or null if there is no such key.
K higherKey(K key): Returns the least key strictly greater than the given key, or null if there is no such key.
K lowerKey(K key): Returns the greatest key strictly less than the given key, or null if there is no such key.
K firstKey(): Returns the first (lowest) key currently in this map.
K lastKey(): Returns the last (highest) key currently in this map.
boolean containsKey(Object key): Returns true if this map contains a mapping for the specified key.
Set<Map.Entry<K,V>> entrySet(): Returns a Set view of the mappings contained in this map.
V get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
V getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
V put(K key, V value): Associates the specified value with the specified key in this map (optional operation).
V remove(Object key): Removes the mapping for a key from this map if it is present (optional operation).
Set<K> keySet(): Returns a Set view of the keys contained in this map.
Collection<V> values(): Returns a Collection view of the values contained in this map.
```

## java.util.stream.Stream
#### static:
```
```
#### non-static:
```
Stream<T> filter(Predicate<T> predicate): Returns a stream consisting of the elements of this stream that match the given predicate.
```

## Combination usage
#### static:
```
int Arrays.stream(int[] a).max().getAsInt(): Get the max value of an int array.
int Arrays.stream(int[] a).min().getAsInt(): Get the min value of an int array.
int Arrays.stream(int[] a).sum(): Get the sum of an int array.
List<Integer> Arrays.stream(int[] a).boxed().collect(Collectors.toList()): Convert int[] to List<Integer>
```
#### non-static:
```
int[] list.stream().mapToInt(i -> i).toArray(): transfer Integer list to int array.
int list.stream().mapToInt(i -> i).max().getAsInt(): Get the max value of an Integer List.
int list.stream().mapToInt(i -> i).min().getAsInt(): Get the min value of an Integer List.
int list.stream().mapToInt(i -> i).sum(): Get the sum of an Integer List.
List<T> new ArrayList<>(Arrays.asList(T a...)): Create an ArrayList of some given values.
List<T> new ArrayList<>(List<T> list): Create a shallow copy of a given list.
```