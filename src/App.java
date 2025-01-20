import java.util.List;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import main.Ejercicio_04_depth.Depth;
//import main.Materia.Controllers.ArbolAVL;
import main.materia.Controllers.ArbolBinario;
import main.materia.Controllers.ArbolRecorridos;
import main.materia.Controllers.Graph;
import main.materia.Models.Node;
import main.materia.Models.NodeGraph;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        //runArvolAvl();
        //runEjercicio1();
        //runEjercicio2();
        //runEjercicio3();
        //runEjercicio4();
        runGraph();
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

    public static void runGraph() {
        //NodeGraph node5 = grafo.addNode(5);
        //NodeGraph node7 = grafo.addNode(7);
        //NodeGraph node9 = grafo.addNode(9);
        //NodeGraph node11 = grafo.addNode(11);
        //NodeGraph node3 = grafo.addNode(3);
        
        //grafo.addEdge(node11, node3);
        //grafo.addEdge(node3, node5);
        //grafo.addEdge(node3, node9);
        //grafo.addEdge(node5, node7);
        //grafo.addEdge(node5, node9);
        //grafo.addEdge(node5, node3);
        
        Graph grafo = new Graph();

        NodeGraph node0 = grafo.addNode(0);
        NodeGraph node1 = grafo.addNode(1);
        NodeGraph node2 = grafo.addNode(2);
        NodeGraph node3 = grafo.addNode(3);
        NodeGraph node4 = grafo.addNode(4);
        NodeGraph node5 = grafo.addNode(5);

        System.out.println("DIRECCIONAL:");
        grafo.addEdgeUnit(node0, node3);
        grafo.addEdgeUnit(node0, node5);
        grafo.addEdgeUnit(node3, node2);
        grafo.addEdgeUnit(node3, node4);
        grafo.addEdgeUnit(node4, node1);
        grafo.addEdgeUnit(node2, node1);
        grafo.addEdgeUnit(node1, node0);

        grafo.printGraph();
        System.out.println();

        Graph grafo2 = new Graph();

        NodeGraph g2node0 = grafo2.addNode(0);
        NodeGraph g2node1 = grafo2.addNode(1);
        NodeGraph g2node2 = grafo2.addNode(2);
        NodeGraph g2node3 = grafo2.addNode(3);
        NodeGraph g2node4 = grafo2.addNode(4);
        NodeGraph g2node5 = grafo2.addNode(5);

        System.out.println("NO DIRECCIONAL:");
        grafo2.addEdge(g2node0, g2node3);
        grafo2.addEdge(g2node0, g2node5);
        grafo2.addEdge(g2node3, g2node2);
        grafo2.addEdge(g2node3, g2node4);
        grafo2.addEdge(g2node4, g2node1);
        grafo2.addEdge(g2node2, g2node1);
        grafo2.addEdge(g2node1, g2node0);
        
        grafo2.printGraph();
        System.out.println();

        System.out.println("DIRECCIONAL:");
        grafo.getDFS(node0);
        grafo.getBFS(node0);
        System.out.println();

        System.out.println("\nNO DIRECCIONAL:");
        grafo2.getDFS(g2node0);
        grafo2.getBFS(g2node0);

        Graph grafo3 = new Graph();
        
        NodeGraph g3node0 = grafo3.addNode(0);
        NodeGraph g3node1 = grafo3.addNode(1);
        NodeGraph g3node2 = grafo3.addNode(2);
        NodeGraph g3node3 = grafo3.addNode(3);
        NodeGraph g3node4 = grafo3.addNode(4);
        NodeGraph g3node5 = grafo3.addNode(5);
        NodeGraph g3node7 = grafo3.addNode(7);
        NodeGraph g3node8 = grafo3.addNode(8);
        NodeGraph g3node9 = grafo3.addNode(9);

        System.out.println("----------------------------------------------------");
        System.out.println("GRAFO #2");

    }
}
