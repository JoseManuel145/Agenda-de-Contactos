package models;

public class Familiar extends Persona {
    public Familiar(String nombre, String apellido, String relacionApodo) {
        super();
    }

    public Familiar() {
        super();
    }

    @Override
    public String toString() {
        return "Familiar{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", relacionApodo='" + relacionApodo + '\'' +
                '}';
    }
}
