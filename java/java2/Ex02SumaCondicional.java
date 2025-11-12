public class Ex02SumaCondicional {
    static int sumarSiPositivo(int a, int b) {
        if (a > 0 && b > 0) return a + b;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sumarSiPositivo(3, 5));
        System.out.println(sumarSiPositivo(-2, 4));
    }
}
