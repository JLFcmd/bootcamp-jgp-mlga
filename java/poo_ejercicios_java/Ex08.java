class Sesion {
    static int contadorTotal = 0;
    int id;

    Sesion() {
        contadorTotal = contadorTotal + 1;
        id = contadorTotal;
    }

    void mostrarId() {
        System.out.println("ID de sesión: " + id);
    }

    static void mostrarTotal() {
        System.out.println("Total de sesiones creadas: " + contadorTotal);
    }
}

class Ex08 {
    public static void main(String[] args) {
        Sesion s1 = new Sesion();
        Sesion s2 = new Sesion();
        Sesion s3 = new Sesion();

        s1.mostrarId();
        s2.mostrarId();
        s3.mostrarId();

        Sesion.mostrarTotal();
    }
}
