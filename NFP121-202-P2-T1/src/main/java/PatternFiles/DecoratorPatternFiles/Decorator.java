/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.DecoratorPatternFiles;

/**
 *
 * @author Cynthia
 */
public abstract class Decorator implements Component {
    
    private Component component;
    
    public Decorator (Component c){
        
        component = c;
        
    }
    public String operation(){
        
        return component.operation();
        
    }
    
}
