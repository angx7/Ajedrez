public class pp {
    
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
    public static void main(String[] args) {
        String reinaBlanca = " \u265A ";
        // char reinaNegra = '\u21A7';


        //char reinaBlanca = '\u21A8';
        char reinaNegra = '\u265B';
        char torreBlanca = '\u2656';
        char torreNegra = '\u265C';
        char alfilBlanco = '\u2657';
        char alfilNegro = '\u265D';
        char caballoBlanco = '\u2658';
        char caballoNegro = '\u265E';
        char peonBlanco = '\u2659';
        char peonNegro = '\u265F';
        //char reinaNegra = '\u265B';

        System.out.println(reinaBlanca + "hola" + "\u001B[0m");
        System.out.println(reinaNegra);
        System.out.println(torreBlanca);
        System.out.println(torreNegra);
        System.out.println(alfilBlanco);
        System.out.println(alfilNegro);
        System.out.println(caballoBlanco);
        System.out.println(caballoNegro);
        System.out.println(peonBlanco);
        System.out.println(peonNegro);


    }
}
