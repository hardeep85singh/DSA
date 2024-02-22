package com.example.dsalgo.linkedlist;

/**
 * @author Hardeep Singh
 */
//@Service
public class SinglyLinkedList {
    private static int size;
    private static Node headNode;

    public static class Node{
        int data;
        Node next;

        public Node(){}
        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public SinglyLinkedList(){}

    public SinglyLinkedList(Node node){
        this.headNode = node;
    }

    public int listLength(){
        int length = 0;
        Node currentNode = headNode;

        while (currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        size = length;
        return length;
    }

    public void insertAtBeginning(Node node){
        if(headNode == null){
            headNode = node;
            node.next = null;
        } else{
            node.next = headNode;
            headNode = node;
        }
    }

    public void insertAtEnd(Node node){

        if(headNode == null){
            headNode = node;
            headNode.next = null;
        } else{
            Node currentNode = headNode;
            while(currentNode.next != null){
                currentNode = currentNode.next;
                if(currentNode.next == null){
                    currentNode.next = node;
                    node.next = null;
                    currentNode = node;
                }
            }
        }
    }

    public void insertInMiddle(Node node){
        Node singleRunner = headNode;
        Node doubleRunner = headNode.next;

        if(headNode == null){
            headNode = node;
            node.next = null;
        } else {
            while(doubleRunner.next != null || doubleRunner.next.next != null){
                singleRunner = singleRunner.next;
                doubleRunner = doubleRunner.next.next;

                if(doubleRunner.next == null || doubleRunner.next.next == null){
                    node.next = singleRunner.next;
                    singleRunner.next = node;
                    return;
                }

            }

        }
    }

    public Node deleteFromBeginning(){
        Node node = headNode;
        if(node != null){
            headNode = node.next;
            node.next = null;
        }
        return node;
    }

    public Node deleteFromEnd(){
        Node node = headNode;
        if(headNode == null){
            throw new IllegalArgumentException("List is empty");
        } else {
            while(node.next != null){
                if(node.next.next == null){
                    node.next = null;
                    return node;
                }
                node = node.next;
            }
        }
        return node;
    }

    public Node deleteFromMiddle(){
        Node SR = headNode;
        Node DR = headNode.next;
        if(headNode == null){
            throw new IllegalArgumentException("List is empty");
        } else if(headNode.next == null){
            headNode = null;
        }else{
            while(DR.next != null || DR.next.next != null){
                SR = SR.next;
                DR = DR.next.next;
                if(DR.next == null || DR.next.next == null){
                    Node temp = SR.next;
                    SR.next = temp.next;
                    temp.next = null;
                    return temp;
                }

            }

        }
        return null;
    }

    public Node lastNode(){
        Node node = headNode;
        if(headNode == null){
            throw new IllegalArgumentException("No last node present");
        } else {
            while (node.next != null){
                node = node.next;
            }
        }
        return node;
    }

    public void printList(){
        Node node = headNode;
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }
}
