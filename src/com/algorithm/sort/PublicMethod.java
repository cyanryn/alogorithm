package com.algorithm.sort;

import java.util.Arrays;

/**
 * for test
 */
public class PublicMethod {

    public void sort(int[] arr) {
        System.out.println("===");
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i ++) {
//            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] copyArray(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        } else if (arr1 == null || arr2 == null) {
            return false;
        } else if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i ++) {
            if (arr1[i] != arr2[i]) {
                printArr(arr1);
                printArr(arr2);
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void isAlgorithmOK(PublicMethod publicMethodClass) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i ++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            publicMethodClass.sort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "ok" : "false");
    }

}
