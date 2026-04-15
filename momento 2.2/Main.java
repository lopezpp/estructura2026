import java.util.Scanner;

public class Main {
    private Manifiesto manifiesto;
    private Patio patio;
    private Inspeccion inspeccion;
    private Buque buque;
    private Scanner scanner;

    public Main(int capacidadManifiesto, int filasPatio, int columnasPatio) {
        manifiesto = new Manifiesto(capacidadManifiesto);
        patio = new Patio(filasPatio, columnasPatio);
        inspeccion = new Inspeccion();
        buque = new Buque();
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        System.out.println("=== Data-Bay: Motor Lógico del Puerto Inteligente ===");
        while (true) {
            mostrarMenu();
            int opcion = leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> registrarContenedorAlManifiesto();
                case 2 -> mostrarResumenManifiesto();
                case 3 -> procesarSiguienteSalidaDeCamion();
                case 4 -> mostrarEstadoGeneral();
                case 5 -> procesarInspeccion();
                case 6 -> cargarBuqueDesdePatio();
                case 7 -> retirarContenedorDanadoDelBuque();
                case 8 -> {
                    System.out.println("Saliendo del sistema Data-Bay.");
                    return;
                }
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("1. Registrar contenedor en manifiesto");
        System.out.println("2. Mostrar peso total de manifiesto");
        System.out.println("3. Procesar siguiente contenedor de llegada");
        System.out.println("4. Mostrar estado general del puerto");
        System.out.println("5. Atender siguiente contenedor en inspección");
        System.out.println("6. Cargar buque desde el patio");
        System.out.println("7. Retirar contenedor dañado del fondo del buque");
        System.out.println("8. Salir");
    }

    private void registrarContenedorAlManifiesto() {
        if (manifiesto.size() >= 10) {
            System.out.println("El manifiesto ya alcanzó su capacidad máxima.");
            return;
        }
        System.out.println("--- Registro de contenedor ---");
        String id = leerTexto("ID del contenedor: ");
        double peso = leerDouble("Peso (kg): ");
        int prioridad = leerEntero("Prioridad (1-10): ");
        Contenedor c = new Contenedor(id, peso, prioridad);
        if (manifiesto.agregar(c)) {
            System.out.println("Contenedor registrado en el manifiesto.");
        } else {
            System.out.println("No se pudo registrar el contenedor en el manifiesto.");
        }
    }

    private void mostrarResumenManifiesto() {
        System.out.println("--- Resumen del manifiesto ---");
        System.out.println("Contenedores registrados: " + manifiesto.size());
        System.out.printf("Peso total: %.2f kg%n", manifiesto.pesoTotal());
    }

    private void procesarSiguienteSalidaDeCamion() {
        if (manifiesto.size() == 0) {
            System.out.println("No hay contenedores disponibles en el manifiesto.");
            return;
        }
        Contenedor siguiente = manifiesto.get(0);
        if (siguiente.necesitaInspeccion()) {
            inspeccion.encolar(siguiente);
            System.out.println("Contenedor enviado a inspección: " + siguiente.getId());
        } else {
            if (patio.colocar(siguiente)) {
                System.out.println("Contenedor ubicado en el patio: " + siguiente.getId());
            } else {
                System.out.println("Puerto Saturado: no hay espacio disponible en el patio.");
            }
        }
        manifiesto.remover(0);
    }

    private void mostrarEstadoGeneral() {
        System.out.println("--- Estado General del Puerto ---");
        mostrarResumenManifiesto();
        patio.mostrar();
        inspeccion.mostrarCola();
        buque.mostrarCarga();
    }

    private void procesarInspeccion() {
        Contenedor inspeccionado = inspeccion.atender();
        if (inspeccionado == null) {
            System.out.println("No hay contenedores en inspección.");
            return;
        }
        System.out.println("Contenedor inspeccionado: " + inspeccionado);
        if (patio.colocar(inspeccionado)) {
            System.out.println("Contenedor movido al patio tras inspección.");
        } else {
            System.out.println("Puerto Saturado: el contenedor inspeccionado no puede ubicarse en el patio.");
        }
    }

    private void cargarBuqueDesdePatio() {
        Contenedor[] contenedores = patio.listarContenedores();
        if (contenedores.length == 0) {
            System.out.println("No hay contenedores disponibles en el patio.");
            return;
        }
        Contenedor candidato = contenedores[0];
        if (buque.cargar(candidato)) {
            System.out.println("Contenedor cargado en el buque: " + candidato.getId());
            patio.retirar(candidato);
        } else {
            System.out.println("No se puede cargar el contenedor en el buque: peso mayor al del tope.");
        }
    }

    private void retirarContenedorDanadoDelBuque() {
        Contenedor removido = buque.removerFondo();
        if (removido == null) {
            System.out.println("El buque está vacío.");
        } else {
            System.out.println("Contenedor dañado retirado del fondo: " + removido);
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Main app = new Main(10, 5, 5);
        app.ejecutar();
    }
}