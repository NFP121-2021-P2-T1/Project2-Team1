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
public class ConcreteDecoratorB extends Decorator {
    
    public ConcreteDecoratorB (Component c){
        
        super(c);
        
    }
    public String operation(){
        
        return super.operation()+"";
        
    }
}
