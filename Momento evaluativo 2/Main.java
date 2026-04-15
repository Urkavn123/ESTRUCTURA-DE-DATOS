import java.util.Scanner;

// Clase principal que integra todos los módulos del sistema de gestión de contenedores en el puerto
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== DATA-BAY ===");
        // Bienvenida al sistema de gestión de contenedores en el puerto, llamado
        // "Data-Bay"
        System.out.println("Bienvenido al sistema de gestión de contenedores en el puerto: Data-Bay");
        // ───────────── MÓDULO 1 ─────────────
        System.out.println("\n--- MODULO 1: MANIFIESTO ---");
        // Solicitar al usuario que ingrese el número de contenedores que desea
        // registrar en el manifiesto
        System.out.print("¿Cuántos contenedores desea ingresar? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        contenedor[] manifiesto = Manifiesto.registrarManifiesto(n, sc);

        Manifiesto.mostrarResumen(manifiesto);

        // ───────────── MÓDULO 2 ─────────────
        System.out.println("\n--- MODULO 2: PATIO ---");
        // Crear una instancia del patio de contenedores con una matriz de 3x3

        Modulo2_Patio patio = new Modulo2_Patio(3, 3);

        for (contenedor c : manifiesto) {
            patio.ubicarContenedor(c);
        }

        patio.mostrarPatio();

        // ───────────── MÓDULO 3 ─────────────
        System.out.println("\n--- MODULO 3: COLA ---");
        // Crear una instancia de la cola de inspección para gestionar los contenedores
        // que requieren inspección
        Modulo3_Inspeccion cola = new Modulo3_Inspeccion();

        for (contenedor c : manifiesto) {
            cola.enviarAInspeccion(c);
        }

        cola.mostrarCola();

        System.out.println("\nProcesando cola:");
        while (!cola.estaVacia()) {
            cola.procesarSiguiente();
        }

        // ───────────── MÓDULO 4 ─────────────
        System.out.println("\n--- MODULO 4: PILA ---");
        // Crear una instancia del buque, que utiliza una pila para apilar los
        // contenedores antes de su embarque
        Modulo4_Buque buque = new Modulo4_Buque();

        for (contenedor c : manifiesto) {
            buque.apilar(c);
        }

        buque.mostrarBuque();

        // RETO
        // Reto adicional: Implementar la funcionalidad para retirar un contenedor
        // dañado del buque, utilizando una pila auxiliar para mantener el orden de los
        // contenedores mientras se busca el contenedor dañado
        System.out.println("\n--- RETO: CONTENEDOR DAÑADO ---");

        System.out.print("Ingrese ID del contenedor dañado: ");
        String idDanado = sc.nextLine();

        buque.retirarDanado(idDanado);

        buque.mostrarBuque();

        sc.close();

        System.out.println("\n=== FIN ===");
    }
}