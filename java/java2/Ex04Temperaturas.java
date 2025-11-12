public class Ex04Temperaturas {
    static void mostrarPromedioSemanal(double[][] datos) {
        for (int i = 0; i < datos.length; i++) {
            double s = 0;
            for (int j = 0; j < datos[i].length; j++) s += datos[i][j];
            double media = datos[i].length == 0 ? 0 : s / datos[i].length;
            System.out.println("Promedio semana " + (i + 1) + ": " + media + "°C");
        }
    }

    public static void main(String[] args) {
        double[][] temperaturas = {
            {20, 21, 22, 21, 20, 23, 21},
            {18, 19, 20, 20, 21, 19, 21},
            {23, 24, 22, 23, 24, 23, 23}
        };
        mostrarPromedioSemanal(temperaturas);
    }
}
