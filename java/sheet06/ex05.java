// ex05
import java.util.*;
import java.util.function.*;
public class ex05 {
  public static void main(String[] args) {
    List<Double> temps = List.of(5.0, 20.0, 23.0, 31.0, 8.0);
    Predicate<Double> entre = t -> t>=18 && t<=25;
    Predicate<Double> extremos = t -> t<10 || t>30;
    System.out.println("18-25:"); temps.stream().filter(entre).forEach(System.out::println);
    System.out.println("<10 o >30:"); temps.stream().filter(extremos).forEach(System.out::println);
    System.out.println("NO 18-25:"); temps.stream().filter(entre.negate()).forEach(System.out::println);
  }
}