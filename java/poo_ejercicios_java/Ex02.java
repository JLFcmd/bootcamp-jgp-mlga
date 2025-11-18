class Producto2 {
    String nombre;
    double precio;
    int stock;

    Producto2(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    Producto2(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("--------------");
    }
}

class Ex02 {
    public static void main(String[] args) {
        Producto2 p1 = new Producto2("Manzanas", 0.75, 100);
        Producto2 p2 = new Producto2("Leche", 1.20);

        p1.mostrarDatos();
        p2.mostrarDatos();
    }
}
