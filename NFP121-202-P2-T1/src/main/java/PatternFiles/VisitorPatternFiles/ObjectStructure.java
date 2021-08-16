/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.VisitorPatternFiles;
import java.util.*;
/**
 *
 * @author Cynthia
 */
public class ObjectStructure {
    List visitors;
    public ObjectStructure(){
        visitors = new ArrayList();
    }
    
    public void addVisitor(AVisitor v){
        visitors.add(v);
    }
    
    public void removeVisitor(AVisitor v){
        visitors.remove(v);
    }
    
}
