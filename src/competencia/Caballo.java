/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competencia;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


/**
 *
 * @author danx_
 */
public class Caballo extends Thread {

    //Atributes
    public static int place = 0;
    private int x;
    private final int y;
    private JLabel c;
    private JTextArea txt, winnerPlace;

    //Methods
    public Caballo(String name, JLabel c, JTextArea txt, JTextArea winner) {
        super(name);
        this.txt = txt;
        this.winnerPlace = winner;
        this.c = c;
        this.x = c.getX();
        this.y = c.getY();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            
            //Create random varable for wait time
            Random r = new Random();
            int low = 0;
            int high = 1000;
            int result = r.nextInt(high - low) + low;
            System.out.println(getName() + " se retrasa " + result + " ms");
            txt.append(getName() + " se retrasa " + result + " ms\n");
            
            try {
                Thread.sleep(result);
            } catch (InterruptedException ex) {
                Logger.getLogger(Caballo.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Asigna nueva posicion a la imagen
            this.x = i * 10;
            c.setLocation(this.x, this.y);
            
        }
        //Imprime cuando llega a la meta
        ++place;
        winnerPlace.append(String.valueOf(place) + ".-"+ getName() +"\n");
        System.out.println("Llega a la meta: " + getName() + " en " + place + " lugar");
        txt.append("Llega a la meta: " + getName() + " en " + place + " lugar" + "\n");
    }
    
}
