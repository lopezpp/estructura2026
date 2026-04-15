import java.util.Arrays;

public class Manifiesto {
    private Contenedor[] contenedores;
    private int cantidad;

    public Manifiesto(int capacidad) {
        contenedores = new Contenedor[capacidad];
        cantidad = 0;
    }

    public boolean agregar(Contenedor c) {
        if (cantidad >= contenedores.length) {
            return false;
        }
        contenedores[cantidad++] = c;
        return true;
    }

    public boolean remover(int indice) {
        if (indice < 0 || indice >= cantidad) {
            return false;
        }
        for (int i = indice; i < cantidad - 1; i++) {
            contenedores[i] = contenedores[i + 1];
        }
        contenedores[--cantidad] = null;
        return true;
    }

    public double pesoTotal() {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += contenedores[i].getPeso();
        }
        return total;
    }

    public Contenedor get(int indice) {
        if (indice < 0 || indice >= cantidad) {
            return null;
        }
        return contenedores[indice];
    }

    public int size() {
        return cantidad;
    }

    public Contenedor[] getContenedores() {
        return Arrays.copyOf(contenedores, cantidad);
    }
}
