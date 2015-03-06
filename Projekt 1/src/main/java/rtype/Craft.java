/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 * copied from http://zetcode.com/tutorials/javagamestutorial/movingsprites/
 */


package rtype;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

public class Craft {


    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
//    private String craft = "paw_lo_res.png";


    public Craft() {
        
   
        try
        {
            BufferedImage bImage = ImageIO.read(getClass().getClassLoader().getResource("paw_lo_res.png"));
            ImageIcon ii = new ImageIcon(bImage);
            image = ii.getImage();
        }
        catch (IOException e)
        {
            System.err.println("image not found: " + e.getMessage());
        }
               

        x = 40;
        y = 60;

        
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}