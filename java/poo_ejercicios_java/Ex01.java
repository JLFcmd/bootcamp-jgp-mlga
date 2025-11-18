class Producto {
    String nombre;
    double precio;
    int stock;

    void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("--------------");
    }
}

class Ex01 {
    public static void main(String[] args) {
        Producto p1 = new Producto();
        p1.nombre = "Manzanas";
        p1.precio = 0.75;
        p1.stock = 100;

        Producto p2 = new Producto();
        p2.nombre = "Leche";
        p2.precio = 1.20;
        p2.stock = 50;

        p1.mostrarDatos();
        p2.mostrarDatos();
    }
}
