// ex04
import java.util.*;
import java.util.function.*;
class Producto { String nombre; double precio; Producto(String n, double p){ nombre=n; precio=p; }}
public class ex04 {
  public static void main(String[] args) {
    List<Producto> productos = List.of(new Producto("Pan",1.0), new Producto("Agua",0.5));
    Function<Producto,String> texto = p -> "Producto: " + p.nombre + " — Precio: " + p.precio + "€";
    productos.forEach(p -> System.out.println(texto.apply(p)));
  }
}