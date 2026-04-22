package Momento2;

import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {

    private Queue<Contenedor> cola = new LinkedList<>();

    public void agregar(Contenedor c) {
        cola.add(c);
        System.out.println(" Enviado a inspección: " + c.id);
    }

    public void procesarUno() {
        if (cola.isEmpty()) {
            System.out.println("No hay contenedores en inspección.");
        } else {
            System.out.println(" Inspeccionado: " + cola.poll());
        }
    }

    public void mostrar() {
        System.out.println("\n Cola de inspección:");
        if (cola.isEmpty()) {
            System.out.println("Vacía");
            return;
        }
        for (Contenedor c : cola) {
            System.out.println(c);
        }
    }
}