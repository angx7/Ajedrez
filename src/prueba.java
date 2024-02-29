import java.util.Scanner;

public class prueba {
    static Scanner sc = new Scanner(System.in);
    static String pieza;
    static String PeonN = " p ";
    static String PeonB = " P ";
    static String TorreN = " t ";
    static String TorreB = " T ";
    static String CaballoN = " c ";
    static String CaballoB = " C ";
    static String AlfilN = " a ";
    static String AlfilB = " A ";
    static String DamaN = " d ";
    static String DamaB = " D ";
    static String ReyN = " r ";
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
        boolean finale = false, turnoBlancas;
        int opcion;
        do {
            boolean TBlancas = true, TNegras = false;
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
                        boolean TBlancaS = ElegirPieza(tablero, turnoBlancas);
                        if (TBlancaS) {
                            TBlancas = false;
                        }
                        break;
                    case 2:
                        finale = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (TBlancas);

            do {
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
                        boolean TNegraS = ElegirPiezaR(tablero, turnoBlancas);
                        if (TNegraS) {
                            TNegras = true;
                        }
                        break;
                    case 2:
                        finale = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (!TNegras);

        } while (finale == false);

    }

    private static boolean ElegirPiezaR(String[][] tablero2, boolean turnoBlancas) {
        System.out.println("Elija la pieza que desea mover: ");
        pieza = sc.nextLine().toLowerCase();
        pieza = sc.nextLine().toLowerCase();
        System.out.println(pieza);
        System.out.println("Fila: ");
        int fila = sc.nextInt();
        System.out.println("Columna: ");
        int columna = sc.nextInt();
        System.out.println("Fila a la que desea mover: ");
        int fila2 = sc.nextInt();
        System.out.println("Columna a la que desea mover: ");
        int columna2 = sc.nextInt();
        String comp = tablero[fila][columna];
        // Obtenemos "color de la casilla y la letra de la pieza"
        String pieza2 = bibliotecar(pieza);
        // Obtenemos " p "
        String pz = BibliotecaR(pieza);
        // Obtenermos "PeonN"
        String concatenarN1 = BGB + pieza2;
        String concatenarN2 = BGN + pieza2;
        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza2, turnoBlancas, pz);
        } else {
            System.out.println("No puedes mover esta pieza");
            return false;
        }
    }

    private static boolean MoverPiezaR(String[][] tablero2, int fila, int columna, int fila2, int columna2,
            String pieza2, boolean turnoBlancas, String pz) {
        String pieza = tablero[fila][columna];
        // String pz = BibliotecaB(pieza2);
        if (!turnoBlancas && pz.contains("N")) { // Si es el turno de las blancas y la pieza es blanca
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
                    return false;
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
                    return false;
                }
            } else {
                System.out.println("No hay ninguna pieza en esa posición");
                return false;
            }

            ImprimirTablero(tablero);
            turnoBlancas = true; // Cambiar al turno de las negras
        } else {
            System.out.println("No es el turno de esa pieza");
            return false;
        }
        return true;
    }

    private static String BibliotecaR(String pieza2) {
        if (pieza2.equals("p")) {
            return "PeonN";
        } else if (pieza2.equals("t")) {
            return "TorreN";
        } else if (pieza2.equals("c")) {
            return "CaballoN";
        } else if (pieza2.equals("a")) {
            return "AlfilN";
        } else if (pieza2.equals("d")) {
            return "DamaN";
        } else if (pieza2.equals("r")) {
            return "ReyN";
        } else {
            return "   ";
        }
    }

    private static String bibliotecar(String pieza2) {
        if (pieza2.equals("p")) {
            return PeonN;
        } else if (pieza2.equals("t")) {
            return TorreN;
        } else if (pieza2.equals("c")) {
            return CaballoN;
        } else if (pieza2.equals("a")) {
            return AlfilN;
        } else if (pieza2.equals("d")) {
            return DamaN;
        } else if (pieza2.equals("r")) {
            return ReyN;
        } else {
            return "   ";

        }
    }

    private static boolean ElegirPieza(String[][] tablero, boolean turnoBlancas) {

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
        String comp = tablero[fila][columna];
        // Obtenemos "color de la casilla y la letra de la pieza"
        String pieza2 = bibliotecab(pieza);
        // Obtenemos " p "
        String pz = BibliotecaB(pieza);
        // Obtenermos "PeonN"
        String concatenarN1 = BGB + pieza2;
        String concatenarN2 = BGN + pieza2;
        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza2, turnoBlancas, pz);
        } else {
            System.out.println("No puedes mover esta pieza");
            return false;
        }
    }

    private static String BibliotecaB(String pz) {
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

    private static boolean MoverPieza(String[][] tablero, int fila, int columna, int fila2, int columna2, String pieza2,
            boolean turnoBlancas, String pz) {
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
                    return false;
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
                    return false;
                }
            } else {
                System.out.println("No hay ninguna pieza en esa posición");
                return false;
            }

            ImprimirTablero(tablero);
            turnoBlancas = false; // Cambiar al turno de las negras
        } else {
            System.out.println("No es el turno de esa pieza");
            return false;
        }
        return true;
    }
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
