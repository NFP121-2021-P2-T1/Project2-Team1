/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import javax.swing.*;

public class Director extends JFrame {

    public void construct(Builder mainFrame) {
        mainFrame.build();
    }
}
