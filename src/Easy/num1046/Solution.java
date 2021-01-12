package Easy.num1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int lastStoneWeight(int[] stones) {
    if (stones.length == 0) {
      return 0;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int i: stones) {
      queue.offer(i);
    }
    while (queue.size() > 1) {
      int a = queue.poll();
      int b = queue.poll();
      int res = Math.abs(a - b);
      if (res > 0) {
        queue.offer(res);
      }
    }
    if (queue.size() == 1) {
      return queue.peek();
    }
    return 0;
  }
}
