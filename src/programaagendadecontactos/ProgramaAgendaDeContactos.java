package programaagendadecontactos;
//Importacion de librerias
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * @author David Melo
 */
public class ProgramaAgendaDeContactos {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        int opcion; //Guardemos la opcion del usuario
        
        //Nueva agendaDeContactos con capacidad de 5 espacios
        Agenda agendaDeContactos = new Agenda(5);
        String nombre;//Nombres del contacto
        String apellidos = null;//Apellidos del contacto
        int telefono;//Telefono del contacto
        Contacto c;
        
        //Menu principal
        while (!salir){
            System.out.println("\tMenu principal\n");
            System.out.println("1. Añadir contacto.");
            System.out.println("2. Mostrar contactos.");
            System.out.println("3. Buscar contacto.");
            System.out.println("4. Eliminar contacto.");
            System.out.println("5. Espacios en la agenda disponibles.");
            System.out.println("6. Salir.");
            
            try{//Despues de mostrar las opciones se solicita escoger la opcion
                System.out.println("\nEscribe una de las opciones: ");
                //opcion = sn.nextInt();
                String entrada = br.readLine();
                opcion = Integer.parseInt(entrada);
                
                //De acuerdo a la opcion dada hacer accion.
                switch (opcion){
                    case 1://Añadir contacto
                        System.out.println("Nombre del nuevo contacto: ");
                        nombre = br.readLine();
                        
                        System.out.println("Apellido del nuevo contacto: ");
                        apellidos = br.readLine();
                        
                        System.out.println("Telefono de "+ nombre +" " + apellidos + " es: "); 
                        String tel = br.readLine();
                        telefono = Integer.parseInt(tel);
                        
                        c = new Contacto(nombre, apellidos, telefono);
                        agendaDeContactos.anadirContacto(c);
                        break;
                    case 2://Mostrar contactos
                        agendaDeContactos.mostrarContactos();
                        break;
                    case 3://Buscar contacto
                        System.out.println("Ingrese nombre del contacto para buscar: ");
                        nombre = br.readLine();
                        
                        agendaDeContactos.buscarPorNombre(nombre);
                        break;
                    case 4://Eliminar contacto
                        System.out.println("Ingrese nombre: ");
                        nombre = br.readLine();
                        
                        
                        c = new Contacto(nombre,apellidos, 0);//Nos sirve como auxiliar
                        
                        agendaDeContactos.eliminarContacto(c);
                        break;
                    case 5://Espacios en la agenda disponibles
                        System.out.println("Hay "+agendaDeContactos.espaciosLibres()+" en la agenda para añadir.\n");
                        break;
                    case 6://Salir
                        salir = true;
                        System.out.println("Saliendo del programa.\n");
                        break;
                    default:
                        System.out.println("Error: Opcion incorrecta.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insertar un nombre.");
            }
        }
    }
    
}
