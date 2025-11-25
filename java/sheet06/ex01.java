// ex01
import java.util.*;
public class ex01 {
  public static void main(String[] args) {
    List<String> nombres = List.of("Ana Ruiz", "Juan Pérez", "María Torres", "Sol", "Pedro López");
    List<String> resultado = nombres.stream().filter(n -> n.length() > 9).map(n -> n.toUpperCase()).toList();
    System.out.println(resultado);
  }
}