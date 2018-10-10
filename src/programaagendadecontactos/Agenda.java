package programaagendadecontactos;

/**
 * @author David Melo
 */
public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        this.contactos = new Contacto[10];
    }

    public Agenda(int tamano) {
        this.contactos = new Contacto[tamano];
    }

    public void anadirContacto(Contacto c) {

        if (existeContacto(c)) {
            System.out.println("El contacto con ese nombre ya existe.\n");
        } else if (agendaCompleta()) {
            System.out.println("La agenda esta llena, no se puede añadir mas contactos.\n");
        } else {
            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) {
                    contactos[i] = c;
                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("Se ha añadido el contacto.\n");
            } else {
                System.out.println("No se ha podido añadir el contacto.\n");
            }
        }
    }

    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;
    }

    public void mostrarContactos() {
        if (espaciosLibres() == contactos.length) {
            System.out.println("No hay contactos que mostrar.\n");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) {
                    System.out.println(contactos[i]);
                    
                }
            }
            System.out.println();
        }
    }

    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El telefono del contacto es: " + contactos[i].getTelefono()+ "\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la agenda.\n");
        }
    }

    public boolean agendaCompleta() {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
            }
        }
        return false;
    }

    public void eliminarContacto(Contacto c) {
        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null;
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println("Se ha eliminado el contacto.\n");
        } else {
            System.out.println("No se ha eliminado el contacto.\n");
        }
    }
    

    public int espaciosLibres() {
        int contLibres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contLibres++;
            }
        }
        return contLibres;
    }
}
