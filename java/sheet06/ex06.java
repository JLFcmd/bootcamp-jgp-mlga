// ex06
import java.util.*;
import java.util.stream.*;
public class ex06 {
  public static void main(String[] args) {
    List<String> palabras = List.of("sol","luna","estrella","mar","cielo","aire");
    var grupos = palabras.stream().collect(Collectors.groupingBy(p -> p.length()));
    System.out.println(grupos);
  }
}