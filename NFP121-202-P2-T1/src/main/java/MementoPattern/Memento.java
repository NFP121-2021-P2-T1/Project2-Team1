/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MementoPattern;

/**
 *
 * @author Rim
 */
public class Memento {
    private String textPane;

    public Memento(String textPane) {
        this.textPane = textPane;
    }

    public String getText() {
        return textPane;
    }
    
}
