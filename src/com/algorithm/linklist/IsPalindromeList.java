package com.algorithm.linklist;

import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 *      要求（时间复杂度O(n)，空间复杂度O(1)）
 */
public class IsPalindromeList {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // need n extra space
    public static boolean isPalindromeList1(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node other = root;
        while(other != null) {
            stack.push(other);
            other = other.next;
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.value != root.value) {
                return false;
            }
            root = root.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindromeList3(Node root) {
        if (root == null || root.next == null) {
            return true;
        }
        Node slow = root, fast = root;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow);
        slow = fast;
        boolean res = true;
        while(root != null && slow != null) {
            if (root.value != slow.value) {
                res = false;
                break;
            }
            root = root.next;
            slow = slow.next;
        }
        reverseList(fast);
        return res;
    }

    public static Node reverseList(Node head) {
        Node prev = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printLinkedList(Node root) {
        while(root != null) {
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + "|");
        System.out.println(isPalindromeList3(head) + "|");
        printLinkedList(head);

        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
    }
}
