// ex08
import java.util.*;
public class ex08 {
  public static void main(String[] args) {
    List<String> nombres = new ArrayList<>(List.of("Pedro","Ana","Lucía","Juan"));
    List<String> l1 = new ArrayList<>(nombres);
    l1.sort((a,b)->a.compareTo(b));
    List<String> l2 = new ArrayList<>(nombres);
    l2.sort(String::compareTo);
    System.out.println(l1);
    System.out.println(l2);
  }
}