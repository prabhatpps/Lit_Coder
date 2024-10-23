import java.util.Scanner;
import java.util.Stack;

class CustomQueue {
    private Stack<Integer> stack1;  // Stack for enqueue operations
    private Stack<Integer> stack2;  // Stack for dequeue operations

    public CustomQueue() {
        stack1 = new Stack<>();  // Initialize the first stack
        stack2 = new Stack<>();  // Initialize the second stack
    }

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);  // Push the element onto stack1
    }

    // Dequeue operation
    public void dequeue() {
        if (stack2.isEmpty()) {
            // Move elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();  // Remove the element from the front of the queue
        }
    }

    // Print the front element of the queue
    public void printFront() {
        if (stack2.isEmpty()) {
            // Move elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());  // Print the front element
        }
    }
}

public class Queue_using_Two_Stacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();

        String input = scanner.nextLine();  // Read all commands

        // Split input commands
        String[] commands = input.split(",");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int commandType = Integer.parseInt(parts[0]);  // Get command type

            switch (commandType) {
                case 1:
                    // Enqueue command
                    int value = Integer.parseInt(parts[1]);  // Get value to enqueue
                    queue.enqueue(value);
                    break;
                case 2:
                    // Dequeue command
                    queue.dequeue();
                    break;
                case 3:
                    // Print front command
                    queue.printFront();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }

        scanner.close();
    }
}
