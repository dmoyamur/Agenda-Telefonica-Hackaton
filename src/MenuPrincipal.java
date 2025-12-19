import java.util.Scanner;


public class MenuPrincipal {
    Contacto contacto;

    public MenuPrincipal() {
    }

    public void mostrarMenu(){
        Agenda agenda = new Agenda();
        agenda.asignarTamanoAgenda();
        Scanner scanner=new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n===========================");
            System.out.println("-- AGENDA TELEFONICA --");
            System.out.println("-- OPCIONES --");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Modificar Teléfono");
            System.out.println("6. SALIR");
            System.out.println("Seleccione una opción del menú: ");
            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0;
            }
            switch (opcion){
                case 1:
                    boolean info_valida =false;
                    while(!info_valida){
                        System.out.println("Ingrese el nombre del contacto a crear: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese el apellido del contacto a crear: ");
                        String apellido = scanner.nextLine();
                        System.out.println("Ingrese el número de teléfono: ");
                        String tel = scanner.nextLine();
                        if (!nombre.trim().isEmpty() && !apellido.trim().isEmpty() && tel.length() == 10) {
                            long telefono = Long.parseLong(tel);
                            Contacto c = new Contacto(nombre, apellido, telefono);
                            agenda.anadirContacto(c);
                            info_valida = true;
                        }else{
                            System.out.println("El nombre y apellido no pueden estar vacios y el teléfono debe tener 10 dígitos");
                        }
                    }
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
                    scanner.nextLine();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo");
                    break;
            }
        }while(opcion!=6);
        System.out.println("Gracias por usar nuestros servicios.");

    }
}
