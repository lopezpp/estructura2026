public class Contenedor {
    private String id;
    private double peso;
    private int prioridad;

    public Contenedor(String id, double peso, int prioridad) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean necesitaInspeccion() {
        return prioridad >= 8;
    }

    @Override
    public String toString() {
        return String.format("Contenedor[id=%s, peso=%.2f, prioridad=%d]",
                id, peso, prioridad);
    }
}
