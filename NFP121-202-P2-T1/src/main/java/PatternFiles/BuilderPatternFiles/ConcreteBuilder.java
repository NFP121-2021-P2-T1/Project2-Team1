/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.BuilderPatternFiles;

/**
 *
 * @author Cynthia
 */
public class ConcreteBuilder implements Builder{
    
    private Product product;
    
    public ConcreteBuilder(){
        
    }
    public Product getProduct() {
        return product;
    }
    
    public void buildPart(){
        //build part
    }
    
    public Product getResult(){
        return new Product();
    }
}
