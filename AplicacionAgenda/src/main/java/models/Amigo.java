package models;
public class Amigo extends Persona {
    public Amigo (String nombre, String apellido, String relacionApodo){

    }
    public Amigo() {
        super();
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", relacionApodo='" + relacionApodo + '\'' +
                '}';
    }
}
