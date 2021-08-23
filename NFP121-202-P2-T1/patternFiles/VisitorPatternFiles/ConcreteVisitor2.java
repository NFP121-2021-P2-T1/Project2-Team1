
public class ConcreteVisitor2 implements AVisitor {
    
    public String visit(AElement e){
        return "Concrete visitor 2 " + e.getName();
    }
    
}
