public class Contacto {
    private String nombre;
    private String apellido;
    private long telefono;

    public Contacto(String nombre, String apellido,long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;

        int telefonovalidacion = String.valueOf(Math.abs(telefono)).length();
            if (telefonovalidacion!=10){
                System.out.println("Por favor ingrese un número válido. Debe contener 10 dígitos");
            }else{
                this.telefono=telefono;
            }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto " + nombre +" "+ apellido+": "+ telefono;
    }
}


