import java.util.Scanner;

public class prueba {
    static Scanner sc = new Scanner(System.in);
    static String pieza;
    static String PeonN = " P ";
    static String PeonB = " P ";
    static String TorreN = " T ";
    static String TorreB = " T ";
    static String CaballoN = " C ";
    static String CaballoB = " C ";
    static String AlfilN = " A ";
    static String AlfilB = " A ";
    static String DamaN = " D ";
    static String DamaB = " D ";
    static String ReyN = " R ";
    static String ReyB = " R ";

    public static void main(String[] args) {
        CrearTablero();
        ImprimirTablero(CrearTablero());
        Menu();
    }

    private static void Menu() {
        boolean finale = false;
        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("Turno de blancas");
            System.out.println("1. Mover una pieza");
            System.out.println("2. Salir");
            System.out.println("Opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ImprimirTablero(CrearTablero());
                    ElegirPieza(CrearTablero());
                    break;
                case 2:
                    finale = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            System.out.println("Seleccione una opción: ");
            System.out.println("Turno de negras");
            System.out.println("1. Mover una pieza");
            System.out.println("2. Salir");
            System.out.println("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ElegirPieza(CrearTablero());
                    break;
                case 2:
                    finale = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (finale == false);

    }

    private static void ElegirPieza(String[][] tablero) {
        System.out.println("Elija la pieza que desea mover: ");
        pieza = sc.nextLine().toUpperCase();
        pieza = sc.nextLine().toUpperCase();
        System.out.println(pieza);
        System.out.println("Fila: ");
        int fila = sc.nextInt();
        System.out.println("Columna: ");
        int columna = sc.nextInt();
        System.out.println("Fila a la que desea mover: ");
        int fila2 = sc.nextInt();
        System.out.println("Columna a la que desea mover: ");
        int columna2 = sc.nextInt();
        MoverPieza(fila, columna, fila2, columna2);
    }

    private static void MoverPieza(int fila, int columna, int fila2, int columna2) {
        String[][] tablero = CrearTablero();
        String pieza = tablero[fila][columna];
        tablero[fila][columna] = "   ";
        tablero[fila2][columna2] = pieza;
        ImprimirTablero(tablero);
    }

    private static String[][] ImprimirTablero(String[][] tablero) {
        // Imprimir el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        return tablero;
    }

    private static String[][] CrearTablero() {
        String[][] tablero = new String[8][8];

        tablero[0][0] = "\u001B[47m" + "\u001B[35m" + TorreN;
        tablero[0][1] = "\u001B[40m" + "\u001B[35m" + CaballoN;
        tablero[0][2] = "\u001B[47m" + "\u001B[35m" + AlfilN;
        tablero[0][3] = "\u001B[40m" + "\u001B[35m" + DamaN;
        tablero[0][4] = "\u001B[47m" + "\u001B[35m" + ReyN;
        tablero[0][5] = "\u001B[40m" + "\u001B[35m" + AlfilN;
        tablero[0][6] = "\u001B[47m" + "\u001B[35m" + CaballoN;
        tablero[0][7] = "\u001B[40m" + "\u001B[35m" + TorreN;

        tablero[1][0] = "\u001B[40m" + "\u001B[35m" + PeonN;
        tablero[1][1] = "\u001B[47m" + "\u001B[35m" + PeonN;
        tablero[1][2] = "\u001B[40m" + "\u001B[35m" + PeonN;
        tablero[1][3] = "\u001B[47m" + "\u001B[35m" + PeonN;
        tablero[1][4] = "\u001B[40m" + "\u001B[35m" + PeonN;
        tablero[1][5] = "\u001B[47m" + "\u001B[35m" + PeonN;
        tablero[1][6] = "\u001B[40m" + "\u001B[35m" + PeonN;
        tablero[1][7] = "\u001B[47m" + "\u001B[35m" + PeonN;

        tablero[2][0] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[2][1] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[2][2] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[2][3] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[2][4] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[2][5] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[2][6] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[2][7] = "\u001B[40m" + "\u001B[35m" + "   ";

        tablero[3][0] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[3][1] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[3][2] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[3][3] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[3][4] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[3][5] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[3][6] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[3][7] = "\u001B[47m" + "\u001B[35m" + "   ";

        tablero[4][0] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[4][1] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[4][2] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[4][3] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[4][4] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[4][5] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[4][6] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[4][7] = "\u001B[40m" + "\u001B[35m" + "   ";

        tablero[5][0] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[5][1] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[5][2] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[5][3] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[5][4] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[5][5] = "\u001B[47m" + "\u001B[35m" + "   ";
        tablero[5][6] = "\u001B[40m" + "\u001B[35m" + "   ";
        tablero[5][7] = "\u001B[47m" + "\u001B[35m" + "   ";

        tablero[6][0] = "\u001B[47m" + "\u001B[35m" + PeonB;
        tablero[6][1] = "\u001B[40m" + "\u001B[35m" + PeonB;
        tablero[6][2] = "\u001B[47m" + "\u001B[35m" + PeonB;
        tablero[6][3] = "\u001B[40m" + "\u001B[35m" + PeonB;
        tablero[6][4] = "\u001B[47m" + "\u001B[35m" + PeonB;
        tablero[6][5] = "\u001B[40m" + "\u001B[35m" + PeonB;
        tablero[6][6] = "\u001B[47m" + "\u001B[35m" + PeonB;
        tablero[6][7] = "\u001B[40m" + "\u001B[35m" + PeonB;

        tablero[7][0] = "\u001B[40m" + "\u001B[35m" + TorreB;
        tablero[7][1] = "\u001B[47m" + "\u001B[35m" + CaballoB;
        tablero[7][2] = "\u001B[40m" + "\u001B[35m" + AlfilB;
        tablero[7][3] = "\u001B[47m" + "\u001B[35m" + ReyB;
        tablero[7][4] = "\u001B[40m" + "\u001B[35m" + DamaB;
        tablero[7][5] = "\u001B[47m" + "\u001B[35m" + AlfilB;
        tablero[7][6] = "\u001B[40m" + "\u001B[35m" + CaballoB;
        tablero[7][7] = "\u001B[47m" + "\u001B[35m" + TorreB + "\u001B[0m";

        return tablero;
    }
}
