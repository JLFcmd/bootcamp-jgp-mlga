class EmpleadoMejorado {
    String nombre;
    double salario;

    EmpleadoMejorado(String nombre, double salario) {
        if (salario < 0) {
            salario = 0;
        }
        this.nombre = nombre;
        this.salario = salario;
    }

    void aumentarSalario(double cantidad) {
        if (cantidad > 0) {
            salario = salario + cantidad;
        }
    }
}

class EmpresaMejorada {
    EmpleadoMejorado empleado;

    EmpresaMejorada(EmpleadoMejorado empleado) {
        this.empleado = empleado;
    }

    void subirSueldoEmpleado(double cantidad) {
        empleado.aumentarSalario(cantidad);
    }

    void mostrarEmpleado() {
        System.out.println(empleado.nombre + " - " + empleado.salario);
    }
}

class Ex11 {
    public static void main(String[] args) {
        EmpleadoMejorado emp = new EmpleadoMejorado("Lucía", 1500);
        EmpresaMejorada empresa = new EmpresaMejorada(emp);

        empresa.mostrarEmpleado();
        empresa.subirSueldoEmpleado(200);
        empresa.mostrarEmpleado();
    }
}
