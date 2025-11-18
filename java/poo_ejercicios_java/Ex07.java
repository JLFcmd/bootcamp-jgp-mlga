class Conversor {

    double convertir(double euros, double tasa) {
        double resultado = euros * tasa;
        return resultado;
    }

    double convertir(double temperatura, boolean aFahrenheit) {
        if (aFahrenheit) {
            double f = temperatura * 9 / 5 + 32;
            return f;
        } else {
            double c = (temperatura - 32) * 5 / 9;
            return c;
        }
    }

    String convertir(String texto, int mayusculas) {
        if (mayusculas > 0) {
            return texto.toUpperCase();
        } else {
            return texto.toLowerCase();
        }
    }
}

class Ex07 {
    public static void main(String[] args) {
        Conversor c = new Conversor();

        double dolares = c.convertir(100.0, 1.1);
        double fahrenheit = c.convertir(25.0, true);
        String texto = c.convertir("Hola Mundo", 1);

        System.out.println("Dólares: " + dolares);
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Texto: " + texto);
    }
}
