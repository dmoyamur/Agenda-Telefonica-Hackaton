package interaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    //le asigno a una variable el objeto JFrame para que pueda acceder a sus metodos y construir la interfaz
    private JFrame ventana;

    //Constructor
    public VentanaPrincipal(){
        //Primero
        ventana = new JFrame();
        ventana.setTitle("Agenda");

        //Esto va a Oculta la ventana y libera recursos nativos, no la cierra
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //aca le asigno las dimensiones a la ventana
        ventana.setSize(800, 500);
        //Aqui centro la app a la pantalla
        ventana.setLocationRelativeTo(null);

        //container de los botones
        JPanel containerBotones = new JPanel();
        //FlowLayout.CENTER /.LEFT .RIGHT ETC - Define la alineación de los componentes dentro del panel
        //10 - Es el espacio horizontal en píxeles entre los componentes.
        // 5 - Es el espacio vertical (en píxeles) entre las filas de componentes.
        containerBotones.setLayout(new FlowLayout( FlowLayout.CENTER, 10, 5));
        containerBotones.setBackground(Color.LIGHT_GRAY);


        //container de contenido
        JPanel containerContenido = new JPanel();
        containerContenido.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        containerContenido.setBackground(Color.GRAY);

        //Botones
        Button botonVerContactos = new Button("Ver Contactos");
        Button botonAgregarContacto = new Button("Agregar Contacto");

        botonAgregarContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel containerAgregar = new JPanel();
                containerContenido.add(containerAgregar);
                containerAgregar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
                containerAgregar.setBackground(Color.white);
                System.out.println("Se ha presionado el boton para agregar un nuevo contacto");
            }
        });

        // Se agregan los botones a su container
        containerBotones.add(botonAgregarContacto);
        containerBotones.add(botonVerContactos);

        //Aca agrego los containers a la ventana  ajusto la posicion del container de botones

        ventana.add(containerContenido, BorderLayout.CENTER);
        ventana.add(containerBotones, BorderLayout.NORTH);



        //mostrar la agenda
        ventana.setVisible(true);
    }


}
