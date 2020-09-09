package com.algorithm.sort;

/**
 * 插入排序：稳定
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度： O(1)
 */
public class Insertion extends PublicMethod {

    public static void insertinonSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = i; j >= 0; j --) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] != arr[j]) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    @Override
    public void sort(int[] arr) {
        insertinonSort(arr);
    }

    public static void main(String[] args) {
        PublicMethod.isAlgorithmOK(new Insertion());

        int[] arr = PublicMethod.generateRandomArray(100, 100);
        insertinonSort(arr);
        PublicMethod.printArr(arr);
    }
}
