/*
Joseph Spicer
12/06/2024
Queue.java
Generic Queue class that implements basic queue operations. It uses a linked list structure
where each node contains data and a reference to the next node.
 */

public class Queue<T> {
    private Node<T> front; // Front node of the queue
    private Node<T> rear; // Rear node of the queue
    private int size; // Current size of the queue

    // Constructor initialize on empty queue
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // Adds an element to the end of the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data); //Create a new node with the provided data
        if (rear != null) {
            rear.next = newNode; // If rear exists, link it to the new node
        }
        rear = newNode; // Move rear to the new node
        if (front == null) {
            front = newNode; // If the queue was empty, set front to the new node
        }
        size++; // // Increase the size of the queue
    }

    // Removes and returns the front element of the queue
    // Returns null if the queue is empty
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data; // Return the dequeued data
    }

    // Returns the front element of the queue without removing it
    // Returns null if the queue is empty
    public T peek() {
        return isEmpty() ? null : front.data; // Return the front element or null
    }

    // Returns the current size of the queue
    public int size() {
        return size;
    }

    // Node class represents each element in the queue
    private static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Reference to the next node in the queue

        Node(T data) {
            this.data = data;
            this.next = null; // Initialize next to null
        }
    }
}
