package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBSTTest {
    public void insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            while (true) {
                if (value < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(new Node(value));
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else if (value > current.getValue()) {
                    if (current.getRight() == null) {
                        current.setRight(new Node(value));
                        break;
                    } else {
                        current = current.getRight();
                    }
                } else {
                    break; 
                }
            }
        }
    }
}
