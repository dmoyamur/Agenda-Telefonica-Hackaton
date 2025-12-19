import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    //le asigno a una variable el objeto JFrame para que pueda acceder a sus metodos y construir la interfaz
    private JFrame ventana;




    //Constructor que ejecuta la ventana de agenda
    public VentanaPrincipal(Agenda agenda){
        //Primero
        ventana = new JFrame();
        ventana.setTitle("Agenda");

        //Esto va a Oculta la ventana y libera recursos nativos, no la cierra
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aca le asigno las dimensiones a la ventana
        ventana.setSize(800, 500);
        //Aqui centro la ventana  a la pantalla
        ventana.setLocationRelativeTo(null);


        //Container de titulo, como un div
        JPanel containerTitulo = new JPanel();
        containerTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));

        containerTitulo.setBackground(Color.LIGHT_GRAY );
        JLabel labelTitulo = new JLabel("Agenda Contactos");
        labelTitulo.setForeground(Color.black);
        containerTitulo.add(labelTitulo);

        //container de los botones
        JPanel containerBotones = new JPanel();
        //FlowLayout.CENTER /.LEFT .RIGHT ETC - Define la alineación de los componentes dentro del panel
        //10 - Es el espacio horizontal en píxeles entre los componentes.
        // 5 - Es el espacio vertical (en píxeles) entre las filas de componentes.
        containerBotones.setLayout(new BoxLayout(containerBotones, BoxLayout.Y_AXIS));
        containerBotones.setBackground(Color.LIGHT_GRAY);


        //container de contenido
        JPanel containerContenido = new JPanel();
        containerContenido.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        containerContenido.setBackground(Color.GRAY);

        //Botones
        Button botonVerContactos = new Button("Ver Contactos");

        Button botonAgregarContacto = new Button("Agregar Contacto");
        botonAgregarContacto.setSize(80,30);
        botonVerContactos.setSize(80,30);
        botonAgregarContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Esto elimina el container anterior y ejecuta uno nuevo
                containerContenido.removeAll();

                JPanel containerAgregar = new JPanel();
                containerAgregar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
                containerAgregar.setBackground(Color.white);
                containerAgregar.setPreferredSize(new Dimension(650, 420));

                //Entradas de texto
                JLabel labelCampoNombre = new JLabel("Nombre");
                JLabel labelCampoApellido = new JLabel("Apellido");
                JLabel labelCampoTelefono = new JLabel("Telefono");
                JTextField entradaNombre = new JTextField(20);
                JTextField entradaApellido = new JTextField(20);
                JTextField entradaTelefono = new JTextField(20);
                Button botonAgregarContacto = new Button("Agregar");

                botonAgregarContacto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            //Se crea un contacto nuevo
                            Contacto contacto = new Contacto(obtenerNombre(entradaNombre),obtenerApellido(entradaApellido),Long.parseLong(obtenerTelefono(entradaTelefono)));
                            if (agenda.anadirContacto(contacto) == "Contacto ya existe"){
                                JLabel sinContactos = new JLabel("Agenda Llena");
                                containerAgregar.add(sinContactos);
                                containerContenido.add(containerAgregar);
                                containerContenido.revalidate();
                                containerContenido.repaint();
                            }
                            //agenda.anadirContacto(contacto);
                            System.out.println(obtenerNombre(entradaNombre) +" "+ obtenerApellido(entradaApellido) +" "+obtenerTelefono(entradaTelefono));

                    }
                });

                containerAgregar.add(labelCampoNombre);
                containerAgregar.add(entradaNombre);
                containerAgregar.add(labelCampoApellido);
                containerAgregar.add(entradaApellido);
                containerAgregar.add(labelCampoTelefono);
                containerAgregar.add(entradaTelefono);

                containerAgregar.add(botonAgregarContacto);


                //Cuando se hace click al boton se muestra o agrega el container
                containerContenido.add(containerAgregar);
                //Esto recarga la interfaz
                containerContenido.revalidate();
                containerContenido.repaint();


                System.out.println("Se ha presionado el boton para agregar un nuevo contacto");
            }
        });

        botonVerContactos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Esto elimina el container anterior y ejecuta uno nuevo
                containerContenido.removeAll();
                JPanel containerAgregar = new JPanel();
                int ultimoNumero = agenda.getContactos().length;
                containerAgregar.setLayout(new GridLayout(0,3,10,10));
                containerAgregar.setBackground(Color.white);
                containerAgregar.setPreferredSize(new Dimension(650, 420));

                if (agenda.getContactos()[0] == null) {
                    JLabel sinContactos = new JLabel("Aun no tiene contactos");
                    containerAgregar.add(sinContactos);
                    containerContenido.add(containerAgregar);
                    containerContenido.revalidate();
                    containerContenido.repaint();

                } else {
                    for (int i = 0; i < agenda.getContactos().length; i++) {
                        if (agenda.getContactos()[i] != null) {
                            JLabel labelCampoNombre = new JLabel(i + ". " + agenda.getContactos()[i].getNombre() + " " + agenda.getContactos()[i].getApellido() + " " + agenda.getContactos()[i].getTelefono());
                            Button editarContacto = new Button("Editar");
                            Button borrarContacto = new Button("Borrar");
                            borrarContacto.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                }
                            });
                            containerAgregar.add(labelCampoNombre);
                            containerAgregar.add(editarContacto);
                            containerAgregar.add(borrarContacto);
                            containerContenido.add(containerAgregar);
                            containerContenido.revalidate();
                            containerContenido.repaint();
                        }else{
                            JLabel sinContactos = new JLabel("No tiene mas contactos.");
                            containerAgregar.add(sinContactos);
                            containerContenido.add(containerAgregar);
                            containerContenido.revalidate();
                            containerContenido.repaint();
                            break;
                        }
                    }

                    agenda.mostrarContactos();
                }
            }
        });

        // Se agregan los botones a su container
        containerBotones.add(botonAgregarContacto);
        containerBotones.add(botonVerContactos);

        //Aca agrego los containers a la ventana  ajusto la posicion del container de botones

        ventana.add(containerTitulo, BorderLayout.NORTH);
        ventana.add(containerContenido, BorderLayout.CENTER);
        ventana.add(containerBotones, BorderLayout.WEST);



        //mostrar la agenda
        ventana.setVisible(true);
    }

    //Metodos que obtienen los valores de los campos de texto
    public String obtenerNombre(JTextField nombre){
        return nombre.getText();
    }
    public String obtenerApellido(JTextField apellido){
        return apellido.getText();
    }
    public String obtenerTelefono(JTextField telefono){
        return telefono.getText();
    }

    public void mostrarContactos(Agenda agenda){





    }

}
