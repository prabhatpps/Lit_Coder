import java.util.*;

public class Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomStack editor = new CustomStack();

        String[] commands = input.nextLine().split(",");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmd = Integer.parseInt(parts[0]);

            if (cmd == 1) {
                editor.insert(parts[1]);
            } else if (cmd == 2) {
                editor.delete(Integer.parseInt(parts[1]));
            } else if (cmd == 3) {
                System.out.println(editor.get(Integer.parseInt(parts[1])));
            } else if (cmd == 4) {
                editor.undo();
            }
        }
    }
}

class CustomStack {
    private StringBuilder text;
    private Stack<Operation> history;

    public CustomStack() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    public void insert(String value) {
        // Save the operation type and the actual value inserted
        history.push(new Operation(1, value));
        text.append(value); // Append the value to the text
    }

    public void delete(int value) {
        // Get the deleted portion
        String deleted = text.substring(Math.max(0, text.length() - value));
        history.push(new Operation(2, deleted)); // Save the operation type and deleted string
        text.delete(Math.max(0, text.length() - value), text.length()); // Delete the last 'value' characters
    }

    public char get(int index) {
        return text.charAt(index - 1); // Get the character at the specified index (1-based)
    }

    public void undo() {
        if (!history.isEmpty()) {
            Operation last = history.pop();
            if (last.type == 1) {
                // If the last operation was an insert, delete the inserted characters
                text.delete(text.length() - last.value.length(), text.length());
            } else {
                // If the last operation was a delete, reinsert the deleted characters
                text.append(last.value);
            }
        }
    }
}

class Operation {
    int type; // Type of operation: 1 for insert, 2 for delete
    String value; // The value associated with the operation

    Operation(int type, String value) {
        this.type = type;
        this.value = value; // Store the actual string for both insert and delete operations
    }
}