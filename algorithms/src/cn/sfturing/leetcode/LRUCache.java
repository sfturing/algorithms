package cn.sfturing.leetcode;

import java.util.HashMap;

/**
 * 146
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 使用了HashMap+手动实现需要的双向链表
 *
 *
 * 使用HashMap+LinedList也可以实现
 */
public class LRUCache {


    /**
     * HashMap 加双向链表实现LRU
     * LinkedHashMap也可以支持LRU
     */
    HashMap<Integer, Node<Integer, Integer>> Lru;


    DoubleList<Integer, Integer> doubleList;
    /**
     * 容量
     */
    int capc;

    public LRUCache(int capacity) {

        this.capc = capacity;
        /*
        初始化集合
         */
        Lru = new HashMap<>(capacity);
        doubleList = new DoubleList<Integer, Integer>();
    }

    public int get(int key) {
        if (Lru.containsKey(key)) {
            Node<Integer, Integer> node = Lru.get(key);
            Integer v = Lru.get(key).value;
            usedNode(node, key, v);
            return v;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (Lru.containsKey(key)) {
            Node<Integer, Integer> node = Lru.get(key);
            remove(node);
            addNode(key, value);
        } else {
            if (Lru.size() + 1 > capc) {
                removeFirst();
                addNode(key, value);
            } else {
                addNode(key, value);
            }
        }

    }


    /**
     * 无论是put更新数据还是get数据都需要调用此接口
     */
    public void usedNode(Node<Integer, Integer> node, Integer k, Integer v) {
        remove(node);
        addNode(k, v);
    }

    public void removeFirst() {
        Integer k = doubleList.removeFirst();
        Lru.remove(k);
    }

    public void remove(Node<Integer, Integer> node) {
        doubleList.remove(node);
        Lru.remove(node.key);
    }


    public void addNode(Integer k, Integer v) {
        Node<Integer, Integer> newNode = doubleList.addTail(k, v);
        Lru.put(k, newNode);
    }


    static class DoubleList<K, V> {
        Node<K, V> head, tail;

        public DoubleList() {

        }

        /**
         * 向尾部添加元素
         */
        public Node<K, V> addTail(K k, V v) {
            Node<K, V> l = tail;
            Node<K, V> newNode = new Node<>(k, v, l, null);
            if (l == null) {
                head = newNode;
            } else {
                l.after = newNode;
            }
            tail = newNode;
            return newNode;
        }

        /**
         * 删除元素
         */
        public K remove(Node<K, V> node) {
            K k = node.key;
            Node<K, V> b = node.before, a = node.after;
            if (b == null) {
                head = a;
            } else {
                b.after = a;
                node.before = null;
            }
            if (a == null) {
                tail = b;
            } else {
                a.before = b;
                node.after = null;
            }
            return k;

        }

        public K removeFirst() {

            if (head == null) {
                return null;
            }
            K k = head.key;
            Node<K, V> next = head.after;
            if (next == null) {
                tail = null;
            } else {
                next.before = null;
            }
            head = next;

            return k;
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> before, after;

        public Node(K key, V value, Node<K, V> before, Node<K, V> after) {
            this.key = key;
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }


}
