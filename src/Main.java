import interaz.VentanaPrincipal;

import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                VentanaPrincipal agenda = new VentanaPrincipal();

            }
        });

            Contacto contacto1 = new Contacto("Luis","Suarez",3152528596L);
            Contacto contacto2 = new Contacto("Luis","Peña",3208579654L);
            Contacto contacto3 = new Contacto("Juan","Diaz",3152528596L);
            Contacto contacto4 = new Contacto("Maria","Diaz",3152528596L);
            Contacto contacto5 = new Contacto("Marcela","Diaz",3152528596L);
            Contacto contacto6 = new Contacto("Marcela","Muñoz",3152528596L);
            Contacto contacto7 = new Contacto("Julian","Diaz",3152528596L);
            Contacto contacto8 = new Contacto("Mateo","Diaz",3152528596L);
            Contacto contacto9 = new Contacto("Adrian","Diaz",3152528596L);
            Contacto contacto10 = new Contacto("Valetina","Diaz",3152528596L);
            Contacto contacto11 = new Contacto("Miguel","Diaz",3152528596L);

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Ingrese la cantidad de contactos que desea agregar a la agenda: ");
        //scanner.nextInt();
        Agenda agenda1 = new Agenda();
        agenda1.anadirContacto(contacto1);
        agenda1.anadirContacto(contacto2);
        agenda1.anadirContacto(contacto3);
        agenda1.anadirContacto(contacto4);
        agenda1.anadirContacto(contacto5);
        agenda1.anadirContacto(contacto6);
        agenda1.anadirContacto(contacto7);
        agenda1.anadirContacto(contacto8);
        agenda1.anadirContacto(contacto9);
        agenda1.anadirContacto(contacto10);
        agenda1.anadirContacto(contacto11);

        agenda1.eliminarContacto(contacto1);

        agenda1.mostrarContactos();
        agenda1.modificarTelefono("Juan","Diaz","3229999999");
        agenda1.buscaContacto("Miguel","Diaz");
        agenda1.espacioslibres();
        agenda1.agendallena();



        }
}