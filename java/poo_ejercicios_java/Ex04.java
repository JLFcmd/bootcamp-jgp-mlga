import java.util.ArrayList;
import java.util.List;

class ProductoCarrito {
    String nombre;
    double precio;
    int stock;

    ProductoCarrito(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}

class CarritoCompra {

    class LineaCarrito {
        ProductoCarrito producto;
        int unidades;

        LineaCarrito(ProductoCarrito producto, int unidades) {
            this.producto = producto;
            this.unidades = unidades;
        }

        double subtotal() {
            return producto.precio * unidades;
        }
    }

    List<LineaCarrito> lineas = new ArrayList<LineaCarrito>();

    void agregarProducto(ProductoCarrito p, int unidades) {
        if (p == null) {
            return;
        }
        if (unidades <= 0) {
            return;
        }
        if (p.precio < 0) {
            return;
        }

        for (LineaCarrito linea : lineas) {
            if (linea.producto.nombre.equals(p.nombre)) {
                linea.unidades = linea.unidades + unidades;
                return;
            }
        }

        LineaCarrito nueva = new LineaCarrito(p, unidades);
        lineas.add(nueva);
    }

    void eliminarProducto(String nombre) {
        if (nombre == null) {
            return;
        }

        LineaCarrito borrar = null;
        for (LineaCarrito linea : lineas) {
            if (linea.producto.nombre.equals(nombre)) {
                borrar = linea;
                break;
            }
        }

        if (borrar != null) {
            lineas.remove(borrar);
        }
    }

    double total() {
        double total = 0;
        for (LineaCarrito linea : lineas) {
            total = total + linea.subtotal();
        }
        return total;
    }

    void mostrarResumen() {
        for (LineaCarrito linea : lineas) {
            System.out.println(linea.producto.nombre + " - " + linea.unidades + " x " + linea.producto.precio + " = " + linea.subtotal() + " €");
        }
        System.out.println("Total: " + total() + " €");
        System.out.println("--------------");
    }
}

class Ex04 {
    public static void main(String[] args) {
        ProductoCarrito p1 = new ProductoCarrito("Manzanas", 0.75, 100);
        ProductoCarrito p2 = new ProductoCarrito("Leche", 1.20, 50);

        CarritoCompra carrito = new CarritoCompra();
        carrito.agregarProducto(p1, 3);
        carrito.agregarProducto(p2, 2);
        carrito.mostrarResumen();

        carrito.agregarProducto(p1, 2);
        carrito.eliminarProducto("Leche");
        carrito.mostrarResumen();
    }
}
