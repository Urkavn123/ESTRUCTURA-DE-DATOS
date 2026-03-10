import java.util.Random;

public class Aleatorio {

    public static void main(String[] args) {

        Random r = new Random();
        int min = 0;
        int max = 20;
        //genera un numero aleatorio entre 0 y 20
        for (int i = 1; i < 100; i++) {
        System.out.println(r.nextInt((max - min + 1)) + min);
    }
}
}