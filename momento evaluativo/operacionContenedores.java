public class operacionContenedores {

    public void mostrarMatriz(Contenedor[][] m) {

        String cad = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != null) {
                    cad += "[ ]";
                } else {
                    cad += "[x] ";
                }
            }
            cad += "\n";
        }
        System.out.println(cad);
    }

}
