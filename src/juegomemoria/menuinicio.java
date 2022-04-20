package juegomemoria;

/**
 * Librerias
 */

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
     * Método que tiene todos los botones del menu
     */

    public void componentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        etiqueta = new JLabel("JUEGO DE MEMORIA ");
        etiqueta.setBounds(340,60,350,60);
        etiqueta.setFont(new Font("Avengero", Font.PLAIN, 25));
        panel.add(etiqueta);
        /**
         *  Es donde se coloca el nombre de jugador
         */

        etiqueta = new JLabel("Nombre del jugador");
        etiqueta.setBounds(400,250,250,40);
        etiqueta.setFont(new Font("Avengero", Font.PLAIN, 15));
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
        iniciarjuego.setFont(new Font("Avengero", Font.PLAIN, 15));
        iniciarjuego.addActionListener(this);
        panel.add(iniciarjuego);


        /**
         * Boton salir
         */
        salir = new JButton("Salir");
        salir.setBounds(370,450,250,40);
        salir.setFont(new Font("Avengero", Font.PLAIN, 15));
        salir.addActionListener(this);
        panel.add(salir);


    }

    /**
     *Eventos del menu
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * evento del botón para inicial el juego
         */
        if(e.getSource() == iniciarjuego){

            if(txtnomjugador.getText().equals("")){
                /**
                 * si no encuentra el nombre del jugador va a mandar un mensaje recordatorio
                 */
                JOptionPane.showMessageDialog(null, "Introduzca el nombre del jugador");
            }else{
                JuegoMemoria ventana = new JuegoMemoria();
                ventana.nombreju.setText(txtnomjugador.getText());
                ventana.tiempo.start();
                ventana.setVisible(true);
                this.setVisible(false);


            }
        }

        /**
         * evento para el botón de salir
         */
        if(e.getSource() == salir){
            /**
             * Se preguntará si se quiere salir del juego
             */
            if (JOptionPane.showConfirmDialog(rootPane, "¿Quiere salir del juego?",
                    "Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
                System.exit(0);
        }

    }
}
