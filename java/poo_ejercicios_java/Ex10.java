class Persona {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Persona)) {
            return false;
        }
        Persona otra = (Persona) obj;
        if (this.edad != otra.edad) {
            return false;
        }
        if (this.nombre == null && otra.nombre != null) {
            return false;
        }
        if (this.nombre != null && !this.nombre.equals(otra.nombre)) {
            return false;
        }
        return true;
    }
}

class Ex10 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Javi", 21);
        Persona p2 = new Persona("Javi", 21);

        System.out.println(p1.equals(p2));
        System.out.println(p1);
    }
}
