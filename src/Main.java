import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Contacto contacto1 = new Contacto("Luis","Suarez",3152528596L);
            Contacto contacto2 = new Contacto("Luis","Suarez",3208579654L);
            Contacto contacto3 = new Contacto("Juan","Diaz",3152528596L);

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Ingrese la cantidad de contactos que desea agregar a la agenda: ");
        //scanner.nextInt();
        Agenda agenda1 = new Agenda();
        agenda1.anadirContacto(contacto1);
        agenda1.anadirContacto(contacto2);
        agenda1.anadirContacto(contacto3);
        agenda1.anadirContacto(contacto1);


        agenda1.mostrarContactos();

        }
}