

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
