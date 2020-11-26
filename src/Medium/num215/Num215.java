package Medium.num215;

import java.util.PriorityQueue;

public class Num215{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(nums[i]);
            } else {
                if (queue.size() < k) {
                    if (nums[i] > queue.peek()) {
                        queue.offer(nums[i]);
                    }
                } else {
                    if (nums[i] > queue.peek()) {
                        queue.offer(nums[i]);
                        queue.poll();
                    }
                }

            }
        }
        System.out.println(queue);
        return queue.peek();
    }
}