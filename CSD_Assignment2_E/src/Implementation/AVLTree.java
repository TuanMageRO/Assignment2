/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementation;

import Object.Node;
import Object.Train;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    private Node root;

    // Insert into AVL Tree
    public void insert(Train train) {
        root = insertRec(root, train);
    }

    private Node insertRec(Node node, Train train) {
        if (node == null) {
            return new Node(train);
        }

        if (train.getTCode().compareTo(node.data.getTCode()) < 0) {
            node.left = insertRec(node.left, train);
        } else if (train.getTCode().compareTo(node.data.getTCode()) > 0) {
            node.right = insertRec(node.right, train);
        } else {
            return node; // No duplicate tCode
        }

        return balance(node);
    }

    private Node balance(Node node) {
        int balanceFactor = height(node.left) - height(node.right);

        if (balanceFactor > 1) {
            if (height(node.left.left) >= height(node.left.right))
                node = rightRotate(node);
            else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (height(node.right.right) >= height(node.right.left))
                node = leftRotate(node);
            else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    // Delete by tCode (Copying Method)
    public void deleteByCopying(String tCode) {
        root = deleteByCopyingRec(root, tCode);
    }

    private Node deleteByCopyingRec(Node node, String tCode) {
        if (node == null) return null;

        if (tCode.compareTo(node.data.getTCode()) < 0) {
            node.left = deleteByCopyingRec(node.left, tCode);
        } else if (tCode.compareTo(node.data.getTCode()) > 0) {
            node.right = deleteByCopyingRec(node.right, tCode);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = getMinNode(node.right);
            node.data = successor.data;
            node.right = deleteByCopyingRec(node.right, successor.data.getTCode());
        }
        return balance(node);
    }

    // Find the minimum node (used for copying deletion)
    private Node getMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Load data from file
    public void loadFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 8) {
                    Train train = new Train(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4], parts[5], parts[6], parts[7]);
                    insert(train);
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Save data to file
    public void saveFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            saveRec(bw, root);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    private void saveRec(BufferedWriter bw, Node node) throws IOException {
        if (node != null) {
            bw.write(node.data.toString() + "\n");
            saveRec(bw, node.left);
            saveRec(bw, node.right);
        }
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }

    // Breadth-first traversal
    public void breadthFirst() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // Search for a train by tCode
    public Train search(String tCode) {
        return searchRec(root, tCode);
    }

    private Train searchRec(Node node, String tCode) {
        if (node == null) return null;
        if (tCode.equals(node.data.getTCode())) return node.data;
        if (tCode.compareTo(node.data.getTCode()) < 0)
            return searchRec(node.left, tCode);
        else
            return searchRec(node.right, tCode);
    }

    // Count number of trains
    public int countTrains() {
        return countRec(root);
    }

    private int countRec(Node node) {
        if (node == null) return 0;
        return 1 + countRec(node.left) + countRec(node.right);
    }

    // Simple balancing (re-balance entire tree)
    public void simpleBalancing() {
        // Perform a rebalancing of the tree (can involve converting tree to sorted array and re-inserting)
        // This method can be implemented with different rebalancing techniques as required.
    }
}

