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
public class ConcreteVisitor1 implements AVisitor {
    
    public String visit(AElement e){
        return "Concrete visitor 1 " + e.getName();
    }
    
}
