public class Patio {
    private Contenedor[][] espacios;
    private final int filas;
    private final int columnas;

    public Patio(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        espacios = new Contenedor[filas][columnas];
    }

    public boolean colocar(Contenedor c) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (espacios[i][j] == null) {
                    espacios[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public Contenedor retirar(int fila, int columna) {
        if (!esPosicionValida(fila, columna)) {
            return null;
        }
        Contenedor extraido = espacios[fila][columna];
        espacios[fila][columna] = null;
        return extraido;
    }

    public boolean retirar(Contenedor c) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (espacios[i][j] == c) {
                    espacios[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esLleno() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (espacios[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        System.out.println("--- Patio de Transferencia ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(espacios[i][j] == null ? "[   ] " : "[ X ] ");
            }
            System.out.println();
        }
    }

    public Contenedor siguienteDisponible() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (espacios[i][j] != null) {
                    return espacios[i][j];
                }
            }
        }
        return null;
    }

    public Contenedor[] listarContenedores() {
        java.util.List<Contenedor> lista = new java.util.ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (espacios[i][j] != null) {
                    lista.add(espacios[i][j]);
                }
            }
        }
        return lista.toArray(new Contenedor[0]);
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }
}
