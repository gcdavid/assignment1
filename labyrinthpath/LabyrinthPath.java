package labyrinthpath;

class LabyrinthPath {
    // Node class representing each location in the labyrinth
    private static class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head;  // Head of the linked list (start of the path)
    private Node tail;  // Tail of the linked list (end of the path)

    // Constructor to initialize an empty path
    public LabyrinthPath() {
        head = null;
        tail = null;
    }

    // Add a new location to the path (at the end)
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
            tail = newNode; // The new node is also the tail
        } else {
            tail.next = newNode; // Append the new node at the end of the list
            tail = newNode;      // Update the tail reference to the new node
        }
        System.out.println("Added location: " + location);
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("The path is empty. No locations to remove.");
            return;
        }

        if (head == tail) {
            // If there's only one location
            System.out.println("Removed location: " + head.location);
            head = null;
            tail = null;
        } else {
            // Traverse to find the second last node
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            System.out.println("Removed location: " + tail.location);
            current.next = null;  // Remove the last node
            tail = current;       // Update the tail to the second last node
        }
    }

    // Check if the path contains a loop (trap) using Floyd’s Cycle Detection Algorithm
    public boolean containsLoop() {
        if (head == null || head.next == null) {
            return false; // No loop if the list is empty or has only one element
        }

        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head; // Fast pointer moves two steps at a time

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // If slow and fast pointers meet, there is a loop
            }
        }

        return false; // No loop found
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }

        Node current = head;
        System.out.print("Path: ");
        while (current != null) {
            System.out.print(current.location);
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();
        
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Chamber");
        path.addLocation("Secret Room");
        
        // Print the path
        path.printPath();

        // Check if there's a loop
        boolean hasLoop = path.containsLoop();
        System.out.println("Does the path contain a loop? " + hasLoop);
        
        // Remove the last visited location
        path.removeLastLocation();
        
        // Print the path after removal
        path.printPath();
        
        // Add another location
        path.addLocation("Treasure Room");

        // Print the updated path
        path.printPath();
    }
}
