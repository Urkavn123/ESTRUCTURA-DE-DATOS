import java.util.Scanner;
import java.util.Random;

class sistemaPuerto {

    Buque[] buques = new Buque[10];
    Contenedor[][] matriz = new Contenedor[10][10];
    int contadorBuques = 0;

    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    operacionContenedores op = new operacionContenedores();

    public void menu() {

        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("\n1. Registrar Buque");
            System.out.println("\n2. Registrar Contenedor (aleatorio)");
            System.out.println("\n3. Mostrar Peso Total");
            System.out.println("\n4. Listar Origen");
            System.out.println("\n5. Mostrar Matriz");
            System.out.println("\n6. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarBuque();
                    break;
                case 2:
                    registrarContenedor();
                    break;
                case 3:
                    mostrarPesoTotal();
                    break;
                case 4:
                    listarOrigen();
                    break;
                case 5:
                    op.mostrarMatriz(matriz);
                    break;
            }

        } while (opcion != 6);
    }

    public void registrarBuque() {

        if (contadorBuques < 10) {

            // 🔹 ID aleatorio
            String id = "B" + (100 + r.nextInt(900)); // ID entre B100 y B999

            // 🔹 Peso aleatorio
            double peso = 5000 + r.nextInt(5001); // peso mayor que contenedores

            // 🔹 Origen aleatorio
            String[] paises = { "Colombia", "China", "USA", "Brasil", "España" };
            String origen = paises[r.nextInt(paises.length)];

            buques[contadorBuques] = new Buque(id, origen, peso);
            contadorBuques++;

            System.out.println("Buque generado:");
            System.out.println("ID: " + id);
            System.out.println("Peso: " + peso);
            System.out.println("Origen: " + origen);

        } else {
            System.out.println("No hay espacio para mas buques.");
        }
    }

    public void registrarContenedor() {

        // 🔹 ID aleatorio
        String id = "C" + (1000 + r.nextInt(9000)); // ID entre C1000 y C9999

        // 🔹 Peso aleatorio
        double peso = 100 + r.nextInt(901);

        // 🔹 Origen aleatorio
        String[] paises = { "Colombia", "China", "USA", "Brasil", "España" };
        String origen = paises[r.nextInt(paises.length)];

        Contenedor nuevo = new Contenedor(id, origen, peso);

        boolean agregado = false;

        for (int col = 0; col < 10 && !agregado; col++) {
            for (int fila = 9; fila >= 0; fila--) {

                if (matriz[fila][col] == null) {

                    if (fila == 9 || matriz[fila + 1][col] != null) {

                        matriz[fila][col] = nuevo;
                        agregado = true;

                        System.out.println("Contenedor generado:");
                        System.out.println("ID: " + id);
                        System.out.println("Peso: " + peso);
                        System.out.println("Origen: " + origen);
                        break;
                    }
                }
            }
        }

        if (!agregado) {
            System.out.println("No hay espacio disponible.");
        }
    }

    public void mostrarPesoTotal() {

        double total = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] != null) {
                    total += matriz[i][j].getPeso();
                }
            }
        }

        System.out.println("Peso total: " + total);
    }

    public void listarOrigen() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] != null) {
                    System.out.println("Origen: " + matriz[i][j].getOrigen());
                }
            }
        }
    }
}