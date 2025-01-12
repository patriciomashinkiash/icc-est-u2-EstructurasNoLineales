import java.util.List;

import main.Ejercicio_03_listLevels.ListLevels;
import main.materia.Controllers.ArbolBinario;
import main.materia.Controllers.ArbolRecorridos;
import main.materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        runEjercicio3();
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

        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("Arbol:");
        arbol.printTree();

        System.out.println("Niveles del arbol:");
        List<List<Node>> levels = listLevels.listLevels(arbol.getRoot());

        listLevels.printLevels(levels);
    }

}
