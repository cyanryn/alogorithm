package com.algorithm.sort;

/**
 * 快速排序：不稳定
 *   - 时间复杂度：O(n*log n)
 *   - 空间复杂度： O(log n)
 */
public class QuickSort extends PublicMethod{
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while(L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++ less, L ++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, -- more);
            } else {
                L ++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr);
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 5, 3, 8, 10, 2, 1, 5};
        PublicMethod.isAlgorithmOK(new QuickSort());
    }
}
