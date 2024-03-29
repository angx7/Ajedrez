import java.util.Scanner;

public class Ajedrez {
    // Declaración de variables globales
    static Scanner sc = new Scanner(System.in);
    static String pieza;
    static String PeonN = " \u265F  ";
    static String PeonB = " \u2659  ";
    static String TorreN = " \u265C  ";
    static String TorreB = " \u2656  ";
    static String CaballoN = " \u265E  ";
    static String CaballoB = " \u2658  ";
    static String AlfilN = " \u265D  ";
    static String AlfilB = " \u2657  ";
    static String DamaN = " \u265B  ";
    static String DamaB = " \u2655  ";
    static String ReyN = " \u265A  ";
    static String ReyB = " \u2654  ";
    static String BGB = "\u001B[47m" + "\u001B[30m";
    static String BGN = "\u001B[46m" + "\u001B[30m";
    static String BG = "\u001B[0m";
    static String[][] tablero = CrearTablero();
    private static String defaultcolor = "\u001B[37m";

    // Método principal
    public static void main(String[] args) {
        limpiarConsola();
        ImprimirTablero(tablero);
        Menu();
    }

    // Métodos de comprobación
    // Método para validar que el usuario ingresó numeros enteros
    public static boolean validarNumeros(String numero) {
        int FLDSMDFR;
        try {
            FLDSMDFR = Integer.parseInt(numero);
            if (FLDSMDFR < 1 || FLDSMDFR > 8) {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Método para validar que el usuario ingresó una pieza válida
    public static boolean validarPiezaSeleccionada(String pieza) {
        String piezasPermitidasBlancas = "PATDCR";
        String piezasPermitidasNegras = "patdcr";
        if (piezasPermitidasBlancas.contains(pieza.toUpperCase())) {
            return true;
        } else if (piezasPermitidasNegras.contains(pieza.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    private static void limpiarConsola() {
        System.out.print("\033[2J");
        System.out.print("\033[H");
    }

    // Método para el menú
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
                String option = sc.nextLine();
                while (!validarNumeros(option)) {
                    System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
                    option = sc.next();
                }
                opcion = Integer.parseInt(option);
                while (opcion <= 0 || opcion > 2) {
                    System.out.println("Elige una opción válida: ");
                    option = sc.next();
                    while (!validarNumeros(option)) {
                        System.out.print(
                                "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                        option = sc.next();
                    }
                    opcion = Integer.parseInt(option);
                }
                switch (opcion) {
                    case 1:
                        ImprimirTablero(tablero);
                        boolean TBlancaS = ElegirPieza(tablero, turnoBlancas);
                        if (TBlancaS) {
                            TBlancas = false;
                        }
                        break;
                    default:
                        limpiarConsola();
                        System.out.println("Seguro que desea cerrar el programa? (1. Si/2. No)");
                        option = sc.nextLine();
                        while (!validarNumeros(option)) {
                            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
                            option = sc.next();
                        }
                        opcion = Integer.parseInt(option);
                        while (opcion <= 0 || opcion > 2) {
                            System.out.println("Elige una opción válida: ");
                            option = sc.next();
                            while (!validarNumeros(option)) {
                                System.out.print(
                                        "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                                option = sc.next();
                            }
                            opcion = Integer.parseInt(option);
                        }
                        if (opcion == 1) {
                            limpiarConsola();
                            System.out.println("\t\t\t\u001B[33mGracias por jugar\n" + defaultcolor);
                            System.out.println("Presiona enter para continuar...");
                            sc.nextLine();
                            limpiarConsola();
                            System.out.println(
                                    "\t\t\t\t\u001B[33mCréditos\n\n" + defaultcolor
                                            + "* Angel Alejandro Becerra Rojas\r\n* Christian Axel Moreno Flores\r\n* Andrés Aguilera Hernández");
                            System.out.println("\n\n Presiona enter para continuar...");
                            sc.nextLine();
                            limpiarConsola();
                            sc.close();
                            System.exit(0);
                        } else {
                            TBlancas = true;
                        }
                        sc.nextLine();
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
                String option = sc.nextLine();
                while (!validarNumeros(option)) {
                    System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
                    option = sc.next();
                }
                opcion = Integer.parseInt(option);
                while (opcion <= 0 || opcion > 3) {
                    System.out.println("Elige una opción válida\n\n");
                    sc.nextLine();
                    sc.nextLine();
                    option = sc.next();
                    while (!validarNumeros(option)) {
                        System.out.print(
                                "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                        option = sc.next();
                    }
                    opcion = Integer.parseInt(option);
                }
                switch (opcion) {
                    case 1:
                        ImprimirTablero(tablero);
                        boolean TNegraS = ElegirPiezaR(tablero, turnoBlancas);
                        if (TNegraS) {
                            TNegras = true;
                        }
                        break;
                    default:
                        limpiarConsola();

                        System.out.println("Seguro que desea cerrar el programa? (1. Si/2. No)");
                        option = sc.nextLine();
                        while (!validarNumeros(option)) {
                            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
                            option = sc.next();
                        }
                        opcion = Integer.parseInt(option);
                        while (opcion <= 0 || opcion > 2) {
                            System.out.println("Elige una opción válida: ");
                            option = sc.next();
                            while (!validarNumeros(option)) {
                                System.out.print(
                                        "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                                option = sc.next();
                            }
                            opcion = Integer.parseInt(option);
                        }
                        if (opcion == 1) {
                            limpiarConsola();
                            System.out.println("\t\t\t\u001B[33mGracias por jugar\n" + defaultcolor);
                            System.out.println("Presiona enter para continuar...");
                            sc.nextLine();
                            limpiarConsola();
                            System.out.println(
                                    "\t\t\t\t\u001B[33mCréditos\n\n" + defaultcolor
                                            + "* Angel Alejandro Becerra Rojas\r\n* Christian Axel Moreno Flores\r\n* Andrés Aguilera Hernández");
                            System.out.println("\n\n Presiona enter para continuar...");
                            sc.nextLine();
                            limpiarConsola();
                            sc.close();
                            System.exit(0);
                        } else {
                            TNegras = false;
                        }
                        sc.nextLine();
                        break;
                }
            } while (!TNegras);

        } while (finale == false);

    }

    // Método para elegir una pieza
    private static boolean ElegirPiezaR(String[][] tablero2, boolean turnoBlancas) {
        limpiarConsola();
        ImprimirTablero(tablero);
        System.out.println("Elija la pieza que desea mover: ");
        pieza = sc.nextLine().toLowerCase();
        while (!validarPiezaSeleccionada(pieza)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            pieza = sc.nextLine().toLowerCase();
        }
        pieza = bibliotecaR(pieza);
        System.out.println(pieza);
        System.out.println("Columna: ");
        String columnas = sc.nextLine().toUpperCase();
        int valF = validarEntrada(columnas);
        while (valF == 0) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            columnas = sc.nextLine().toUpperCase();
            valF = validarEntrada(columnas);
        }
        int columna = valF;
        System.out.println("Fila: ");
        String filas = sc.nextLine();
        while (!validarNumeros(filas)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
            filas = sc.next();
        }
        int fila = NuevaPos(Integer.parseInt(filas));
        System.out.println("Columna a la que desea mover: ");
        String columnas2 = sc.nextLine().toUpperCase();
        int valF2 = validarEntrada(columnas2);
        while (valF2 == 0) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            columnas2 = sc.nextLine().toUpperCase();
            valF2 = validarEntrada(columnas2);
        }
        int columna2 = valF2;
        System.out.println("Fila a la que desea mover: ");
        String filas2 = sc.nextLine();
        while (!validarNumeros(filas2)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
            filas2 = sc.next();
        }
        int fila2 = NuevaPos(Integer.parseInt(filas2));
        String comp = tablero[fila][columna];
        String pz = BibliotecaR(pieza);
        String concatenarN1 = BGB + pieza;
        String concatenarN2 = BGN + pieza;
        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            switch (pieza) {
                case " \u265D  ": // Alfil negro
                    if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                        return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El alfil no se puede mover a esa posición");
                        return false;
                    }
                case " \u265E  ": // Caballo negro
                    if (ValidarCaballo(fila, columna, fila2, columna2)) {
                        return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El caballo no se puede mover a esa posición");
                        return false;
                    }
                case " \u265A  ": // Rey negro
                    if (ValidarRey(fila, columna, columna2, fila2)) {
                        return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El rey no se puede mover a esa posición");
                    }
                case " \u265B  ": // Dama negra
                    if (fila == fila2) {
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    } else if (columna == columna2) {
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    } else {
                        if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    }
                default:
                    if (pieza.equals(TorreN)) { // Torre y peón negros
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La torre no se puede mover a esa posición");
                            return false;

                        }
                    } else if (pieza.equals(PeonN)) {
                        if (MovimientoPeonN(fila, columna, fila2, columna2, tablero)) {
                            return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("El peón no se puede mover a esa posición");
                            return false;
                        }
                    }
            }
        } else {
            System.out.println("No puedes mover esta pieza");
            return false;
        }
        return false;
    }

    private static boolean MovimientoPeonN(int fila, int columna, int fila2, int columna2, String[][] tablero2) {
        if (columna == columna2) {
            if (tablero[1][1] == tablero[fila][columna] || tablero[1][2] == tablero[fila][columna]
                    || tablero[1][3] == tablero[fila][columna] || tablero[1][4] == tablero[fila][columna]
                    || tablero[1][5] == tablero[fila][columna] || tablero[1][6] == tablero[fila][columna]
                    || tablero[1][7] == tablero[fila][columna] || tablero[1][8] == tablero[fila][columna]) {
                if (fila2 - fila == 1) {
                    return true;
                } else if (fila2 - fila == 2) {
                    return true;
                }
            } else {
                if (fila2 - fila == 1) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    private static String bibliotecaR(String pieza2) {
        if (pieza2.equals("p")) {
            return " \u265F  ";
        } else if (pieza2.equals("t")) {
            return " \u265C  ";
        } else if (pieza2.equals("c")) {
            return " \u265E  ";
        } else if (pieza2.equals("a")) {
            return " \u265D  ";
        } else if (pieza2.equals("d")) {
            return " \u265B  ";
        } else if (pieza2.equals("r")) {
            return " \u265A  ";
        } else {
            return "   ";
        }
    }

    private static boolean MoverPiezaR(String[][] tablero2, int fila, int columna, int fila2, int columna2,
            String pieza2, boolean turnoBlancas, String pz) {
        String pieza = tablero[fila][columna];
        if (!turnoBlancas && pz.contains("N")) { // Si es el turno de las blancas y la pieza es blanca
            pieza = tablero[fila][columna];
            if (pieza.equals(BGB + pieza2)) {
                tablero[fila][columna] = BGB + "    ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "    ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "    ")) {
                    tablero[fila2][columna2] = BGB + pieza2;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }

            } else if (pieza.equals(BGN + pieza2)) {
                tablero[fila][columna] = BGN + "    ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "    ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "    ")) {
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
        if (pieza2.equals(" \u265F  ")) {
            return "PeonN";
        } else if (pieza2.equals(" \u265C  ")) {
            return "TorreN";
        } else if (pieza2.equals(" \u265E  ")) {
            return "CaballoN";
        } else if (pieza2.equals(" \u265D  ")) {
            return "AlfilN";
        } else if (pieza2.equals(" \u265B  ")) {
            return "DamaN";
        } else if (pieza2.equals(" \u265A  ")) {
            return "ReyN";
        } else {
            return "   ";
        }
    }

    private static boolean ElegirPieza(String[][] tablero, boolean turnoBlancas) {
        limpiarConsola();
        ImprimirTablero(tablero);
        System.out.println("Elija la pieza que desea mover: ");
        pieza = sc.nextLine().toUpperCase();
        while (!validarPiezaSeleccionada(pieza)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            pieza = sc.nextLine().toUpperCase();
        }
        pieza = bibliotecaB(pieza);
        System.out.println(pieza);
        System.out.println("Columna: ");
        String columnas = sc.nextLine().toUpperCase();
        int valF = validarEntrada(columnas);
        while (valF == 0) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            columnas = sc.nextLine().toUpperCase();
            valF = validarEntrada(columnas);
        }
        int columna = valF;

        System.out.println("Fila: ");
        String filas = sc.nextLine();
        while (!validarNumeros(filas)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
            filas = sc.next();
        }
        int fila = NuevaPos(Integer.parseInt(filas));
        System.out.println("Columna a la que desea mover: ");
        String columnas2 = sc.nextLine().toUpperCase();
        int valF2 = validarEntrada(columnas2);
        while (valF2 == 0) {
            System.out.println("\u001b[31mLa entrada no es válida, pon una letra válida: \u001B[0m ");
            columnas2 = sc.nextLine().toUpperCase();
            valF2 = validarEntrada(columnas2);
        }
        int columna2 = valF2;

        System.out.println("Fila a la que desea mover: ");
        String filas2 = sc.nextLine();
        while (!validarNumeros(filas2)) {
            System.out.println("\u001b[31mLa entrada no es válida, pon un número válido: \u001B[0m");
            filas2 = sc.next();
        }
        int fila2 = NuevaPos(Integer.parseInt(filas2));

        String comp = tablero[fila][columna];
        String pz = BibliotecaB(pieza);
        String concatenarN1 = BGB + pieza;
        String concatenarN2 = BGN + pieza;

        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            switch (pieza) {
                case " \u2657  ": // Alfil blanco
                    if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                        return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El alfil no se puede mover a esa posición");
                        return false;
                    }
                case " \u2658  ": // Caballo blanco
                    if (ValidarCaballo(fila, columna, fila2, columna2)) {
                        return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El caballo no se puede mover a esa posición");
                        return false;
                    }
                case " \u2654  ": // Rey blanco
                    if (ValidarRey(fila, columna, columna2, fila2)) {
                        return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                    } else {
                        System.out.println("El rey no se puede mover a esa posición");
                    }
                case " \u2655  ": // Dama blanca
                    if (fila == fila2) {
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    } else if (columna == columna2) {
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    } else {
                        if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La Dama no se puede mover a esa posición");
                            return false;
                        }
                    }
                default:
                    if (pieza.equals(TorreB)) { // Torre y peón blancos
                        if (MovimientoTorre(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("La torre no se puede mover a esa posición");
                            return false;

                        }
                    } else if (pieza.equals(PeonB)) {
                        if (MovimientoPeonB(fila, columna, fila2, columna2, tablero)) {
                            return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                        } else {
                            System.out.println("El peón no se puede mover a esa posición");
                            return false;

                        }
                    }
            }
            return false;
        }
        return false;
    }

    private static boolean MovimientoPeonB(int fila, int columna, int fila2, int columna2, String[][] tablero2) {
        if (columna == columna2) {
            if (tablero[6][1] == tablero[fila][columna] || tablero[6][2] == tablero[fila][columna]
                    || tablero[6][3] == tablero[fila][columna] || tablero[6][4] == tablero[fila][columna]
                    || tablero[6][5] == tablero[fila][columna] || tablero[6][6] == tablero[fila][columna]
                    || tablero[6][7] == tablero[fila][columna] || tablero[6][8] == tablero[fila][columna]) {
                if (fila - fila2 == 1) {
                    return true;
                } else if (fila - fila2 == 2) {
                    return true;
                }
            } else {
                if (fila - fila2 == 1) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    private static boolean MovimientoTorre(int fila, int columna, int fila2, int columna2, String[][] tablero2) {
        boolean continuar = false;
        if (fila == fila2) {
            int inicio = Math.min(columna, columna2);
            int fin = Math.max(columna, columna2);
            for (int i = inicio + 1; i < fin; i++) {
                if (tablero[fila][i].equals(BGB + "    ") || tablero[fila][i].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    return false;
                }
            }
            if (continuar) {
                return true;
            }
        } else if (columna == columna2) {
            int inicio = Math.min(fila, fila2);
            int fin = Math.max(fila, fila2);
            for (int i = inicio + 1; i < fin; i++) {
                if (tablero[i][columna].equals(BGB + "    ") || tablero[i][columna].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    return false;
                }
            }
            if (continuar) {
                return true;
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidarRey(int fila, int columna, int columna2, int fila2) {
        int difFil = Math.abs(fila - fila2);
        int difCol = Math.abs(columna - columna2);
        return difFil <= 1 && difCol <= 1;
    }

    private static boolean MovimientoAlfil(int fila, int columna, int fila2, int columna2, String[][] tablero) {
        int difFil = Math.abs(fila - fila2);
        int difCol = Math.abs(columna - columna2);
        if (difFil != difCol) {
            return false;
        }
        int dirFil = (fila2 - fila) / difFil;
        int dirCol = (columna2 - columna) / difCol;
        for (int i = 1; i <= difFil;) {
            int x = fila + i * dirFil;
            int y = columna + i * dirCol;
            if (tablero[x][y].equals(BGB + "    ") || tablero[x][y].equals(BGN + "    ")) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean ValidarCaballo(int fila, int columna, int fila2, int columna2) {
        int difFil = Math.abs(fila - fila2);
        int difCol = Math.abs(columna - columna2);
        return (difFil == 2 && difCol == 1) || (difFil == 1 && difCol == 2);
    }

    private static String bibliotecaB(String pieza2) {
        if (pieza2.equals("P")) {
            return " \u2659  ";
        } else if (pieza2.equals("T")) {
            return " \u2656  ";
        } else if (pieza2.equals("C")) {
            return " \u2658  ";
        } else if (pieza2.equals("A")) {
            return " \u2657  ";
        } else if (pieza2.equals("D")) {
            return " \u2655  ";
        } else if (pieza2.equals("R")) {
            return " \u2654  ";
        } else {
            return "   ";
        }
    }

    private static int NuevaPos(int filas) {
        switch (filas) {
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 2;
            case 7:
                return 1;
            default:
                return 0;
        }
    }

    private static int validarEntrada(String fila) {
        boolean match = fila.matches("[A-H]");
        if (match) {
            switch (fila) {
                case "A":
                    return 1;
                case "B":
                    return 2;
                case "C":
                    return 3;
                case "D":
                    return 4;
                case "E":
                    return 5;
                case "F":
                    return 6;
                case "G":
                    return 7;
                case "H":
                    return 8;
                default:
                    return 0;
            }
        } else {
            System.out.println("Entrada no válida");
            return 0;
        }
    }

    private static String BibliotecaB(String pz) {
        if (pz.equals(" \u2659  ")) {
            return "PeonB";
        } else if (pz.equals(" \u2656  ")) {
            return "TorreB";
        } else if (pz.equals(" \u2658  ")) {
            return "CaballoB";
        } else if (pz.equals(" \u2657  ")) {
            return "AlfilB";
        } else if (pz.equals(" \u2655  ")) {
            return "DamaB";
        } else if (pz.equals(" \u2654  ")) {
            return "ReyB";
        } else {
            return "   ";
        }
    }

    private static boolean MoverPieza(String[][] tablero, int fila, int columna, int fila2, int columna2, String pieza2,
            boolean turnoBlancas, String pz) {
        String pieza = tablero[fila][columna];
        if (turnoBlancas && pz.contains("B")) { // Si es el turno de las blancas y la pieza es blanca
            pieza = tablero[fila][columna];
            if (pieza.equals(BGB + pieza2)) {
                tablero[fila][columna] = BGB + "    ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "    ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "    ")) {
                    tablero[fila2][columna2] = BGB + pieza2;

                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }

            } else if (pieza.equals(BGN + pieza2)) {
                tablero[fila][columna] = BGN + "    ";
                String pieza3 = tablero[fila2][columna2];
                if (pieza3.equals(BGN + "    ")) {
                    tablero[fila2][columna2] = BGN + pieza2;
                } else if (pieza3.equals(BGB + "    ")) {
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

        System.out.println(
                "\n \u001B[33mP = \u2659 (Peón) \t T = \u2656 (Torre) \t C = \u2658 (Caballo) \n A = \u2657 (Alfil) \t D = \u2655 (Dama) \t R = \u2654 (Rey) \n"
                        + defaultcolor);
    }

    private static String[][] CrearTablero() {
        String[][] tablero = new String[9][10];

        tablero[0][0] = " 8 ";
        tablero[0][1] = BGB + TorreN;
        tablero[0][2] = BGN + CaballoN;
        tablero[0][3] = BGB + AlfilN;
        tablero[0][4] = BGN + DamaN;
        tablero[0][5] = BGB + ReyN;
        tablero[0][6] = BGN + AlfilN;
        tablero[0][7] = BGB + CaballoN;
        tablero[0][8] = BGN + TorreN;
        tablero[0][9] = BG;

        tablero[1][0] = " 7 ";
        tablero[1][1] = BGN + PeonN;
        tablero[1][2] = BGB + PeonN;
        tablero[1][3] = BGN + PeonN;
        tablero[1][4] = BGB + PeonN;
        tablero[1][5] = BGN + PeonN;
        tablero[1][6] = BGB + PeonN;
        tablero[1][7] = BGN + PeonN;
        tablero[1][8] = BGB + PeonN;
        tablero[1][9] = BG;

        tablero[2][0] = " 6 ";
        tablero[2][1] = BGB + "    ";
        tablero[2][2] = BGN + "    ";
        tablero[2][3] = BGB + "    ";
        tablero[2][4] = BGN + "    ";
        tablero[2][5] = BGB + "    ";
        tablero[2][6] = BGN + "    ";
        tablero[2][7] = BGB + "    ";
        tablero[2][8] = BGN + "    ";
        tablero[2][9] = BG;

        tablero[3][0] = " 5 ";
        tablero[3][1] = BGN + "    ";
        tablero[3][2] = BGB + "    ";
        tablero[3][3] = BGN + "    ";
        tablero[3][4] = BGB + "    ";
        tablero[3][5] = BGN + "    ";
        tablero[3][6] = BGB + "    ";
        tablero[3][7] = BGN + "    ";
        tablero[3][8] = BGB + "    ";
        tablero[3][9] = BG;

        tablero[4][0] = " 4 ";
        tablero[4][1] = BGB + "    ";
        tablero[4][2] = BGN + "    ";
        tablero[4][3] = BGB + "    ";
        tablero[4][4] = BGN + "    ";
        tablero[4][5] = BGB + "    ";
        tablero[4][6] = BGN + "    ";
        tablero[4][7] = BGB + "    ";
        tablero[4][8] = BGN + "    ";
        tablero[4][9] = BG;

        tablero[5][0] = " 3 ";
        tablero[5][1] = BGN + "    ";
        tablero[5][2] = BGB + "    ";
        tablero[5][3] = BGN + "    ";
        tablero[5][4] = BGB + "    ";
        tablero[5][5] = BGN + "    ";
        tablero[5][6] = BGB + "    ";
        tablero[5][7] = BGN + "    ";
        tablero[5][8] = BGB + "    ";
        tablero[5][9] = BG;

        tablero[6][0] = " 2 ";
        tablero[6][1] = BGB + PeonB;
        tablero[6][2] = BGN + PeonB;
        tablero[6][3] = BGB + PeonB;
        tablero[6][4] = BGN + PeonB;
        tablero[6][5] = BGB + PeonB;
        tablero[6][6] = BGN + PeonB;
        tablero[6][7] = BGB + PeonB;
        tablero[6][8] = BGN + PeonB;
        tablero[6][9] = BG;

        tablero[7][0] = " 1 ";
        tablero[7][1] = BGN + TorreB;
        tablero[7][2] = BGB + CaballoB;
        tablero[7][3] = BGN + AlfilB;
        tablero[7][4] = BGB + ReyB;
        tablero[7][5] = BGN + DamaB;
        tablero[7][6] = BGB + AlfilB;
        tablero[7][7] = BGN + CaballoB;
        tablero[7][8] = BGB + TorreB;
        tablero[7][9] = BG;

        tablero[8][0] = "    ";
        tablero[8][1] = " A  ";
        tablero[8][2] = " B  ";
        tablero[8][3] = " C  ";
        tablero[8][4] = " D  ";
        tablero[8][5] = " E  ";
        tablero[8][6] = " F  ";
        tablero[8][7] = " G  ";
        tablero[8][8] = " H  ";
        tablero[8][9] = "    ";

        return tablero;
    }
}
