import java.util.Stack;

public class Buque {
    // Clase que representa un buque que puede apilar contenedores utilizando una
    // pila (Stack)
    private Stack<contenedor> buque;

    public Buque() {
        this.buque = new Stack<>();
    }

    // Método para apilar un contenedor en el buque
    public void apilar(contenedor c) {
        buque.push(c);
        System.out.println("Apilado " + c.getId());
    }

    // Método para desapilar el contenedor superior del buque
    public Contenedor desapilar() {
        if (buque.isEmpty()) {
            System.out.println("El buque está vacío, no se puede desapilar.");
            return null;
        }
        // Desapilar el contenedor superior del buque
        Contenedor c = buque.pop();
        System.out.println("Desapilado " + c.getId());
        return c;
    }

    // mostrar pila
    public void mostrarBuque() {
        System.out.println("\n=== BUQUE ===");
        if (buque.isEmpty()) {
            System.out.println(" (vacio) ");
            return;
        }

        for (int i = 0; i < buque.size(); i++) {
            System.out.println(buque.get(i).getId());
        }
    }

    // reto quitar contenedor dañado
    public void quitarContenedorDañado(String idDañado) {
        // Pila auxiliar para almacenar temporalmente los contenedores mientras buscamos
        // el contenedor dañado
        Stack<contenedor> aux = new Stack<>();
        boolean encontrado = false;

        // sacar hasta encontrar el contenedor dañado
        while (!buque.isEmpty()) {
            Contenedor c = buque.pop();
            // Si encontramos el contenedor dañado, lo retiramos y salimos del bucle
            if (c.getId().equals(idDañado)) {
                System.out.println("Contenedor dañado " + c.getId() + " retirado del buque.");
                encontrado = true;
                break;
            }
            aux.push(c);

        }

        // devolver los otros

        while (!aux.isEmpty()) {
            buque.push(aux.pop());

        }
    }
}