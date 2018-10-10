
package programaagendadecontactos;

/**
 *
 * @author David Melo
 */
public class Contacto {
    
    private String nombre;
    private String apellidos;
    private int telefono;



    public Contacto(String nombre,String apellidos, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.apellidos = null;
        this.telefono = 0;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public boolean equals(Contacto c){
        if(this.nombre.equalsIgnoreCase(c.getNombre())){
            return true;
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return "Nombres y apellidos: " + nombre + " " + apellidos + ", telefono: " + telefono + ".\n";
        
    }
    
}
