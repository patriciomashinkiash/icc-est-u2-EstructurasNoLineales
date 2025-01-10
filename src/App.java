import main.materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        runArbolBinario();
    }

    public static void runArbolBinario() {
        ArbolBinario arbol = new ArbolBinario();

        int [] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};
        
        for (int i = 0; i < valores.length; i++) {
            arbol.insert(valores[i]);
        }

        System.out.println("Arbol:");
        arbol.printTree();
    }
}
