// ex02
import java.util.*;
public class ex02 {
  public static void main(String[] args) {
    List<Integer> nums = List.of(5, 12, 47, 105, 89, 2, 100, 34);
    int suma = nums.stream().filter(n -> n > 10 && n < 100).mapToInt(n -> n).sum();
    System.out.println(suma);
  }
}