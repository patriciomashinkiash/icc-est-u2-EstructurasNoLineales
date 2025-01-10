import main.materia.Controllers.ArbolBinario;
import main.materia.Controllers.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        runArbolBinario();
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
    
}
