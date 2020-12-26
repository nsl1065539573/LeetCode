package demo01;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20, 13, 50, 1, 78, 69, 88, 72, 10};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int X= arr[l];
            while (i < j) {
                while (arr[j] >= X && i < j) {
                    j--;
                }
                arr[i] = arr[j];
                while (arr[i] < X && i < j) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = X;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }
}
