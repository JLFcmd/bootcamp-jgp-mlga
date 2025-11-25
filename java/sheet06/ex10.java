// ex10
import java.util.stream.*;
public class ex10 {
  public static void main(String[] args) {
    int imp=0; for(int i=1;i<=10;i++) imp+=i*i; System.out.println(imp);
    System.out.println(sumarCuadrados());
    int func = IntStream.rangeClosed(1,10).map(x->x*x).sum(); System.out.println(func);
  }
  static int sumarCuadrados(){ int s=0; for(int i=1;i<=10;i++) s+=i*i; return s; }
}