package juegomemoria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Recordjugador extends JFrame implements ActionListener{

    JLabel lblnombrejuga, lbltiempoju, lblhorainicio, lblfechaju,etiqueta;
    JButton regresar;
    public Recordjugador(){
        this.setTitle("Record de Jugador");
        this.setSize(1010, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        /**
         * Se agrega el panel para mostrar el record
         */
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        etiqueta = new JLabel("Record");
        etiqueta.setBounds(430,60,150,40);
        etiqueta.setFont(new Font("Avengero", Font.PLAIN, 35));
        panel.add(etiqueta);

        etiqueta = new JLabel("Jugador: ");
        etiqueta.setBounds(320,180,150,40);
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(etiqueta);

        /**
         * Se usará el nombre del jugador que se usó en la partida
         */
        lblnombrejuga = new JLabel("nombre");
        lblnombrejuga.setBounds(480,180,150,40);
        lblnombrejuga.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblnombrejuga);

        etiqueta = new JLabel("Tiempo Final: ");
        etiqueta.setBounds(320,240,150,40);
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(etiqueta);

        /**
         * Mostrará el tiempo que se tardó encontrando las parejas
         */
        lbltiempoju = new JLabel("tiempo");
        lbltiempoju.setBounds(480,240,150,40);
        lbltiempoju.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lbltiempoju);

        etiqueta = new JLabel("Hora inicial: ");
        etiqueta.setBounds(320,300,150,40);
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(etiqueta);

        /**
         * Se mostrará la hora de inicio de la partida
         */
        lblhorainicio = new JLabel("hora");
        lblhorainicio.setBounds(480,300,150,40);
        lblhorainicio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblhorainicio);

        etiqueta = new JLabel("Fecha: ");
        etiqueta.setBounds(320,360,150,40);
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(etiqueta);

        /**
         * Se mostrará la fecha en la que se jugó
         */
        lblfechaju = new JLabel("fecha");
        lblfechaju.setBounds(480,360,150,40);
        lblfechaju.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblfechaju);

        regresar = new JButton("Regresar a Menu");
        regresar.setBounds(370,560,250,40);
        regresar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
        regresar.addActionListener(this);
        panel.add(regresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * Sirve para mostrar el botón para regresar al menú
         */
        if(e.getSource() == regresar){
            menuinicio ventana = new menuinicio();
            JuegoMemoria ventana2 = new JuegoMemoria();
            ventana2.setVisible(false);
            ventana.setVisible(true);
            this.setVisible(false);

        }
    }

}
