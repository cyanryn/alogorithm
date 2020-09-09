package com.algorithm.linklist;

import java.util.LinkedList;

/**
 * 反转单向链表或双向链表（要求时间O(n)， 空间复杂度O(1)）
 */
public class ReverseLinkedList {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node singleReverse(Node root) {
        Node cur = null;
        Node next = null;

        while(root != null) {
            next = root.next;
            root.next = cur;
            cur = root;
            root = next;
        }

        return cur;
    }

    public static void printLinkedList(Node root) {
        while(root != null) {
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.println();
    }

    public static class DoubleNode {
        int value;
        DoubleNode prev;
        DoubleNode next;
         public DoubleNode(int value) {
             this.value = value;
         }
    }

    public static DoubleNode doubleReverse(DoubleNode root) {
        DoubleNode prev = null;
        DoubleNode next = null;
        while(root != null) {
            next = root.next;
            root.next = root.prev;
            root.prev = next;
            prev = root;
            root = next;
        }
        return prev;
    }

    public static void printDoubleLinkedList(DoubleNode root) {
        DoubleNode end = null;
        while(root != null) {
            System.out.print(root.value + "->");
            end = root;
            root = root.next;
        }
        System.out.print('|');
        while(end != null) {
            System.out.print(end.value + "->");
            end = end.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = singleReverse(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.prev = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.prev = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.prev = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(doubleReverse(head2));
    }
}
