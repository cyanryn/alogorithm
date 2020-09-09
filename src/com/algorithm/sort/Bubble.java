package com.algorithm.sort;

/**
 * 冒泡排序：稳定
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度： O(1)
 */
public class Bubble extends PublicMethod {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = 0; j < arr.length - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j , j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    // for test
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void sort(int[] arr) {
        bubbleSort(arr);
    }

    // for test
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);

        PublicMethod.isAlgorithmOK(new Bubble());
    }
}
