package models;

import java.util.ArrayList;

public class Lista {
    private ArrayList<Contacto> contactos;
    private ArrayList<Persona> personas;

    public Lista() {
        this.contactos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public ArrayList<Contacto> obtenerContactos() {
        return contactos;
    }

    public String mostrarContactos() {
        StringBuilder builder = new StringBuilder();
        for (Contacto contacto : obtenerContactos()) {
            builder.append("Seudonimo: ").append(contacto.getSeudonimo())
                    .append(" Numero de telefono: ").append(contacto.getNumTel()).append("\n");
        }
        return builder.toString();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public boolean eliminarContacto(String seudonimoAux) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getSeudonimo().equalsIgnoreCase(seudonimoAux)) {
                contactos.remove(i);
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////////////////////

    public void agregarPersona(Persona persona) {
        personas.add(persona);
        for (Persona persona1: personas){
            System.out.println(persona1.getNombre() + " " + persona1.getApellido());
        }
    }

    public boolean eliminarPersona(String nombre) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                personas.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Persona> listaAmigos() {
        ArrayList<Persona> personasAmigos = new ArrayList<>();
        for (Persona persona : personas){
            if (persona instanceof Amigo) {
                personasAmigos.add(persona);
            }
        }
        return personasAmigos;
    }
    public ArrayList<Persona> listaFamiliares() {
        ArrayList<Persona> personasFamiliares = new ArrayList<>();
        for (Persona persona : personas){
            if (persona instanceof Familiar) {
                personasFamiliares.add(persona);
            }
        }
        return personasFamiliares;
    }

    public String mostrarPersonasPorTipo() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Persona> familiares = listaFamiliares();
        if (familiares.isEmpty()) {
            stringBuilder.append("No se encontraron personas familiares.\n");
        } else {
            stringBuilder.append("Familiares:\n");
            for (Persona persona : familiares) {
                stringBuilder.append(persona.getNombre()).append(" ").append(persona.getApellido()).append("\n");
            }
        }

        ArrayList<Persona> amigos = listaAmigos();
        if (amigos.isEmpty()) {
            stringBuilder.append("No se encontraron personas amigas.\n");
        } else {
            stringBuilder.append("Amigos:\n");
            for (Persona persona : amigos) {
                stringBuilder.append(persona.getNombre()).append(" ").append(persona.getApellido()).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
