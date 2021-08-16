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
    private String x;
    
    public ConcreteBuilder(String x){
        this.x = x;
    }

    public void buildPart(){
        //build part
        product.setX(x+"");
    }
    
    public Product getResult(){
        return new Product(x);
    }
}
