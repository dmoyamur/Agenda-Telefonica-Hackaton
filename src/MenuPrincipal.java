import java.util.Scanner;


public class MenuPrincipal {
    Contacto contacto;

    public MenuPrincipal() {
    }

    public void mostrarMenu(){
        Agenda agenda = new Agenda();

        Scanner scanner=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===========================");
            System.out.println("-- AGENDA TELEFONICA --");
            System.out.println("-- OPCIONES --");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Modificar Teléfono");
            System.out.println("6. SALIR");
            System.out.println("Seleccione una opción del menú: ");
            opcion=scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del contacto a crear: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del contacto a crear: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el número de teléfono: ");
                    long telefono = scanner.nextLong();
                    Contacto c = new Contacto(nombre,apellido,telefono);
                    agenda.anadirContacto(c);
                    break;
                case 2:
                    agenda.mostrarContactos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre a buscar: ");
                    String nombre1 = scanner.nextLine();
                    System.out.println("Ingrese el apellido a buscar: ");
                    String apellido1 = scanner.nextLine();
                    agenda.buscaContacto(nombre1, apellido1);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre a eliminar: ");
                    String nombre2 = scanner.nextLine();
                    System.out.println("Ingrese el apellido a eliminar: ");
                    String apellido2 = scanner.nextLine();
                    agenda.eliminarContacto(nombre2, apellido2);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del contacto a modificar: ");
                    String nombre3 = scanner.nextLine();
                    System.out.println("Ingrese el apellido del contacto a modificar: ");
                    String apellido3 = scanner.nextLine();
                    System.out.println("Ingrese el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre3, apellido3, nuevoTelefono);
                    break;
                default:
                    System.out.println("Opción Inválida");
            }
        }while(opcion!=6);
        System.out.println("Gracias por usar nuestros servicios.");

    }
}
