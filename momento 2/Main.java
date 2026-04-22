package Momento2;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static Contenedor crearContenedor() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        System.out.print("Prioridad (1-3): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        return new Contenedor(id, peso, prioridad);
    }

    public static void main(String[] args) {

        Patio patio = new Patio(3, 3);
        Inspeccion inspeccion = new Inspeccion();
        Buque buque = new Buque();

        int opcion;

        do {
            System.out.println("\n=====  DATA-BAY SYSTEM =====");
            System.out.println("1. Registrar y enviar al patio");
            System.out.println("2. Enviar a inspección");
            System.out.println("3. Procesar inspección");
            System.out.println("4. Cargar al buque");
            System.out.println("5. Ver estado general");
            System.out.println("6. Retirar del buque");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Contenedor c1 = crearContenedor();
                    if (!patio.insertar(c1)) {
                        System.out.println(" Puerto Saturado");
                    }
                    break;

                case 2:
                    Contenedor c2 = crearContenedor();
                    inspeccion.agregar(c2);
                    break;

                case 3:
                    inspeccion.procesarUno();
                    break;

                case 4:
                    Contenedor c3 = crearContenedor();
                    buque.apilar(c3);
                    break;

                case 5:
                    patio.mostrar();
                    inspeccion.mostrar();
                    buque.mostrar();
                    break;

                case 6:
                    buque.desapilar();
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}