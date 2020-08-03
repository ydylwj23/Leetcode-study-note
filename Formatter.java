import java.util.*;

class Main {
  static public void main( String args[] ) {
    System.out.println( "Practice makes Perfect!" );
    int[] arr = new int[]{3,2,1,5,6,4};
    int result = kLargestElement(arr, 2);
    System.out.println( result );
    
  }

  static public int kLargestElement(int[] arr, int k) {
    int n = arr.length;
    return partition(arr, 0 , n - 1, n, k);
  }
  static private int partition(int[] arr, int start, int end, int n, int k) {
    //base case
    if (end < 0) {
      return arr[start];
    }
    if (start >= n) {
      return arr[end];
    }
    if (start == end) {
      return arr[start];
    }
    //take end as pivot
    int pivot = arr[end];
    int i = start;
    int j = start;
    while (j < end){
      if (arr[j] < pivot) {
        swap(arr,i, j);
        ++i;
      } 
      ++j;
    }
    swap(arr, i, end);
    if (i == n - k) {//find the kth largest
      return arr[i];
    } else if (i < n - k) {
      return partition(arr, i + 1, end, n , k);
    } else {// i > n - k
      return partition(arr, start, i - 1, n , k);
      
      
    }
  }
  static private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] =t;
    
  }
}