package juegomemoria;

//librerias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class menuinicio extends JFrame implements ActionListener {
    JLabel nomjudador,etiqueta;
    JButton creditos,iniciarjuego,salir;
    JTextField txtnomjugador;

    public menuinicio(){
        this.setTitle("Proyecto");
        this.setSize(1010, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        componentes();
    }

    /**
     * Metodo que tiene todos los botones del menu
     */

    public void componentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        etiqueta = new JLabel("Juego de Memoria ");
        etiqueta.setBounds(380,60,300,60);
        etiqueta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
        panel.add(etiqueta);
        /**
         *  Es donde se coloca el nombre de jugador
         */

        etiqueta = new JLabel("Nombre de jugador");
        etiqueta.setBounds(400,250,250,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
        panel.add(etiqueta);


        txtnomjugador = new JTextField();
        txtnomjugador.setBounds(300,300,400,40);
        txtnomjugador.setHorizontalAlignment(JTextField.CENTER);
        txtnomjugador.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
        panel.add(txtnomjugador);

        /**
         * Boton para iniciar la partida
         */
        iniciarjuego = new JButton("Jugar");
        iniciarjuego.setBounds(370,400,250,40);
        iniciarjuego.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        iniciarjuego.addActionListener(this);
        panel.add(iniciarjuego);


        /**
         * Boton salir
         */
        salir = new JButton("Salir");
        salir.setBounds(370,500,250,40);
        salir.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        salir.addActionListener(this);
        panel.add(salir);


    }

    //eventos de acción

    @Override
    public void actionPerformed(ActionEvent e) {

        //este evento realiza la acción del boton iniciar juego
        if(e.getSource() == iniciarjuego){

            //se coloca un if para colocar una excepcion a la hora de iniciar el juego
            if(txtnomjugador.getText().equals("")){
                //si en el txtnomjugador no se encuentra ningun valor
                JOptionPane.showMessageDialog(null, "Introduzca el nombre del jugador");
                //mandara un mensaje diciendo que tiene que colocar algun nombre
            }else{
                //de lo contrario, se inicializara el juego de memoria
                //se manda a llamar la clase JuegoMemoria
                JuegoMemoria ventana = new JuegoMemoria();
                //decimos que nombreju de la clase JuegoMemoria
                //va a obtener el valor que se coloco en el txtnomjugador
                ventana.nombreju.setText(txtnomjugador.getText());
                //esto se coloca para inicializar el tiempo de la clase JuegoMemoria
                ventana.tiempo.start();
                //mostramos la ventana de la clase JuegoMemoria
                ventana.setVisible(true);
                //ocultamos la ventana de menuinicial
                this.setVisible(false);


            }
        }

        //este es el evento del boton salir
        if(e.getSource() == salir){
            //se mostrara una ventana donde hace una pregunta y tiene las opciones de salir o no
            if (JOptionPane.showConfirmDialog(rootPane, "¿Quiere salir del juego?",
                    "Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
                System.exit(0);
        }

    }
}
