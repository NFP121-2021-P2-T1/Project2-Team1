/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.VisitorPatternFiles;

/**
 *
 * @author Cynthia
 */
public class ConcreteElement1 implements AElement {
    
    public String getName(){
        return "ConcreteElement1";
    }
    
    public String accept(AVisitor v){
        return v.visit(this);
    }
    
}
