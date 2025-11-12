import java.util.*;

public class Ex07Notas {
    static ArrayList<Double> notas = new ArrayList<>();

    static void agregarNota(double n) { notas.add(n); }

    static double calcularPromedio() {
        if (notas.isEmpty()) return 0;
        double s = 0;
        for (double x : notas) s += x;
        return s / notas.size();
    }

    static double calcularMaximo() {
        if (notas.isEmpty()) return 0;
        double m = notas.get(0);
        for (double x : notas) if (x > m) m = x;
        return m;
    }

    static double calcularMinimo() {
        if (notas.isEmpty()) return 0;
        double m = notas.get(0);
        for (double x : notas) if (x < m) m = x;
        return m;
    }

    public static void main(String[] args) {
        agregarNota(5.0);
        agregarNota(7.5);
        agregarNota(3.0);
        System.out.println("Media: " + calcularPromedio());
        System.out.println("Máxima: " + calcularMaximo());
        System.out.println("Mínima: " + calcularMinimo());
    }
}
