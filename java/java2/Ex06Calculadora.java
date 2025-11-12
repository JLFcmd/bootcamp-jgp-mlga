public class Ex06Calculadora {
    static double cuadrado(double x) { return Math.pow(x, 2); }
    static double raiz(double x) { return Math.sqrt(x); }
    static double mayor(double a, double b) { return Math.max(a, b); }

    public static void main(String[] args) {
        System.out.println("Cuadrado de 4: " + cuadrado(4));
        System.out.println("Raíz de 9: " + raiz(9));
        System.out.println("Mayor entre 7 y 12: " + mayor(7, 12));
    }
}
