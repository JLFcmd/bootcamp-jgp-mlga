class Direccion {
    String calle;
    int numero;

    Direccion(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }
}

class Vivienda {
    String propietario;
    Direccion direccion;

    Vivienda(String propietario, Direccion direccion) {
        this.propietario = propietario;
        this.direccion = direccion;
    }

    void mostrarInfo() {
        System.out.println("Propietario: " + propietario);
        System.out.println("Dirección: " + direccion.calle + " " + direccion.numero);
    }
}

class Ex05 {
    public static void main(String[] args) {
        Direccion d = new Direccion("Calle Mayor", 10);
        Vivienda v = new Vivienda("Javi", d);
        v.mostrarInfo();
    }
}
