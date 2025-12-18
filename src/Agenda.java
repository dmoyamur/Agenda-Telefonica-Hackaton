public class Agenda {
    Contacto[] contactos;
    Contacto contacto;
    int cant = 10;

    public Agenda() {
        contactos = new Contacto[cant];
    }

    public Agenda(int cant) {
        this.cant = cant;
        this.contactos = new Contacto[this.cant];
    }

    public Contacto[] getContactos() {
        return contactos;
    }

    public void anadirContacto(Contacto contacto) {
        int contadorVacias = 0;
        int contadorOcupadas = 0;
        int posicionVacia = 0;

        if (existeContacto(contacto)) {
            System.out.println("Contacto ya existe");
            return;
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) {
                    contadorOcupadas++;
                }
            }
            if (contadorOcupadas >= cant) {
                agendallena();
            } else {
                for (int i = 0; i < contactos.length; i++) {
                    if (contactos[i] == null) {
                        contadorVacias++;
                        posicionVacia = i;
                        break;
                    }
                }
                contactos[posicionVacia] = contacto;
                System.out.println("El contacto se ha agregado satisfactoriamente.");
                espacioslibres();
            }
        }
    }

    public void mostrarContactos() {
        System.out.println("\n-- AGENDA DE CONTACTOS -- ");
        boolean hayContactos = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                hayContactos = true;
                System.out.println(i + 1 + " " + contactos[i].getNombre() + " " + contactos[i].getApellido() + " : " + contactos[i].getTelefono());
            }
        }
        if (!hayContactos) {
            System.out.println("Aún no tienes contactos en tu agenda");
        }
    }

    public boolean existeContacto(Contacto contacto) {
        boolean hayContactos = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                if (contactos[i].getNombre().equalsIgnoreCase(contacto.getNombre()) && contactos[i].getApellido().equalsIgnoreCase(contacto.getApellido())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agendallena() {
        int contadorOcupadas = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                contadorOcupadas++;
            }
        }
        if (contadorOcupadas == cant) {
            System.out.println("\nNo hay espacio disponible para nuevos contactos.");
            System.out.println("Ya ha alcanzado el límite de " + cant + " registros disponibles.");
        }
    }

    public void espacioslibres() {
        int contadorOcupadas = 0;
        int libres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                contadorOcupadas++;
                libres = cant - contadorOcupadas;
            }
        }
        if (contadorOcupadas < cant) {
            ;
            System.out.println("\nTienes " + libres + " espacios disponibles para agregar contactos");
        } else {
            agendallena();
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                if (contactos[i].getNombre().equalsIgnoreCase(nombre) && contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                    contactos[i].setTelefono(Long.parseLong(nuevoTelefono));
                    System.out.println("Telefono modificado satisfactoriamente");
                }
            } else {
                System.out.println("El contacto no existe");
                break;
            }
        }
    }


    public void buscaContacto(String nombre, String apellido) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                if (contactos[i].getNombre().equalsIgnoreCase(nombre) && contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                    System.out.println("El contacto existe y su teléfono es: " + contactos[i].getTelefono());
                }
            } else {
                System.out.println("Contacto no encontrado en la busqueda");
                break;
            }
        }
    }

    public void eliminarContacto(String nombre, String apellido) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null &&
                    contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {

                contactos[i] = null;
                System.out.println("Contacto eliminado correctamente: "
                        + nombre + " " + apellido);
                espacioslibres();
                return;
            }
        }
        System.out.println("Contacto no encontrado para eliminar.");
    }

    public void asignarTamanoAgenda(int cantidad) {
        if (cantidad > 0) {
            System.out.println("Asigne el tamaño de la agenda si deseas un valor diferente a 10 registros: ");
            this.cant = cantidad;
        } else {
            this.cant = 10;
        }
    }

}