import java.util.Scanner;

// Clase que representa el manifiesto de contenedores, donde se registran los detalles de cada contenedor
public class Manifiesto {
    public static contenedor[] registrarManifiesto(int n, Scanner sc) {
        contenedor[] manifiesto = new contenedor[n];

        System.out.println("\n=== Registro de contenedores: ===");
        // Solicitar al usuario que ingrese los detalles de cada contenedor (ID, peso y
        // prioridad)
        for (int i = 0; i < n; i++) {
            System.out.println("\nContenedor " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            System.out.print("Prioridad: ");
            int prioridad = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            manifiesto[i] = new contenedor(id, peso, prioridad);

        }
        return manifiesto;
    }

    // Método para mostrar un resumen del manifiesto, incluyendo el ID, peso y
    // prioridad de cada contenedor, así como el peso total
    public static void mostrarResumen(contenedor[] manifiesto) {
        double pesoTotal = 0;

        System.out.println("\n=== Resumen del manifiesto: ===");

        for (int i = 0; i < manifiesto.length; i++) {
            Contenedor c = manifiesto[i];

            System.out.println("Contenedor " +
                    (i + 1) + "ID:" + c.getId() +
                    " | Peso: " + c.getPeso() +
                    " | Prioridad: " + c.getPrioridad());
            // Acumular el peso total de los contenedores
            pesoTotal += c.getPeso();
        }
        System.out.println("\nPeso total de los contenedores: " + pesoTotal);
    }
}
