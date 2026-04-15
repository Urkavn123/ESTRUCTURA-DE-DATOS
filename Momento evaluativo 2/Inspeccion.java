import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {
    // Clase que representa la inspección de contenedores utilizando una cola
    // (Queue)
    private Queue<contenedor> cola;

    public Inspeccion() {
        this.cola = new LinkedList<>();

    }

    // Método para enviar un contenedor a inspección, solo si su prioridad es 3 o
    // mayor
    public void enviarAInspeccion(contenedor c) {

        if (c.getPrioridad() >= 3) {
            System.out.println("Contenedor " + c.getId() + " con prioridad ALTA enviado a inspección.");
            cola.add(c);

        }
    }

    // Método para procesar el siguiente contenedor en la cola de inspección
    public contenedor procesarSiguiente() {

        if (cola.isEmpty()) {
            System.out.println("Cola vacia");
            return null;

        }
        // Sacar el siguiente contenedor de la cola para inspección
        contenedor c = cola.poll();

        System.out.println("Inspeccionando contenedor " + c.getId() + " con prioridad " + c.getPrioridad());
        return c;
    }

    // Método para mostrar el estado actual de la cola de inspección
    public void mostrarCola() {

        System.out.println("\n=== COLA ===");
        if (cola.isEmpty()) {
            System.out.println(" (vacia) ");
        } else {
            for (contenedor c : cola) {
                System.out.println(
                        "Contenedor ID: " + c.getId() +
                                " | Prioridad: " + c.getPrioridad());
            }
        }
    }
}
