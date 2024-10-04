package explorerqueue;

class ExplorerQueue {
    private String[] queue;  // Array to hold explorer names
    private int front;       // Points to the front of the queue
    private int rear;        // Points to the rear of the queue
    private int size;        // Current number of explorers in the queue
    private int capacity;    // Maximum capacity of the queue

    // Constructor to initialize the queue with a specified capacity
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue a new explorer into the queue
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add explorer: " + explorer);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = explorer;
        size++;
        System.out.println("Explorer \"" + explorer + "\" added to the queue.");
    }

    // Dequeue the explorer when they enter the temple
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers to dequeue.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Explorer \"" + explorer + "\" has entered the temple and left the queue.");
        return explorer;
    }

    // Display the next explorer in line without removing them
    public String peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers to display.");
            return null;
        }
        return queue[front];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Create a queue with a capacity of 3
        ExplorerQueue explorerQueue = new ExplorerQueue(3);

        // Add explorers
        explorerQueue.enqueue("Explorer A");
        explorerQueue.enqueue("Explorer B");
        explorerQueue.enqueue("Explorer C");

        // Try to add another explorer to a full queue
        explorerQueue.enqueue("Explorer D");  // Output: The queue is full.

        // Show the next explorer in line
        System.out.println("Next explorer in line: " + explorerQueue.peek());  // Output: Explorer A

        // Remove explorers from the queue
        explorerQueue.dequeue();
        explorerQueue.dequeue();

        // Check the next explorer after some have entered the temple
        System.out.println("Next explorer in line: " + explorerQueue.peek());  // Output: Explorer C

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + explorerQueue.isEmpty());  // Output: false
    }
}
