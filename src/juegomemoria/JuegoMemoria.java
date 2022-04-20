package juegomemoria;

/**
 * Librerias usadas
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.*;


public class JuegoMemoria extends JFrame implements ActionListener{
    JPanel panel;
    JLabel matriz [][],etiqueta,etique,nombreju,cronometro,lblfecha,lblhora;
    int mat [][] = new int[4][5];
    int mat2 [][] = new int[4][5];
    Random ran;
    int contador,ban,ban1,annum,anposx,anposy,acnum,acposx,acposy;
    Timer espera, espera2,tiempo;
    int consegund,seg,min;
    int hora,minutos,segundos;
    JButton reiniciar;



    public JuegoMemoria(){
        this.setTitle("Juego de Memoria");
        this.setSize(1010, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);



        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);


        ran = new Random();
        this.numaleatorios();

        /**
         * Genera la matriz par las imágenes
         */
        matriz = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = new JLabel();
                matriz[i][j].setSize(matriz[i][j].getWidth(), matriz[i][j].getHeight());
                /**
                 * Se les pone un tamaño predeterminado a las imágenes para que se vean bien
                 */
                matriz[i][j].setBounds(350+(j*125),30+(i*156), 125, 156);
                /**
                 * Se toman las imágenes con el nombre del 0 al 10
                 */
                matriz[i][j].setIcon(new ImageIcon("src/imagenes/"+mat2[i][j]+".JPG"));
                /**
                 * Se hacen las matrices visibles para que se muestren las imágenes
                 */
                matriz[i][j].setVisible(true);
                /**
                 * Aquí se añade la imagen 0 que es la del logo de los vengadores
                 */
                panel.add(matriz[i][j],0);


            }

        }


        seg = 0;
        min = 0;


        tiempo = new Timer (1000, new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                seg++;
                if(seg == 60){
                    min++;
                    seg=0;
                }

                /**
                 * se hace una variable para poner un cronometro
                 */
                cronometro.setText(min+":"+seg);
            }});

        /**
         * Se hace la variable para la duración de las cartas en darse la vuelta
         */
        consegund = 0;
        espera = new Timer (200, new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                consegund++;
            }});
        espera.start();
        espera.stop();
        consegund = 0;
        ban=0;
        ban1=0;

        /**
         * Aquí va el evento para el clic de las cartas
         */
        contador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(e.getSource() == matriz[k][l]){


                                    /**
                                     * Cuando se le da al clic la carta se dará la vuelta
                                     */
                                    if(mat2[k][l] == 0 && contador !=2){
                                        mat2[k][l] = mat[k][l];
                                        matriz[k][l].setIcon(new ImageIcon("src/imagenes/"+mat2[k][l]+".JPG"));
                                        contador++;
                                        acnum = mat[k][l];
                                        acposx = k;
                                        acposy = l;
                                        if(contador == 1){
                                            annum = mat[k][l];
                                            anposx = k;
                                            anposy = l;
                                        }


                                        espera2 = new Timer (500, new ActionListener()
                                        {

                                            public void actionPerformed(ActionEvent e) {

                                                if(contador == 2 && ban1 == 0){
                                                    espera.restart();
                                                    ban1=1;
                                                }
                                                if(contador == 2 && consegund == 2){
                                                    espera.stop();
                                                    consegund = 0;

                                                    /**
                                                     * Desaparecerán las cartas iguales y las otras se quedan
                                                     */
                                                    if(mat2[acposx][acposy]==mat2[anposx][anposy]){

                                                        mat2[acposx][acposy] = -1;
                                                        mat2[anposx][anposy] = -1;
                                                        matriz[acposx][acposy].setIcon(new ImageIcon("src/imagenes/"+mat2[acposx][acposy]+".JPG"));
                                                        matriz[anposx][anposy].setIcon(new ImageIcon("src/imagenes/"+mat2[anposx][anposy]+".JPG"));
                                                        contador=0;

                                                        int acum = 0;
                                                        for (int m = 0; m < 4; m++) {
                                                            for (int n = 0; n < 5; n++) {
                                                                if (mat2[m][n] == -1)
                                                                    acum++;
                                                            }
                                                        }
                                                        /**
                                                         * Cuando se encuentren todas las cartas saltará un mensaje de que se ganó
                                                         */
                                                        if(acum == 20){
                                                            JOptionPane.showMessageDialog(panel, "FELICIDADES GANASTE");

                                                            Recordjugador ventana = new Recordjugador();
                                                            ventana.setVisible(true);
                                                            tiempo.stop();
                                                            ventana.lbltiempoju.setText(min+":"+seg);
                                                            ventana.lblnombrejuga.setText(nombreju.getText());
                                                            ventana.lblhorainicio.setText(lblhora.getText());
                                                            ventana.lblfechaju.setText(lblfecha.getText());

                                                        }
                                                    }
                                                    for (int m = 0; m < 4; m++) {
                                                        for (int n = 0; n < 5; n++) {
                                                            if(mat2[m][n]!=0 && mat2[m][n]!=-1){
                                                                mat2[m][n] = 0;
                                                                matriz[m][n].setIcon(new ImageIcon("src/imagenes/"+mat2[m][n]+".JPG"));
                                                                contador=0;

                                                            }
                                                            System.out.println("Carta");

                                                        }

                                                    }
                                                    espera2.stop();
                                                    ban1=0;
                                                }
                                            }});
                                        if(ban == 0)
                                            espera2.start();
                                        ban = 1;
                                        if(contador == 2)
                                            espera2.restart();
                                    }

                                }

                            }

                        }
                    }


                });

            }

        }


        componentes();
        lblfecha.setText(fecha());
        hora();

    }

    /**
     * para que tome la hora de la compu
     */
    private void hora(){
        Calendar calendario = new GregorianCalendar();
        hora= calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        lblhora.setText(hora + ":" + minutos);
    }

    /**
     *
     * Toma la fecha de la compu
     */
    private String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);

    }

    /**
     * Cada vez que se inicia una partida nueva las cartas cambian de posición
     */
    private void numaleatorios(){
        int acumulador = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++){
                mat[i][j] = 0;
                //  mat2[i][j] = 0;

            }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = ran.nextInt(10)+1;

                do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
                            if(mat[i][j]== mat[k][l]){
                                acumulador +=1;
                            }
                        }
                    }
                    /**
                     * Duplica las cartas
                     */
                    if(acumulador == 3){
                        mat[i][j] = ran.nextInt(10)+1;
                    }
                }while(acumulador == 3);
            }
        }





    }


    /**
     * Los labels del juego
     */
    private void componentes(){
        etiqueta = new JLabel("Jugador: ");
        etiqueta.setBounds(40,40,150,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        panel.add(etiqueta);

        nombreju = new JLabel();
        nombreju.setBounds(135,40,150,40);
        nombreju.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(nombreju);

        etiqueta = new JLabel("Tiempo: ");
        etiqueta.setBounds(40,80,150,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        panel.add(etiqueta);


        cronometro = new JLabel();
        cronometro.setBounds(135,80,150,40);
        cronometro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(cronometro);

        etiqueta = new JLabel("Hora inicio: ");
        etiqueta.setBounds(40,120,150,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        panel.add(etiqueta);


        lblfecha = new JLabel();
        lblfecha.setBounds(135,160,150,40);
        lblfecha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblfecha);

        etiqueta = new JLabel("Fecha: ");
        etiqueta.setBounds(40,160,150,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        panel.add(etiqueta);


        lblhora = new JLabel();
        lblhora.setBounds(135,120,150,40);
        lblhora.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblhora);


        reiniciar = new JButton("Reiniciar partida");
        reiniciar.setBounds(80,560,200,40);
        reiniciar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        reiniciar.addActionListener(this);
        panel.add(reiniciar);

    }


    /**
     * Eventos del juego
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * Para el botón de reiniciar partida
         */
        if(e.getSource() == reiniciar){
            if (JOptionPane.showConfirmDialog(rootPane, "¿Quiere reiniciar la partida?\n Perderá todo el progreso realizado.",
                    "Reiniciar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            {
                menuinicio ventana = new menuinicio();
                ventana.setVisible(true);
                this.setVisible(false);
            }
            else{
                setDefaultCloseOperation(0);
            }
        }
    }

}
