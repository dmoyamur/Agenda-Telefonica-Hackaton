import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio {
    private JFrame ventana;

    public VentanaInicio(){
        ventana = new JFrame();
        ventana.setTitle("Crear Agenda");

        //Esto va a Oculta la ventana y libera recursos nativos, no la cierra
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aca le asigno las dimensiones a la ventana
        ventana.setSize(800, 500);
        //Aqui centro la ventana  a la pantalla
        ventana.setLocationRelativeTo(null);
        crearAgenda();
        ventana.setVisible(true);
    }
    public void crearAgenda(){
        JPanel containerCrearAgenda = new JPanel();
        containerCrearAgenda.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextField entradaCantidadContactos = new JTextField(5);
        JLabel tituloContainer = new JLabel("Ingrese el numero de la cantidad de contactos que necesita en su agenda: ");
        Button botonCrearAgenda = new Button("Crear Agenda");
        botonCrearAgenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int cantidadContactos = Integer.parseInt(entradaCantidadContactos.getText());
                    if (cantidadContactos > 0){
                        System.out.println("Se ha creado una agenda nueva con un maximo de "+ cantidadContactos + " espacios disponibles en la agenda");
                        Agenda agenda = new Agenda(cantidadContactos);
                        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(agenda);
                    }else{
                        Agenda agenda = new Agenda();
                        System.out.println("Se ha creado una agenda nueva con 10 espacios por defecto disponibles en la agenda");
                        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(agenda);
                    }
                }catch (NumberFormatException exception){
                    Agenda agenda = new Agenda();
                    System.out.println("Se ha creado una agenda nueva con 10 espacios por defecto disponibles en la agenda");
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(agenda);
                }
            }
        });
        containerCrearAgenda.add(tituloContainer);
        containerCrearAgenda.add(entradaCantidadContactos);
        containerCrearAgenda.add(botonCrearAgenda);
        ventana.add(containerCrearAgenda);
    }
}
