import java.util.*;

// Node class for Huffman Tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '\0'; // internal node
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanEncoding {

    // Function to generate Huffman Codes by traversing the tree
    static void generateCodes(Node root, String code) {
        if (root == null) return;

        // If it's a leaf node → print the character and its code
        if (root.left == null && root.right == null && root.ch != '\0') {
            System.out.println(root.ch + ": " + code);
            return;
        }

        // Traverse left as '0' and right as '1'
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        // Input characters and their frequencies
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };

        // PriorityQueue (min-heap) based on frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        // Step 1: Create leaf nodes and add to min-heap
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Step 2: Build the Huffman Tree (Greedy approach)
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new internal node with sum of frequencies
            Node newNode = new Node(left.freq + right.freq, left, right);
            pq.add(newNode);
        }

        // Step 3: Root of the Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes for given characters:\n");
        generateCodes(root, "");
    }
}
