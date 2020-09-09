package com.algorithm.sort;

/**
 * 选择排序: 不稳定
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度： O(1)
 */
public class Selection extends PublicMethod {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

//        有坑：当arr[i]与arr[j]相等时，有个数会被置为0
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }



    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void sort(int[] arr) {
        selectionSort(arr);
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;

        int[] arr = PublicMethod.generateRandomArray(maxSize, maxValue);
        selectionSort(arr);
        printArr(arr);

        PublicMethod.isAlgorithmOK(new Selection());
    }
}
