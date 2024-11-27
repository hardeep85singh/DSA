package com.example.dsalgo.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        private Node next;
        private Node prev;
        private final String key;
        private String value;

        public Node (String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private final Map<String, Node> map;
    private Node head = null;
    private Node tail = null;
    private final int CACHE_SIZE = 5;
    private final int size;

    public LRUCache(int size){
        this.map = new HashMap<>();
        this.size = size;
    }

    public String get(String key){
        if(!map.containsKey(key)){
            return null;
        }

        Node node = map.get(key);

        deleteFromList(node);
        setListHead(node);

        return node.value;
    }

    public void put(String key, String value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteFromList(node);
            setListHead(node);
        } else {
            if(map.size() >= size){
                map.remove(tail.key);
                deleteFromList(tail);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            setListHead(node);
        }
    }

    private void deleteFromList(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // If the node is the head, update the head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // If the node is the tail, update the tail
        }

        node.prev = null;
        node.next = null;
    }

    private void setListHead(Node node) {
        if (head != null) {
            head.prev = node;
        }

        node.next = head;
        node.prev = null;
        head = node;

        if (tail == null) {
            tail = node; // If the list was empty, set tail to the new node
        }
    }
}
