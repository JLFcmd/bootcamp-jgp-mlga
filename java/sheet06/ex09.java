// ex09
import java.util.*;
public class ex09 {
  public static void main(String[] args) {
    List<String> emails = List.of("ana@gmail.com", null, "juan@yahoo.com", "beatriz@gmail.com", "soporte@", "");
    List<String> doms = emails.stream()
      .filter(e -> e!=null && e.contains("@") && e.indexOf("@")<e.length()-1)
      .map(e -> e.substring(e.indexOf("@")+1))
      .distinct().toList();
    System.out.println(doms);
  }
}