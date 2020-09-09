package com.algorithm.sort;

import java.util.PriorityQueue;

/**
 * 堆排序算法，每个元素移动的距离不能超过k
 */
public class SortByLessDistance {
    public static void sortArrDistanceLess(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        for(; index<= Math.min(arr.length, k); index ++) {
            queue.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; index ++) {
            queue.add(arr[index]);
            arr[i] = queue.poll();
        }
        while(!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }
    }

    public static void main(String[] args) {

    }
}
