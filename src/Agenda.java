import java.util.ArrayList;

public class Agenda {
    Contacto[] contactos;
    Contacto contacto;
    int cant=10;

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
        int contadorVacias=0;
        int contadorOcupadas=0;
        int posicionVacia=0;


        for (int i=0; i<contactos.length; i++) {
            if (contactos[i] != null) {
                contadorOcupadas++;
            }
        }
        if (contadorOcupadas >= cant) {
       //     System.out.println("No hay espacio disponible en la agenda.");
        } else{
            for (int i=0; i<contactos.length; i++) {
                if (contactos[i] == null){
                contadorVacias++;
                posicionVacia = i;
                }
            }
        contactos[posicionVacia] = contacto;
        }
    }

//    public void mostrarContactos(){
//        System.out.println("Tus Contactos: ");
//        try{
//            for (int i=0; i<contactos.length; i++) {
//                System.out.println(i + 1 + " " + contactos[i].getNombre() + " " + contactos[i].getApellido() + " : " + contactos[i].getTelefono());
//        }
//        } catch (NullPointerException e) {
//            throw new RuntimeException("No existe");
//        }
//    }

    public void existeContacto(Contacto contacto){
        for (int i=0; i<contactos.length; i++) {
                if (contactos[i].getNombre().equals(contacto.getNombre()) && contactos[i].getApellido().equals(contacto.getApellido())) {
                    System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " ya existe en tu agenda");
                }
        }
    }
}
