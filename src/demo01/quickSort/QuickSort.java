package demo01.quickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

  public static void main(String[] args) {
    int[] nums = new int[8000];
    for (int i =0; i < nums.length; i++) {
      int temp = new Random().nextInt();
      nums[i] = temp;
    }
    sort(nums, 0, nums.length - 1);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        System.out.println("sort error" + i + "   " + nums[i] + "    " + nums[i - 1]);
        System.out.println(Arrays.toString(nums));
        return;
      }
    }
  }

  public static void sort(int[] nums, int left, int right) {
    if (left < right) {
      int i = left;
      int j = right;
      int K = nums[i];
      while (i < j) {
        while (i < j && nums[j] >= K) {
          j--;
        }
        nums[i] = nums[j];
        while (i < j && nums[i] < K) {
          i++;
        }
        nums[j] = nums[i];
      }
      nums[i] = K;
      sort(nums, left, i - 1);
      sort(nums, i + 1, right);
    }
  }
}
