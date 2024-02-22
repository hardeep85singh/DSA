package com.example.dsalgo.linkedlist;

/**
 * @author Hardeep Singh
 */
//@Service
public class DoublyLinkedList {

    public Node head;

    public static class Node{
        public int data;
        public Node next;
        public Node previous;

        public Node(int data){
            this.data = data;
        }
    }

    public void insertAtBeginning(Node node){
        if ( head == null){
            head = node;
            head.next = null;
            head.previous = null;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
            head.previous = null;
        }
    }

    public void insertAtEnd(Node node){
        if ( head == null){
            head = node;
            head.next = null;
            head.previous = null;
        } else{
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
                if(currentNode.next == null){
                    currentNode.next = node;
                    node.previous = currentNode;
                    node.next = null;
                    currentNode = node;
                }
            }
        }
    }
    public int insertAfterGivenNode(Node node, int index){
        Node currentNode = head;
        int i = 1;
        while(i <= index){
            currentNode = currentNode.next;
            i++;
            if(i == index){
                node.next = currentNode.next;
                node.previous = currentNode;
                currentNode.next = node;
                currentNode.next.previous = node;
                currentNode = node;
                i++;
            }
        }
        return i;
    }
    public int insertBeforeGivenNode(Node node, int index){
        Node currentNode = head;
        int i = 1;
        while(i < index){
            currentNode = currentNode.next;
            i++;
            if(i == index){
                node.next = currentNode;
                node.previous = currentNode.previous;
                currentNode.previous.next = node;
                currentNode.previous = node;
                currentNode = node;
                i++;
            }
        }
        return i-1;
    }
    public Node deleteFromBeginning(){
        if(head == null){
            throw new IllegalArgumentException("No element present in list to delete");
        } else {
            Node temp = head;
            head = temp.next;
            head.previous = null;
            return temp;
        }
    }
    public Node deleteFromEnd(){
        if(head == null){
            throw new IllegalArgumentException("No element present in list to delete");
        } else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
                if(temp.next == null){
                    temp.previous.next = null;
                    return temp;
                }
            }
        }
        return null;
    }
    public Node deleteAfterGivenNode(int index){
        if(head == null){
            throw new IllegalArgumentException("No element present in list to delete");
        } else {
            Node currentNode = head;
            int i = 1;
            while (i <= index) {

                if (i == index) {

                    //condition for currentNode.next == null
                    Node temp = currentNode.next;
                    currentNode.next = temp.next;
                    temp.next.previous = currentNode;
                    temp.next = null;
                    temp.previous = null;
                    return temp;
                }
                currentNode = currentNode.next;
                i++;
            }
        }
        return null;
    }
    public Node deleteBeforeGivenNode(int index){
        if(head == null){
            throw new IllegalArgumentException("No element present in list to delete");
        }
        return null;
    }

    public void printList(){
        DoublyLinkedList.Node node = head;
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }
}
