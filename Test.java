import java.util.*;

class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int res = test.minOperations(new int[] {1,1,4,2,3}, 5);
        return;
    }

    public int minOperations(int[] nums, int x) {
        //get prefix
        int n = nums.length;
        int sum = 0;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum += nums[i - 1];
            prefix[i] += nums[i - 1] + prefix[i - 1];
        }
        //two pointers
        int max = -1;
        for (int l = 0, r = 0; r >= l && r <= n;) {
            int windowSum = prefix[r] - prefix[l];
            int substractSum = sum - windowSum;
            if (substractSum < x) {
                ++l;
            } else if (substractSum > x) {
                ++r;
            } else {
                max = Math.max(max, r - l);
                ++l;
                ++r;
            }
        }
        
        return max == -1 ? -1 : n - max;
    }
}
