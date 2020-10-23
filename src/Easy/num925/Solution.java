package Easy.num925;

public class Solution {
    public static void main(String[] args) {
        String name = "alex";
        String typed ="alexxr";
        System.out.println(Solution.isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        // step1: 比较两字符串，如果相等，则返回true
        if (name.equals(typed))
            return true;
        // step2: 比较长度，如果typed的长度小于name的长度，返回false
        if (name.length() > typed.length())
            return false;
        // step3: 双指针，比较每个指针对应的字符是否相等
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            if (i + 1 < name.length()) {
                if (name.charAt(i) == name.charAt(i + 1)) {
                    i++;
                    j++;
                } else {
                    for (int k = j; k < typed.length(); k++) {
                        if (typed.charAt(k) != typed.charAt(j)) {
                            j = k;
                            break;
                        }
                    }
                    i++;
                }
            } else {
                i++;
                j++;
            }
            if (i == name.length()) {
                for (int k = j; k < typed.length(); k++) {
                    if (typed.charAt(k) != typed.charAt(j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
