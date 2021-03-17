package Medium.num978;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {4, 5};
    Solution solution = new Solution();
    System.out.println(solution.maxTurbulenceSize(arr));
  }

  public int maxTurbulenceSize(int[] arr) {
    int n = arr.length;
    int ret = 1;
    int left = 0, right = 0;

    while (right < n - 1) {
      if (left == right) {
        if (arr[left] == arr[left + 1]) {
          left++;
        }
        right++;
      } else {
        if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
          right++;
        } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
          right++;
        } else {
          left = right;
        }
      }
      ret = Math.max(ret, right - left + 1);
    }
    return ret;
  }
}
