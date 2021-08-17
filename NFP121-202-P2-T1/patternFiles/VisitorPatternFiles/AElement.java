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
public interface AElement {
    
    public String getName();
    public abstract String accept(AVisitor v);
    
}
