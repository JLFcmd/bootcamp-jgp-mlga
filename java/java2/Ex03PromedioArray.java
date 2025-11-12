public class Ex03PromedioArray {
    static double calcularPromedio(int[] numeros) {
        if (numeros == null || numeros.length == 0) return 0;
        int s = 0;
        for (int x : numeros) s += x;
        return s * 1.0 / numeros.length;
    }

    public static void main(String[] args) {
        int[] datos = {4, 8, 6, 2};
        System.out.println(calcularPromedio(datos));
        System.out.println(calcularPromedio(new int[0]));
    }
}
