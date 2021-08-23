/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MementoPattern;

import BuilderPattern.SplitPane;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class Originator {

    private static Originator originator;
    private String textPane ;

    private Originator(String textPane) {
        this.textPane = textPane;
    }
    
    //______________________________
    public Memento saveToMemento()
    {
        return new Memento(textPane);
    }
    
    public void getFromMemento(Memento m )
    {
        textPane = m.getText();
    }

    public static Originator getOriginator() {
        if(originator == null)
            originator = new Originator(null);
        return originator;
    }
    public static Originator getOriginator(String t) {
        if(originator == null)
            originator = new Originator(t);
        return originator;
    }

    public  void setOriginator(Originator originator) {
        Originator.originator = originator;
    }

    public void setTextPane(String textPane) {
        this.textPane = textPane;
    }
    
    
    
}
