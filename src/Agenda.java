import java.util.ArrayList;

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

        if (existeContacto(contacto)){
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
                System.out.println(contacto.getNombre()+" "+ contacto.getApellido()+" se ha agregado satisfactoriamente.");
            }
        }
        }

    public void mostrarContactos() {
        System.out.println("\n-- AGENDA DE CONTACTOS -- ");
        boolean hayContactos = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                hayContactos = true;
                System.out.println(i+1 + " " + contactos[i].getNombre() + " " + contactos[i].getApellido() + " : " + contactos[i].getTelefono());
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

    public void agendallena(){
        int contadorOcupadas = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                contadorOcupadas++;
            }
        }
        if (contadorOcupadas == cant) {
            System.out.println("\nNo hay espacio disponible para nuevos contactos.");
            System.out.println("Ya ha alcanzado el límite de "+cant+" registros disponibles.");
        }
    }

}