package com.algorithm.sort;

import java.util.PriorityQueue;

/**
 * 堆排序：不稳定
 *   - 时间复杂度：O(n*log n)
 *   - 空间复杂度： O(1)
 */
public class Heap extends PublicMethod{
    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while(left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] < arr[index] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        // 时间复杂度O(n*logN)
        for(int i = 0; i < arr.length; i ++) {//O(n)
            heapInsert(arr, i);//O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapSort2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        // 时间复杂度O(n)
        for (int i = arr.length - 1; i >= 0; i --) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    @Override
    public void sort(int[] arr) {
        heapSort(arr);
    }

    public static void main(String[] args) {
        PublicMethod.isAlgorithmOK(new Heap());
    }
}
