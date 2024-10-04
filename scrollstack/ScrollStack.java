package scrollstack;

import java.util.Stack;

public class ScrollStack {
    // Internal stack to hold the scrolls
    private Stack<String> stack;

    // Constructor to initialize the stack
    public ScrollStack() {
        this.stack = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void push(String scroll) {
        stack.push(scroll);
        System.out.println("Scroll \"" + scroll + "\" added to the stack.");
    }

    // Pop the top scroll off the stack
    public String pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty. No scrolls to remove.");
            return null;
        }
        String removedScroll = stack.pop();
        System.out.println("Scroll \"" + removedScroll + "\" removed from the stack.");
        return removedScroll;
    }

    // Peek at the top scroll without removing it
    public String peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty. No scrolls to peek at.");
            return null;
        }
        return stack.peek();
    }

    // Check if a specific scroll title exists in the stack
    public boolean contains(String scroll) {
        return stack.contains(scroll);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Create a ScrollStack object
        ScrollStack scrollStack = new ScrollStack();

        // Add scrolls
        scrollStack.push("Scroll of Wisdom");
        scrollStack.push("Scroll of Fire");
        scrollStack.push("Scroll of Water");

        // Peek at the top scroll
        System.out.println("Top scroll: " + scrollStack.peek());  // Output: Scroll of Water

        // Check if a specific scroll exists
        System.out.println("Contains 'Scroll of Fire'? " + scrollStack.contains("Scroll of Fire"));  // Output: true

        // Remove the top scroll
        scrollStack.pop();

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + scrollStack.isEmpty());  // Output: false
    }
}
