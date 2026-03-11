import java.util.Random;

public class Procesamiento {

    public static void main(String[] args) {

        Random random = new Random();
        // PRIMER PASO: arreglo con energias aleatorias entre 50 y 150
        int[] energiaContenedores = new int[12];
        for (int i = 0; i < energiaContenedores.length; i++) {
            energiaContenedores[i] = random.nextInt(101) + 50;
            // El min es 50 y el max es 150
        }

        int[] filtrados10 = new int[12];
        int contador = 0;

        for (int i = 0; i < energiaContenedores.length; i++) {
            if (energiaContenedores[i] % 10 == 0) {
                filtrados10[contador] = energiaContenedores[i];
                contador++;
            }
        }
        // SEGUNDO PASO: matriz 3x3 con los valores filtrados
        int[][] mapaCarga = new int[3][3];
        int j = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {

                if (filtrados10 != null && index < filtrados10.length) {
                    mapaCarga[fila][col] = filtrados10[index];
                    j++;
                } else {
                    mapaCarga[fila][col] = -1;
                }

            }
        }
        // TERCER PASO: arreglo de objetos Suministro con id, energia y prioridad
        Suministro[] manifiesto = new Suministro[9];
        int i = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {

                int energia = mapaCarga[fila][col];

                if (energia != -1) {

                    String prioridad;

                    if (energia > 100) {
                        prioridad = "ALTA";
                    } else {
                        prioridad = "ESTANDAR";

                    }

                    manifiesto[i] = new Suministro("A" + random.nextInt(20), energia, prioridad);
                    i++;
                } else {
                    manifiesto[i] = null;
                }
            }
        }

        // Imprimir el manifiesto
        for (Suministro todo : manifiesto) {
            if (todo != null) {
                System.out.println( todo);

            } else {
                System.out.println("Suministro vacío");
            }
        }
    }
}
