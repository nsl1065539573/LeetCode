package Medium.nun229;

import java.util.LinkedList;
import java.util.List;

public class solution {
  public static void main(String[] args) {
    int[] arr = {2,1,1,3,1,4,5,6};
    solution solution = new solution();
    solution.majorityElement(arr);
  }

  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new LinkedList<>();
    int candidate1 = nums[0];
    int candidate2 = nums[0];
    int count1 = 0;
    int count2 = 0;
    for (int j : nums) {
      if (j == candidate1) {
        count1++;
      } else if (j == candidate2) {
        count2++;
      } else {
        if (count1 == 0) {
          candidate1 = j;
          count1 = 1;
        } else if (count2 == 0) {
          candidate2 = j;
          count2 = 1;
        } else {
          count1--;
          count2--;
        }
      }
    }
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (num == candidate1) {
        count1++;
        continue;
      }
      if (num == candidate2) {
        count2++;
      }
    }
    if (count1 > nums.length / 3){
      res.add(candidate1);
    }
    if (count2 > nums.length / 3) {
      res.add(candidate2);
    }
    return res;
  }
}
