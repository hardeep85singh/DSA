package com.example.dsalgo.difficultalgos;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

// Proportional Hashing
public class ConsistentHashing {
    private final int numberOfReplicas;
    private final SortedMap<Integer, String> circle = new TreeMap<>();

    public ConsistentHashing(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hash(node + i), node);
        }
    }

    public void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hash(node + i));
        }
    }

    public String getNode(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes(StandardCharsets.UTF_8));
            return ((digest[0] & 0xFF) << 24) | ((digest[1] & 0xFF) << 16) | ((digest[2] & 0xFF) << 8) | (digest[3] & 0xFF);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.addNode("Node1");
        ch.addNode("Node2");
        ch.addNode("Node3");

        System.out.println("Key1 is mapped to: " + ch.getNode("Key1"));
        System.out.println("Key2 is mapped to: " + ch.getNode("Key2"));
        System.out.println("Key3 is mapped to: " + ch.getNode("Key3"));

        ch.removeNode("Node2");

        System.out.println("After removing Node2:");
        System.out.println("Key1 is mapped to: " + ch.getNode("Key1"));
        System.out.println("Key2 is mapped to: " + ch.getNode("Key2"));
        System.out.println("Key3 is mapped to: " + ch.getNode("Key3"));
    }
}

