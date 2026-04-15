import java.util.Stack;

public class Buque {
    private Stack<Contenedor> pila = new Stack<>();

    public boolean cargar(Contenedor c) {
        if (pila.isEmpty() || c.getPeso() <= pila.peek().getPeso()) {
            pila.push(c);
            return true;
        }
        return false;
    }

    public Contenedor descargar() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public Contenedor removerFondo() {
        if (pila.isEmpty()) {
            return null;
        }
        Stack<Contenedor> auxiliar = new Stack<>();
        while (pila.size() > 1) {
            auxiliar.push(pila.pop());
        }
        Contenedor fondo = pila.pop();
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }
        return fondo;
    }

    public boolean estaVacio() {
        return pila.isEmpty();
    }

    public void mostrarCarga() {
        System.out.println("--- Pila de Carga del Buque (LIFO) ---");
        if (pila.isEmpty()) {
            System.out.println("(vacía)");
            return;
        }
        for (int i = pila.size() - 1; i >= 0; i--) {
            System.out.println(pila.get(i));
        }
    }
}
