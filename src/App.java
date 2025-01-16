import java.util.List;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        //runArvolAvl();
        runEjercicio1();
        runEjercicio2();
        runEjercicio3();
        runEjercicio4();
    }

    public static void runArbolBinario() {
        ArbolBinario arbol = new ArbolBinario();
        ArbolRecorridos recorridos = new ArbolRecorridos();

        int [] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};
        
        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("Arbol:");
        arbol.printTree();

        System.out.println("\nRecorrido Preorden (Iterativo):");
        recorridos.preOrderIterativo(arbol.getRoot());

        System.out.println("\nRecorrido Preorden (Recursivo):");
        recorridos.preOrderRecursivo(arbol.getRoot());

        System.out.println("\nRecorrido Inorden (Recursivo):");
        recorridos.inOrderRecursivo(arbol.getRoot());

        System.out.println("\nRecorrido Postorden (Recursivo):");
        recorridos.postOrderRecursivo(arbol.getRoot());
    }
    
    private static void runEjercicio3() {
        ArbolBinario arbol = new ArbolBinario();
        ListLevels listLevels = new ListLevels(); 

        int[] valores = {4, 2, 7, 1, 3, 6, 9};

        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("\n*************EJERCICIO-#3*************");
        System.out.println("Arbol:");
        arbol.printTree();

        System.out.println("Niveles del arbol:");
        List<List<Node>> levels = listLevels.listLevels(arbol.getRoot());

        listLevels.printLevels(levels);
    }

    /*private static void runArvolAvl() {
        ArbolAVL arbolavl = new ArbolAVL();
        int[] values = {10, 20, 15, 24, 9, 8, 21, 23, 50, 25};

        for (int i = 0; i < values.length; i++) {
            arbolavl.insert(values[i]);
            arbolavl.printTree();
        }
    }*/

    private static void runEjercicio1() {
        ArbolBinario arbol = new ArbolBinario();
        InsertBSTTest insertBSTTest = new InsertBSTTest();

        int[] valores = {5, 3, 7, 2, 4, 6, 8};

        Node root = new Node(valores[0]);
        for (int i = 1; i < valores.length; i++) {
            insertBSTTest.insert(root, valores[i]);
        }

        System.out.println("\n*************EJERCICIO-#1*************");
        System.out.println("Arbol (BST):");
        arbol.setRoot(root);
        arbol.printTree();
    }

    private static void runEjercicio2() {
        ArbolBinario arbol = new ArbolBinario();
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        int[] valores = {4, 2, 7, 1, 3, 6, 9};

        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("\n*************EJERCICIO-#2*************");
        System.out.println("Arbol inicial:");
        arbol.printTree();

        Node invertedRoot = invertBinaryTree.invertTree(arbol.getRoot());
        arbol.setRoot(invertedRoot);

        System.out.println("\nArbol invertido:");
        arbol.printTree();
    }

    private static void runEjercicio4() {
        ArbolBinario arbol = new ArbolBinario();
        Depth depthCalculator = new Depth();

        int[] valores = {4, 2, 7, 1, 3, 6, 8, 9};

        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("\n*************EJERCICIO-#4*************");
        System.out.println("Arbol:");
        arbol.printTree();

        int maxDepth = depthCalculator.maxDepth(arbol.getRoot());
        System.out.println("\nProfundidad maxima del arbol: " + maxDepth);
    }
}
