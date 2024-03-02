package models;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String relacionApodo;

    public Persona() {

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRelacionApodo() {
        return relacionApodo;
    }
}
