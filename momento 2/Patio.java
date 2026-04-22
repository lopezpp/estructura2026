package Momento2;

public class Patio {

    private Contenedor[][] patio;

    public Patio(int filas, int columnas) {
        patio = new Contenedor[filas][columnas];
    }

    public boolean insertar(Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar() {
        System.out.println("\n Estado del Patio:");
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    System.out.print("[ vacío ] ");
                } else {
                    System.out.print("[ " + patio[i][j].id + " ] ");
                }
            }
            System.out.println();
        }
    }
}