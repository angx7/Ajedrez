public class App {
    public static void main(String[] args) {
        String[][] tablero = new String[8][8];
        boolean esBlanco = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (esBlanco) {
                    tablero[i][j] = "\u001B[47m" + " " ;
                } else {
                    tablero[i][j] = "\u001B[40m" + " ";
                }
                esBlanco = !esBlanco;
            }
            esBlanco = !esBlanco;
        }

        // Imprimir el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}

