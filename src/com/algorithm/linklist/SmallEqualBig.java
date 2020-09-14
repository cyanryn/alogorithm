package com.algorithm.linklist;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *      要求：时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 */
public class SmallEqualBig {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // need O(n) extra space
    public static Node partitionList1(Node root, int target) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        int i = 0;
        while(cur != null) {
            i ++;
            cur = cur.next;
        }
        Node[] arr = new Node[i];
        i = 0;
        cur = root;
        while(cur != null) {
            arr[i++] = cur;
            cur = cur.next;
        }
        arrPartition(arr, target);
        for (i = 1; i < arr.length; i ++) {
            arr[i - 1].next = arr[i];
        }
        arr[i - 1].next = null;
        return arr[0];
    }

    public static void arrPartition(Node[] arr, int target) {
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while(cur < more) {
            if (arr[cur].value < target) {
                swap(arr, ++ less, cur ++);
            } else if (arr[cur].value > target) {
                swap(arr, -- more, cur);
            } else {
                cur ++;
            }
        }
    }

    public static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // // need O(1) extra space
    public static Node partitionList2(Node root, int target) {
        Node sH = null,
             sT = null,
             eH = null,
             eT = null,
             bH = null,
             bT = null,
             next;
        while(root != null) {
            next = root.next;
            root.next = null;
            if (root.value < target) {
                if (sH == null) {
                    sH = sT = root;
                } else {
                    sT.next = root;
                    sT = root;
                }
            } else if (root.value == target) {
                if (eH == null) {
                    eH = eT = root;
                } else {
                    eT.next = root;
                    eT = root;
                }
            } else {
                if (bH == null) {
                    bH = bT = root;
                } else {
                    bT.next = root;
                    bT = root;
                }
            }
            root = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH :bH);
    }

    public static void printList(Node root) {
        while(root != null) {
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
//        printList(head1);
//        printList(partitionList2(head1, 5));
        printList(head1);
        printList(partitionList1(head1, 5));
    }
}
