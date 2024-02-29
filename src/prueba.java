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
    static String BGB = "\u001B[47m" + "\u001B[35m";
    static String BGN = "\u001B[40m" + "\u001B[35m";
    static String BG = "\u001B[0m";
    static String[][] tablero = CrearTablero();

    public static void main(String[] args) {
        ImprimirTablero(tablero);
        Menu();
    }

    private static void Menu() {
        boolean finale = false, TBlancas = true, TNegras = false, turnoBlancas;
        int opcion;
        do {
            do {
                System.out.println(BG + "Seleccione una opción: ");
                System.out.println("Turno de blancas");
                turnoBlancas = true; // Comienza el juego en el turno de las blancas
                System.out.println("1. Mover una pieza");
                System.out.println("2. Salir");
                System.out.println("Opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        ImprimirTablero(tablero);
                        ElegirPieza(tablero, turnoBlancas);
                        break;
                    case 2:
                        finale = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (TBlancas);
           

            System.out.println("Seleccione una opción: ");
            System.out.println("Turno de negras");
            turnoBlancas = false; // Cambiar al turno de las negras
            System.out.println("1. Mover una pieza");
            System.out.println("2. Salir");
            System.out.println("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ImprimirTablero(tablero);
                    ElegirPieza(tablero, turnoBlancas);
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

    private static void ElegirPieza(String[][] tablero, boolean turnoBlancas) {
        System.out.println("Elija la pieza que desea mover: ");
        pieza = sc.nextLine().toUpperCase();
        pieza = sc.nextLine().toUpperCase();
        String pieza2 = bibliotecab(pieza);
        String pz = BibliotecaB(pieza);

        System.out.println(pieza);
        System.out.println("Fila: ");
        int fila = sc.nextInt();
        System.out.println("Columna: ");
        int columna = sc.nextInt();
        System.out.println("Fila a la que desea mover: ");
        int fila2 = sc.nextInt();
        System.out.println("Columna a la que desea mover: ");
        int columna2 = sc.nextInt();
        MoverPieza(tablero, fila, columna, fila2, columna2, pieza2, turnoBlancas, pz);
    }

    private static String BibliotecaB(String pz){
        if (pz.equals("P")) {
            return "PeonB";
        } else if (pz.equals("T")) {
            return "TorreB";
        } else if (pz.equals("C")) {
            return "CaballoB";
        } else if (pz.equals("A")) {
            return "AlfilB";
        } else if (pz.equals("D")) {
            return "DamaB";
        } else if (pz.equals("R")) {
            return "ReyB";
        } else {
            return "   ";
        }
    }

    private static String bibliotecab(String pieza2) {
        if (pieza2.equals("P")) {
            return PeonB;
        } else if (pieza2.equals("T")) {
            return TorreB;
        } else if (pieza2.equals("C")) {
            return CaballoB;
        } else if (pieza2.equals("A")) {
            return AlfilB;
        } else if (pieza2.equals("D")) {
            return DamaB;
        } else if (pieza2.equals("R")) {
            return ReyB;
        } else {
            return "   ";
        }
    }

    private static void MoverPieza(String[][] tablero, int fila, int columna, int fila2, int columna2, String pieza2, boolean turnoBlancas, String pz) {
        String pieza = tablero[fila][columna];
        // String pz = BibliotecaB(pieza2);
        if (turnoBlancas && pz.contains("B")) { // Si es el turno de las blancas y la pieza es blanca
            pieza = tablero[fila][columna];
            if (pieza.equals(BGB + pieza2)) {
                tablero[fila][columna] = BGB + "   ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "   ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "   ")) {
                    tablero[fila2][columna2] = BGB + pieza2;

                } else {
                    System.out.println("No se puede mover a esa posición");
                }

            } else if (pieza.equals(BGN + pieza2)) {
                tablero[fila][columna] = BGN + "   ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "   ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "   ")) {
                    tablero[fila2][columna2] = BGB + pieza2;

                } else {
                    System.out.println("No se puede mover a esa posición");
                }
            } else {
                System.out.println("No hay ninguna pieza en esa posición");
            }

            ImprimirTablero(tablero);
            turnoBlancas = false; // Cambiar al turno de las negras
        } else if (!turnoBlancas && pieza.contains("N")) { // Si es el turno de las negras y la pieza es negra
            // Mover la pieza
            // ...
            pieza = tablero[fila][columna];
            if (pieza.equals(BGB + pieza2)) {
                tablero[fila][columna] = BGB + "   ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "   ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "   ")) {
                    tablero[fila2][columna2] = BGB + pieza2;

                } else {
                    System.out.println("No se puede mover a esa posición");
                }

            } else if (pieza.equals(BGN + pieza2)) {
                tablero[fila][columna] = BGN + "   ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "   ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "   ")) {
                    tablero[fila2][columna2] = BGB + pieza2;

                } else {
                    System.out.println("No se puede mover a esa posición");
                }
            } else {
                System.out.println("No hay ninguna pieza en esa posición");
            }

            ImprimirTablero(tablero);
            turnoBlancas = true; // Cambiar al turno de las blancas
        } else {
            System.out.println("No es el turno de esa pieza");
        }
    }
    // private static void MoverPieza(String[][] tablero, int fila, int columna, int
    // fila2, int columna2, String pieza2) {
    // String pieza = tablero[fila][columna];
    // if (pieza.equals(BGB + pieza2)) {
    // tablero[fila][columna] = BGB + " ";
    // String pieza3 = tablero[fila2][columna2];
    // if (pieza3.equals(BGN + " ")) {
    // tablero[fila2][columna2] = BGN + pieza2;
    // } else if (pieza3.equals(BGB + " ")) {
    // tablero[fila2][columna2] = BGB + pieza2;

    // } else {
    // System.out.println("No se puede mover a esa posición");
    // }

    // } else if (pieza.equals(BGN + pieza2)) {
    // tablero[fila][columna] = BGN + " ";
    // String pieza3 = tablero[fila2][columna2];
    // if (pieza3.equals(BGN + " ")) {
    // tablero[fila2][columna2] = BGN + pieza2;
    // } else if (pieza3.equals(BGB + " ")) {
    // tablero[fila2][columna2] = BGB + pieza2;

    // } else {
    // System.out.println("No se puede mover a esa posición");
    // }
    // } else {
    // System.out.println("No hay ninguna pieza en esa posición");
    // }

    // ImprimirTablero(tablero);
    // }

    private static void ImprimirTablero(String[][] tablero) {
        // Imprimir el tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] CrearTablero() {
        String[][] tablero = new String[8][9];

        tablero[0][0] = BGB + TorreN;
        tablero[0][1] = BGN + CaballoN;
        tablero[0][2] = BGB + AlfilN;
        tablero[0][3] = BGN + DamaN;
        tablero[0][4] = BGB + ReyN;
        tablero[0][5] = BGN + AlfilN;
        tablero[0][6] = BGB + CaballoN;
        tablero[0][7] = BGN + TorreN;
        tablero[0][8] = BG;

        tablero[1][0] = BGN + PeonN;
        tablero[1][1] = BGB + PeonN;
        tablero[1][2] = BGN + PeonN;
        tablero[1][3] = BGB + PeonN;
        tablero[1][4] = BGN + PeonN;
        tablero[1][5] = BGB + PeonN;
        tablero[1][6] = BGN + PeonN;
        tablero[1][7] = BGB + PeonN;
        tablero[1][8] = BG;

        tablero[2][0] = BGB + "   ";
        tablero[2][1] = BGN + "   ";
        tablero[2][2] = BGB + "   ";
        tablero[2][3] = BGN + "   ";
        tablero[2][4] = BGB + "   ";
        tablero[2][5] = BGN + "   ";
        tablero[2][6] = BGB + "   ";
        tablero[2][7] = BGN + "   ";
        tablero[2][8] = BG;

        tablero[3][0] = BGN + "   ";
        tablero[3][1] = BGB + "   ";
        tablero[3][2] = BGN + "   ";
        tablero[3][3] = BGB + "   ";
        tablero[3][4] = BGN + "   ";
        tablero[3][5] = BGB + "   ";
        tablero[3][6] = BGN + "   ";
        tablero[3][7] = BGB + "   ";
        tablero[3][8] = BG;

        tablero[4][0] = BGB + "   ";
        tablero[4][1] = BGN + "   ";
        tablero[4][2] = BGB + "   ";
        tablero[4][3] = BGN + "   ";
        tablero[4][4] = BGB + "   ";
        tablero[4][5] = BGN + "   ";
        tablero[4][6] = BGB + "   ";
        tablero[4][7] = BGN + "   ";
        tablero[4][8] = BG;

        tablero[5][0] = BGN + "   ";
        tablero[5][1] = BGB + "   ";
        tablero[5][2] = BGN + "   ";
        tablero[5][3] = BGB + "   ";
        tablero[5][4] = BGN + "   ";
        tablero[5][5] = BGB + "   ";
        tablero[5][6] = BGN + "   ";
        tablero[5][7] = BGB + "   ";
        tablero[5][8] = BG;

        tablero[6][0] = BGB + PeonB;
        tablero[6][1] = BGN + PeonB;
        tablero[6][2] = BGB + PeonB;
        tablero[6][3] = BGN + PeonB;
        tablero[6][4] = BGB + PeonB;
        tablero[6][5] = BGN + PeonB;
        tablero[6][6] = BGB + PeonB;
        tablero[6][7] = BGN + PeonB;
        tablero[6][8] = BG;

        tablero[7][0] = BGN + TorreB;
        tablero[7][1] = BGB + CaballoB;
        tablero[7][2] = BGN + AlfilB;
        tablero[7][3] = BGB + ReyB;
        tablero[7][4] = BGN + DamaB;
        tablero[7][5] = BGB + AlfilB;
        tablero[7][6] = BGN + CaballoB;
        tablero[7][7] = BGB + TorreB;
        tablero[7][8] = BG;

        return tablero;
    }
}
