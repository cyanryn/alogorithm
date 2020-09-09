package com.algorithm.linklist;

/**
 * 打印两个有序链表的公共部分
 *  （要求：时间复杂度O(n)，空间复杂度O(1)）
 */
public class PrintCommonPart {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node printCommonPart(Node node1, Node node2) {
        Node start = null, end = null;
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                node1 = node1.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
//                System.out.print(node1.value + "->");
                if (start == null) {
                    start = end = node1;
                } else {
                    start.next = node1;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
//        System.out.println();
        end.next.next = null;
        return start;
    }

    public static void printLinkedList(Node root) {
        while(root != null) {
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printLinkedList(printCommonPart(node1, node2));

    }
}
