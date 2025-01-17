package main.materia.Controllers;

import main.materia.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value) {
        System.out.println("*Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value) {
        if (nodo == null) {
            Node newNodo = new Node(value);
            newNodo.setHeight(1);
            return newNodo;
        }
        if (value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));
        } 
        else if (value > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));
        } 
        else {
            return nodo;
        }
        nodo.setHeight(1 +
            Math.max(
                height(nodo.getLeft()), 
                height(nodo.getRight())));

        // Obtener el balance o factor de equilibrio del nodo ancestro
        int balance = getBalance(nodo);

        // Caso Izquierda - Izquierda
        if (balance > 1 && value < nodo.getLeft().getValue()) {
            return rightRotate(nodo);
        }
            
        // Caso Derecha - Derecha
        if (balance < -1 && value > nodo.getRight().getValue()) {
            return leftRotate(nodo);  
        }
            
        // Caso Izquierda - Derecha
        if (balance > 1 && value > nodo.getLeft().getValue()) {
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);                
        }
            
        // Caso Derecha - Izquierda
        if (balance < -1 && value < nodo.getRight().getValue()) {
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }
            
        // Davolvemos el nodo sin cambios
        return nodo;
    }
            
    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: " + y.getValue());

        // Realizamos las rotaciones
        x.setRight(y);
        y.setLeft(temp);

        // Actualizamos las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raiz despues de la rotacion: " + x.getValue());

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Left rotate on node: " + x.getValue());

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        System.out.println("Nueva aiz despues de rotacion izquierda: " + y.getValue());

        return y;
    }
            
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
    
    public void printTree(){
        printTree(root, " ", true);

        
    }

    public void printTree(Node node, String prefix, boolean isLeft){
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null  || node.getRight() != null){
                if (node.getLeft() != null){
                    printTree(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                }else{
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }

                if (node.getRight() != null){
                    printTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                }else{
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
            }
        }
        
    }

    public Node getRoot() {
        return root;
    }
}
