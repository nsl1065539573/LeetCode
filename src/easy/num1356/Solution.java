package easy.num1356;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = new int[]{10,100,1000,10000};
    System.out.println(Arrays.toString(solution.sortByBits(arr)));;
  }

  public int[] sortByBits(int[] arr) {
    fastSort(arr, 0, arr.length - 1);
    return arr;
  }

  private void fastSort(int[] arr, int l, int r) {
    if (l < r) {
      int x = arr[l];
      int i = l;
      int j = r;
      while (i < j) {
        while (i < j && compare(arr[j], x)) {
          j--;
        }
        arr[i] = arr[j];
        while (i < j && (x == arr[i] || compare(x, arr[i]))) {
          i++;
        }
        arr[j] = arr[i];
      }
      arr[i] = x;
      fastSort(arr, l, i - 1);
      fastSort(arr, i +1, r);
    }
  }

  private boolean compare(int a, int b) {
    int aCount = getOneCount(a);
    int bCount = getOneCount(b);
    if (aCount > bCount) {
      return true;
    } else if (aCount < bCount) {
      return false;
    } else {
      return a > b;
    }
  }

  private int getOneCount(int num) {
    int count = 0;
    while (num > 0) {
      num = num - (num & -num);
      count++;
    }
    return count;
  }
}
