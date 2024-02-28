
public class prueba {

    public static void main(String[] args) {
        // String[][] tablero = new String[8][8];
        boolean esBlanco = true;

        String[][] tablero = new String[8][8];

        // Rellenar el array con las piezas
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (esBlanco) {
                    tablero[i][j] = "\u001B[47m";
                } else {
                    tablero[i][j] = "\u001B[40m";
                }
                esBlanco = !esBlanco;
                if (i == 0 || i == 7) {
                    if (j == 0 || j == 7) {
                        tablero[i][j] = "T"; // Torre
                    } else if (j == 1 || j == 6) {
                        tablero[i][j] = "C"; // Caballo
                    } else if (j == 2 || j == 5) {
                        tablero[i][j] = "A"; // Alfil
                    } else if (j == 3) {
                        tablero[i][j] = "D"; // Dama
                    } else {
                        tablero[i][j] = "R"; // Rey
                    }
                } else if (i == 1 || i == 6) {
                    tablero[i][j] = "P"; // Peón
                } else {
                    tablero[i][j] = " "; // Casilla vacía
                }
            }
            esBlanco = !esBlanco;

        }

        // Imprimir el array por consola
        for (String[] fila : tablero) {
            for (String casilla : fila) {
                System.out.print(casilla);
            }
            System.out.println();
        }
    }
}
