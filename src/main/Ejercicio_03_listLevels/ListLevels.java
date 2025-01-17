package main.Ejercicio_03_listLevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.materia.Models.Node;

// Implemeta un algoritmo que devuelva una lista enlazada
// con los nodos de cada nivel. Si el arbol tiene N niveles
// debes devolver N listas enlazadas.

// Ejemplo:
//      4
//    2   7
//  1  3  6  9

// Output:
// 4
// 2 -> 7
// 1 -> 3 -> 6 -> 9

public class ListLevels {
    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node);

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                
            }
            levels.add(currentLevel);
        }
        return levels;
    }

    public void printLevels(List<List<Node>> levels) {
        for (List<Node> level : levels) {
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i).getValue());
                if (i < level.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
}
