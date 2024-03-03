import java.util.Scanner;

public class prueba {
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

    // Método principal
    public static void main(String[] args) {
        limpiarConsola();
        ImprimirTablero(tablero);
        Menu();
    }

    // Métodos de comprobación
    // Método para validar que el usuario ingresó numeros enteros
    public static boolean validarNumeros(String numero) {
        int num;
        try {
            num = Integer.parseInt(numero);
            if (num < 1 || num > 8) {
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
                // opcion = sc.nextInt();
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
        // Obtenemos "color de la casilla y la letra de la pieza"
        // Obtenemos " p "
        String pz = BibliotecaR(pieza);
        // Obtenermos "PeonN"
        String concatenarN1 = BGB + pieza;
        String concatenarN2 = BGN + pieza;
        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            boolean Validartyp = ValidarTyPR(tablero, fila, columna, columna2, fila2);
            boolean ValidarD = true;
            if (pieza.equals(AlfilN)) {
                if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                    return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                } else {
                    System.out.println("El alfil no se puede mover a esa posición");
                    return false;
                }
            }
            if (pieza.equals(CaballoN)) {
                if (ValidarCaballo(fila2, columna2, fila, columna)) {
                    return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                } else {
                    System.out.println("El caballo no se puede mover a esa posición");
                    return false;
                }
            }
            if (Validartyp == true) {
                return MoverPiezaR(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
            }
            return false;
        } else {
            System.out.println("No puedes mover esta pieza");
            return false;
        }
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
        // String pz = BibliotecaB(pieza2);
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
        //pieza = sc.nextLine().toUpperCase();
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
        // Obtenermos "PeonB"
        String concatenarN1 = BGB + pieza;
        String concatenarN2 = BGN + pieza;

        if ((comp.equals(concatenarN1)) || (comp.equals(concatenarN2))) {
            boolean Validartyp = ValidarTyP(tablero, fila, columna, columna2, fila2);
            boolean ValidarD = true;
            if (pieza.equals(AlfilB)) {
                if (MovimientoAlfil(fila, columna, fila2, columna2, tablero)) {
                    return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                } else {
                    System.out.println("El alfil no se puede mover a esa posición");
                    return false;
                }
            }
            if (pieza.equals(CaballoB)) {
                if (ValidarCaballo(fila, columna, fila2, columna2)) {
                    return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
                } else {
                    System.out.println("El caballo no se puede mover a esa posición");
                    return false;
                }
            }
            if (pieza.equals(ReyB) || pieza.equals(DamaB) || pieza.equals(AlfilB) || pieza.equals(PeonB)) { // BORRAR
                                                                                                            // PEONB
                ValidarD = ValidarD(tablero, fila, columna, fila2, columna2);
            } else {
                ValidarD = false;
            }
            if (Validartyp == true || ValidarD == true) {
                return MoverPieza(tablero, fila, columna, fila2, columna2, pieza, turnoBlancas, pz);
            }
            return false;
        }
        return false;
    }

    private static boolean ValidarD(String[][] tablero2, int fila, int columna, int fila2, int columna2) {
        int filacomp = (fila2 - fila) * -1;
        int columnacomp = columna2 - columna;
        boolean continuar = false;
        // ARRIBA DERECHA
        if (filacomp > 0 && columnacomp > 0) {
            for (int i = 1; i <= filacomp; i++) {
                for (int j = 1; j <= columnacomp; j++) {
                    if (tablero[fila - i][columna + j].equals(BGB + "    ")
                            || tablero[fila - i][columna + j].equals(BGN + "    ")) {
                        continuar = true;
                    } else {
                        System.out.println("No se puede mover a esa posición");
                        return false;
                    }
                }
            }
            // ABAJO IZQUIERDA
        } else if (filacomp < 0 && columnacomp < 0) {
            filacomp = fila2 - fila; // 3
            columnacomp = columna - columna2; // 3
            for (int i = 1; i <= filacomp; i++) {
                for (int j = 1; j <= columnacomp; j++) {
                    if (tablero[fila + i][columna - j].equals(BGB + "    ")
                            || tablero[fila + i][columna - j].equals(BGN + "    ")) {
                        continuar = true;
                    } else {
                        System.out.println("No se puede mover a esa posición");
                        return false;
                    }
                }
            }
            // ARRIBA IZQUIERDA
        } else if (filacomp > 0 && columnacomp < 0) {
            columnacomp = columna - columna2; // 2
            for (int i = 1; i <= filacomp; i++) {
                for (int j = 1; j <= columnacomp; j++) {
                    if (tablero[fila - i][columna - j].equals(BGB + "    ")
                            || tablero[fila - i][columna - j].equals(BGN + "    ")) {
                        continuar = true;
                    } else {
                        System.out.println("No se puede mover a esa posición");
                        return false;
                    }
                }
            }
            // ABAJO DERECHA
        } else if (filacomp < 0 && columnacomp > 0) {
            filacomp = fila2 - fila; // f1= 3, f2 = 6 filacomp = 3
            for (int i = 1; i <= filacomp; i++) {
                for (int j = 1; j <= columnacomp; j++) {
                    if (tablero[fila + i][columna + j].equals(BGB + "    ")
                            || tablero[fila + i][columna + j].equals(BGN + "    ")) {
                        continuar = true;
                    } else {
                        System.out.println("No se puede mover a esa posición");
                        return false;
                    }
                }
            }
        }
        if (continuar == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean MovimientoAlfil(int fila, int columna, int fila2, int columna2, String[][] tablero) {
        // Calcular la diferencia en X y Y entre el origen y el destino
        int diffX = Math.abs(fila - fila2);
        int diffY = Math.abs(columna - columna2);

        // El movimiento es válido si la diferencia en X es igual a la diferencia en Y
        if (diffX != diffY) {
            return false;
        }

        // Determinar la dirección del movimiento
        int dirX = (fila2 - fila) / diffX;
        int dirY = (columna2 - columna) / diffY;

        // Comprobar cada casilla en la diagonal
        for (int i = 1; i <= diffX;) {
            int x = fila + i * dirX;
            int y = columna + i * dirY;

            // Si la casilla no está vacía, el movimiento no es válido
            if (tablero[x][y].equals(BGB + "    ") || tablero[x][y].equals(BGN + "    ")) {
                return true;
            } else {
                return false;
            }
        }

        // Si todas las casillas en la diagonal están vacías, el movimiento es válido
        return true;
    }

    // TORRES Y PEONES
    private static boolean ValidarTyP(String[][] tablero2, int fila, int columna, int columna2,
            int fila2) {
        int filacomp;
        int columnacomp;
        boolean continuar = false;
        if (fila > fila2) {
            filacomp = fila - fila2;
            for (int i = 1; i <= filacomp; i++) {
                if (tablero[fila - i][columna].equals(BGB + "    ")
                        || tablero[fila - i][columna].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        } else {
            filacomp = fila2 - fila;
            for (int i = 1; i <= filacomp; i++) {
                if (tablero[fila + i][columna].equals(BGB + "    ")
                        || tablero[fila + i][columna].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        }
        if (continuar == true) {
            return true;
        }
        if (columna > columna2) {
            columnacomp = columna - columna2;
            for (int i = 1; i <= columnacomp; i++) {
                if (tablero[fila][columna - i].equals(BGB + "    ")
                        || tablero[fila][columna - i].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        } else {
            columnacomp = columna2 - columna;
            for (int i = 1; i <= columnacomp; i++) {
                if (tablero[fila][columna + i].equals(BGB + "    ")
                        || tablero[fila][columna + i].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        }
        if (continuar == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean ValidarCaballo(int fila, int columna, int fila2, int columna2) {
        int difFil = Math.abs(fila - fila2);
        int difCol = Math.abs(columna - columna2);
        return (difFil == 2 && difCol == 1) || (difFil == 1 && difCol == 2);
    }

    private static boolean ValidarTyPR(String[][] tablero2, int fila, int columna, int columna2,
            int fila2) {
        int filacomp;
        int columnacomp;
        boolean continuar = false;
        if (fila < fila2) {
            filacomp = fila2 - fila;
            for (int i = 1; i <= filacomp; i++) {
                if (tablero[fila + i][columna].equals(BGB + "    ")
                        || tablero[fila + i][columna].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        } else {
            filacomp = fila - fila2;
            for (int i = 1; i <= filacomp; i++) {
                if (tablero[fila - i][columna].equals(BGB + "    ")
                        || tablero[fila - i][columna].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        }
        if (continuar == true) {
            return true;
        }
        if (columna > columna2) {
            columnacomp = columna - columna2;
            for (int i = 1; i <= columnacomp; i++) {
                if (tablero[fila][columna - i].equals(BGB + "    ")
                        || tablero[fila][columna - i].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        } else {
            columnacomp = columna2 - columna;
            for (int i = 1; i <= columnacomp; i++) {
                if (tablero[fila][columna + i].equals(BGB + "    ")
                        || tablero[fila][columna + i].equals(BGN + "    ")) {
                    continuar = true;
                } else {
                    System.out.println("No se puede mover a esa posición");
                    return false;
                }
            }
        }
        if (continuar == true) {
            return true;
        } else {
            return false;
        }
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
        // String pz = BibliotecaB(pieza2);
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
                "\n P = \u2659 (Peón) \t T = \u2656 (Torre) \t C = \u2658 (Caballo) \n A = \u2657 (Alfil) \t D = \u2655 (Dama) \t R = \u2654 (Rey) \n");
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
