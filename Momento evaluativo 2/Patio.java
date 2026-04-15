public class Patio {
    // Clase que representa el patio de contenedores utilizando una matriz
    private Contenedor[][] patio;

    public Patio(int filas, int columnas) {
        patio = new Contenedor[filas][columnas];
    }

    // Método para ubicar un contenedor en el patio, buscando la primera posición
    // disponible
    public void ubicarContenedor(Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    System.out.println(
                            "contenedor " + c.getId() + " ubicado en la posición (" + i + ", " + j + ")");
                    return;
                }
            }
        }
        System.out.println("No hay espacio disponible para el contenedor " + c.getId());
    }

    // Método para mostrar el estado actual del patio, indicando qué posiciones
    // están ocupadas y cuáles están vacías
    public void mostrarPatio() {

        System.out.println("\n=== PATIO ===");
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    System.out.print("[---] ");
                } else {
                    System.out.print("[" + patio[i][j].getId() + "] ");
                }
            }
            System.out.println();
        }
    }

}
