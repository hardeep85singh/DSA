package com.example.dsalgo.protocols;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GossipProtocol {
    public static void main(String[] args) {
        int numNodes = 5;
        List<Node> nodes = new ArrayList<>();

        // Create nodes and add them to the list of known nodes
        for (int i = 0; i < numNodes; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        // Set known nodes for each node (everyone knows everyone in this simple example)
        for (Node node : nodes) {
            List<Node> knownNodes = new ArrayList<>(nodes);
            knownNodes.remove(node); // Remove itself from known nodes
            node.setKnownNodes(knownNodes);
        }

        // Start gossiping threads for each node
        for (Node node : nodes) {
            node.startGossip();
        }

        // Simulate for some time (e.g., 30 seconds)
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final data from each node
        for (Node node : nodes) {
            System.out.println("Node " + node.getNodeId() + " data: " + node.getData());
        }

        // Stop gossiping (in a real scenario, you would need a more graceful shutdown mechanism)
        System.exit(0);
    }

    static class Node {
        private int nodeId;
        private List<Node> knownNodes;
        private String data;

        public Node(int nodeId) {
            this.nodeId = nodeId;
            this.knownNodes = new ArrayList<>();
            this.data = "Initial data";
        }

        public int getNodeId() {
            return nodeId;
        }

        public void setKnownNodes(List<Node> knownNodes) {
            this.knownNodes = knownNodes;
        }

        public void gossip() {
            Random random = new Random();
            while (true) {
                // Select a random node from known nodes (excluding itself)
                Node targetNode = knownNodes.get(random.nextInt(knownNodes.size()));
                // Perform gossip exchange
                exchangeData(targetNode);
                // Sleep for a random interval (simulate periodic gossip)
                try {
                    Thread.sleep(random.nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void exchangeData(Node targetNode) {
            System.out.println("Node " + nodeId + " is gossiping with Node " + targetNode.getNodeId());
            // Simplified example: Exchange and update data
            String newData = "Updated data at " + System.currentTimeMillis();
            this.data = newData;
            targetNode.data = newData;
        }

        public void startGossip() {
            Thread gossipThread = new Thread(this::gossip);
            gossipThread.start();
        }

        public String getData() {
            return data;
        }
    }
}
