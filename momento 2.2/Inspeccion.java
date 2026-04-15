import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {
    private Queue<Contenedor> cola = new LinkedList<>();

    public void encolar(Contenedor c) {
        cola.offer(c);
    }

    public Contenedor atender() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public void mostrarCola() {
        System.out.println("--- Cola de Inspección (FIFO) ---");
        if (cola.isEmpty()) {
            System.out.println("(vacía)");
            return;
        }
        for (Contenedor c : cola) {
            System.out.println(c);
        }
    }
}
