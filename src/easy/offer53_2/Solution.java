package easy.offer53_2;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = new int[] {0,1,2,3,4,5,6,7,9};
    System.out.println(solution.missingNumber(arr));
  }

  public int missingNumber(int[] nums) {
    // 二分查找  如果mid大小和下标一样则往右，否则往左，最后返回left
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left +right) >> 1;
      if (mid == nums[mid]) {
        left = mid +1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
