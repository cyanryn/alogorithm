package com.algorithm.linklist;

import java.util.*;

/**
 * HashSet, HashMap 哈希表
 * TreeSet, TreeMap 有序表
 */
public class HashAndTree {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }

    }

    public static void main(String[] args) {
        // 1
//        HashSet<Integer> hashSet1 = new HashSet<>();
//        hashSet1.add(3);
//        System.out.println(hashSet1.contains(3));
//        hashSet1.remove(3);
//        System.out.println(hashSet1.contains(3));

        // 2
//        HashMap<Integer, String> mapTest = new HashMap<>();
//        mapTest.put(1, "zuo");
//        mapTest.put(1, "cheng");
//        mapTest.put(2, "2V");
//
//        System.out.println(mapTest.containsKey(1));
//        System.out.println(mapTest.get(1));
//        System.out.println(mapTest.get(4));
//
//        mapTest.remove(2);
//        System.out.println(mapTest.get(2));

        Node nodeA = null;
        Node nodeB = null;
        Node nodeC = null;

        // 3
//        nodeA = new Node(1);
//        nodeB = new Node(1);
//        HashSet<Node> hashSet2 = new HashSet<>();
//        hashSet2.add(nodeA);
//        System.out.println(hashSet2.contains(nodeA));
//        System.out.println(hashSet2.contains(nodeB));
//        hashSet2.remove(nodeA);
//        System.out.println(hashSet2.contains(nodeA));

        //4
//        HashMap<String, Integer> hashMap1 = new HashMap<>();
//        String str1 = "key";
//        String str2 = "key";
//        hashMap1.put(str1, 1);
//        System.out.println(hashMap1.containsKey(str1));
//        System.out.println(hashMap1.containsKey(str2));
//        System.out.println(hashMap1.get(str1));
//        System.out.println(hashMap1.get(str2));
//
//        hashMap1.put(str2, 2);
//        System.out.println(hashMap1.containsKey(str1));
//        System.out.println(hashMap1.containsKey(str2));
//        System.out.println(hashMap1.get(str1));
//        System.out.println(hashMap1.get(str2));
//
//        hashMap1.remove(str1);
//        System.out.println(hashMap1.containsKey(str1));
//        System.out.println(hashMap1.containsKey(str2));

        //5
//        nodeA = new Node(1);
//        nodeB = new Node(1);
//        HashMap<Node, String> hashMap2 = new HashMap<>();
//        hashMap2.put(nodeA, "A节点");
//        System.out.println(hashMap2.containsKey(nodeA));
//        System.out.println(hashMap2.containsKey(nodeB));
//        System.out.println(hashMap2.get(nodeA));
//        System.out.println(hashMap2.get(nodeB));
//        hashMap2.put(nodeB, "B节点");
//        System.out.println(hashMap2.containsKey(nodeA));
//        System.out.println(hashMap2.containsKey(nodeB));
//        System.out.println(hashMap2.get(nodeA));
//        System.out.println(hashMap2.get(nodeB));

        //6
//        nodeA = new Node(5);
//        nodeB = new Node(3);
//        nodeC = new Node(7);
//
//        TreeSet<Node> treeSet = new TreeSet<>(new NodeComparator()); // 红黑树
//        // 以下的代码会报错，因为没有提供Node类型的比较器
//        try {
//            treeSet.add(nodeA);
//            treeSet.add(nodeB);
//            treeSet.add(nodeC);
//        } catch (Exception e) {
//            System.out.println("错误信息：" + e.getMessage());
//        }
//
//        treeSet = new TreeSet<>(new NodeComparator());
//        // 以下的代码没问题，因为提供了Node类型的比较器
//        try {
//            treeSet.add(nodeA);
//            treeSet.add(nodeB);
//            treeSet.add(nodeC);
//            System.out.println("这次节点都加入了");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        //7
        // 展示有序表常用操作
//        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
//        treeMap1.put(7, "我是7");
//        treeMap1.put(5, "我是5");
//        treeMap1.put(4, "我是4");
//        treeMap1.put(3, "我是3");
//        treeMap1.put(9, "我是9");
//        treeMap1.put(2, "我是2");
//        System.out.println(treeMap1.containsKey(5));
//        System.out.println(treeMap1.get(5));
//        System.out.println(treeMap1.firstKey() + ", 我最小");
//        System.out.println(treeMap1.lastKey() + ", 我最大");
//        System.out.println(treeMap1.floorKey(8) + ", 在表中所有<=8的数中，我离8最近");
//        System.out.println(treeMap1.ceilingKey(8) + ", 在表中所有>=8的数中，我离8最近");
//        System.out.println(treeMap1.floorKey(7) + ", 在表中所有<=7的数中，我离7最近");
//        System.out.println(treeMap1.ceilingKey(7) + ", 在表中所有>=7的数中，我离7最近");
//        treeMap1.remove(5);
//        System.out.println(treeMap1.get(5) + ", 删了就没有了哦");

        //8
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 1);
        map.put("e", 3);
        map.put("f", 1);

        List<String> removeKeys = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value.equals(1)) {
                removeKeys.add(key);
            }
        }

        for(String key : removeKeys) {
            map.remove(key);
        }

        System.out.println(map.size());
    }
}
