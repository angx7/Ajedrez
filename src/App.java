public class App {
    public static void main(String[] args) {
        CrearTablero();
        ImprimirTablero(CrearTablero());

    }

    private static String[][] ImprimirTablero(String[][] tablero) {
        // Imprimir el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        return tablero;
    }

    private static String[][] CrearTablero() {
        String[][] tablero = new String[8][8];
        boolean esBlanco = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (esBlanco) {
                    tablero[i][j] = "\u001B[47m" + " ";
                } else {
                    tablero[i][j] = "\u001B[40m" + " ";
                }
                esBlanco = !esBlanco;
            }
            esBlanco = !esBlanco;
        }

        tablero[0][0] = "\u001B[47m" + "\u001B[35m" + "T";
        tablero[0][1] = "\u001B[40m" + "\u001B[35m" + "C";
        tablero[0][2] = "\u001B[47m" + "\u001B[35m" + "A";
        tablero[0][3] = "\u001B[40m" + "\u001B[35m" + "D";
        tablero[0][4] = "\u001B[47m" + "\u001B[35m" + "R";
        tablero[0][5] = "\u001B[40m" + "\u001B[35m" + "A";
        tablero[0][6] = "\u001B[47m" + "\u001B[35m" + "C";
        tablero[0][7] = "\u001B[40m" + "\u001B[35m" + "T";
        tablero[1][0] = "\u001B[47m" + "\u001B[35m" + "P";
        tablero[1][1] = "\u001B[47m" + "\u001B[35m" + "P";
        tablero[1][2] = "\u001B[40m" + "\u001B[35m" + "P";
        tablero[1][3] = "\u001B[47m" + "\u001B[35m" + "P";
        tablero[1][4] = "\u001B[40m" + "\u001B[35m" + "P";
        tablero[1][5] = "\u001B[47m" + "\u001B[35m" + "P";
        tablero[1][6] = "\u001B[40m" + "\u001B[35m" + "P";
        tablero[1][7] = "\u001B[47m" + "\u001B[35m" + "P";

        tablero[6][0] = "\u001B[40m" + "\u001B[35m" + "p";
        tablero[6][1] = "\u001B[47m" + "\u001B[35m" + "p";
        tablero[6][2] = "\u001B[40m" + "\u001B[35m" + "p";
        tablero[6][3] = "\u001B[47m" + "\u001B[35m" + "p";
        tablero[6][4] = "\u001B[40m" + "\u001B[35m" + "p";
        tablero[6][5] = "\u001B[47m" + "\u001B[35m" + "p";
        tablero[6][6] = "\u001B[40m" + "\u001B[35m" + "p";
        tablero[6][7] = "\u001B[47m" + "\u001B[35m" + "p";
        tablero[7][0] = "\u001B[40m" + "\u001B[35m" + "t";
        tablero[7][1] = "\u001B[47m" + "\u001B[35m" + "c";
        tablero[7][2] = "\u001B[40m" + "\u001B[35m" + "a";
        tablero[7][3] = "\u001B[47m" + "\u001B[35m" + "d";
        tablero[7][4] = "\u001B[40m" + "\u001B[35m" + "r";
        tablero[7][5] = "\u001B[47m" + "\u001B[35m" + "a";
        tablero[7][6] = "\u001B[40m" + "\u001B[35m" + "c";
        tablero[7][7] = "\u001B[47m" + "\u001B[35m" + "t";

        return tablero;
    }

}
