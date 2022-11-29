package medium.num986;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] firstList = {{3,5},{9,20}};
    int[][] secondList = {{4,5},{7,10},{11,12},{14,15},{16,20}};
    solution.intervalIntersection(firstList, secondList);

  }
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int index1 = 0;
    int index2 = 0;
    List<int[]> list = new LinkedList<>();
    while (index1 < firstList.length && index2 < secondList.length) {
      int[] first = firstList[index1];
      int[] second = secondList[index2];
      if (first[0] > second[1]) {
        index2 ++;
        continue;
      }
      if (second[0] > first[1]) {
        index1++;
        continue;
      }
      int left = Math.max(first[0], second[0]);
      int right = Math.min(first[1], second[1]);
      if (first[1] < second[1]) {
        index1++;
      } else if (first[1] > second[1]) {
        index2++;
      } else {
        index1++;
        index2++;
      }
      list.add(new int[] {left, right});
    }
    int[][] res = new int[list.size()][2];
    System.out.println(list.toString());
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
