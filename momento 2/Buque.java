package Momento2;

import java.util.Stack;

public class Buque {

    private Stack<Contenedor> pila = new Stack<>();

    public void apilar(Contenedor nuevo) {

        if (pila.isEmpty()) {
            pila.push(nuevo);
            System.out.println(" Cargado al buque");
            return;
        }

        Contenedor tope = pila.peek();

        if (nuevo.peso <= tope.peso) {
            pila.push(nuevo);
            System.out.println(" Cargado al buque");
        } else {
            System.out.println(" Rechazado: rompe estabilidad (más pesado que el tope)");
        }
    }

    public void desapilar() {
        if (pila.isEmpty()) {
            System.out.println("Buque vacío");
        } else {
            System.out.println(" Retirado: " + pila.pop());
        }
    }

    public void mostrar() {
        System.out.println("\n Estado del buque:");
        if (pila.isEmpty()) {
            System.out.println("Vacío");
            return;
        }
        for (Contenedor c : pila) {
            System.out.println(c);
        }
    }
}