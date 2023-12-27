import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList {
    private Node head;

    public UnorderedList() {
        this.head = null;
    }

    public void insert(String word) {
        Node newNode = new Node(word);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean search(String word) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(word)) {
                return true; // Word found
            }
            current = current.next;
        }
        return false; // Word not found
    }

    public void remove(String word) {
        Node current = head;
        Node previous = null;

        while (current != null && !current.data.equals(word)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous != null) {
                previous.next = current.next;
            } else {
                head = current.next;
            }
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void saveToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        Node current = head;
        while (current != null) {
            writer.write(current.data);
            writer.write(" ");
            current = current.next;
        }
        writer.close();
    }
}

public class UnorderedListProgram {
    public static void main(String[] args) {
        UnorderedList wordList = new UnorderedList();
        Scanner scanner = new Scanner(System.in);

        try {
            // Reading words from file
            BufferedReader reader = new BufferedReader(new FileReader("wordList.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordList.insert(word);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Current word list:");
        wordList.display();

        System.out.print("Enter a word to search or add/remove: ");
        String userInput = scanner.next();

        if (wordList.search(userInput)) {
            System.out.println("Word found. Removing...");
            wordList.remove(userInput);
        } else {
            System.out.println("Word not found. Adding...");
            wordList.insert(userInput);
        }

        System.out.println("Updated word list:");
        wordList.display();

        try {
            // Saving the updated word list to file
            wordList.saveToFile("wordList.txt");
            System.out.println("Word list saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
