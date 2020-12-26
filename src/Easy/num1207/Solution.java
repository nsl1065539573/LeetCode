package Easy.num1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int item = map.getOrDefault(arr[i], 0);
            map.put(arr[i], item + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer item:
             map.keySet()) {
            set.add(map.get(item));
        }
        return set.size() == map.size();
    }
}
