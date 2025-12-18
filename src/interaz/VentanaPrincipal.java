package interaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    //le asigno a una variable el objeto JFrame para que pueda acceder a sus metodos y construir la interfaz
    private JFrame window;

    //Constructor
    public VentanaPrincipal(){
        //Primero
        window = new JFrame();
        window.setTitle("Agenda");

        //Esto va a Oculta la ventana y libera recursos nativos, no la cierra
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //aca le asigno las dimensiones a la ventana
        window.setSize(800, 500);
        //Aqui centro la app a la pantalla
        window.setLocationRelativeTo(null);

        //container
        JPanel containerBotones = new JPanel();
        //FlowLayout.CENTER /.LEFT .RIGHT ETC - Define la alineación de los componentes dentro del panel
        //10 - Es el espacio horizontal en píxeles entre los componentes.
        // 5 - Es el espacio vertical (en píxeles) entre las filas de componentes.
        containerBotones.setLayout(new FlowLayout( FlowLayout.CENTER, 10, 5));
        JPanel containerLista = new JPanel();
        containerLista.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        //containerLista.setSize(750,450);
        containerLista.setBackground(Color.GRAY);

        containerBotones.setBackground(Color.LIGHT_GRAY);
        Button botonVerContactos = new Button("Ver Contactos");
        Button botonAgregarContacto = new Button("Agregar Contacto");
        containerBotones.add(botonAgregarContacto);



        containerBotones.add(botonVerContactos);
        //Aca ajusto la posicion del container de botones
        window.add(containerLista, BorderLayout.CENTER);
        window.add(containerBotones, BorderLayout.NORTH);



        //mostrar la agenda
        window.setVisible(true);
    }




}
