import java.util.*;

public class Ex05ListaDeTareas {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> lista = new ArrayList<>();

    static void anadir() {
        System.out.print("Tarea: ");
        String t = sc.nextLine();
        if (!t.isBlank()) lista.add(t);
    }

    static void eliminar() {
        mostrar();
        System.out.print("Índice a borrar: ");
        try {
            int i = Integer.parseInt(sc.nextLine());
            if (i >= 0 && i < lista.size()) lista.remove(i);
        } catch (Exception e) {}
    }

    static void mostrar() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
        if (lista.isEmpty()) System.out.println("(vacía)");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1) Añadir  2) Eliminar  3) Mostrar  0) Salir");
            String op = sc.nextLine();
            if (op.equals("1")) anadir();
            else if (op.equals("2")) eliminar();
            else if (op.equals("3")) mostrar();
            else if (op.equals("0")) break;
        }
    }
}
