/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtype;

/**
 *
 * @author martin
 */

import javax.swing.JFrame;

public class RType extends JFrame {

    public RType() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new RType();
//    }
}
