package com.algorithm.sort;

/**
 * 归并排序: 稳定
 *  - 时间复杂度：O(n*log n)
 *  - 空间复杂度： O(n)
 */
public class MergeSort extends PublicMethod {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        _mergeSort(arr, 0, arr.length - 1);
    }

    public static void _mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        _mergeSort(arr, left, middle);
        _mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = middle + 1;
        int i = 0;
        while (p1 <= middle && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j ++) {
            arr[left + j] = help[j];
        }
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr);
    }

    public static void main(String[] args) {
        PublicMethod.isAlgorithmOK(new MergeSort());
    }
}
