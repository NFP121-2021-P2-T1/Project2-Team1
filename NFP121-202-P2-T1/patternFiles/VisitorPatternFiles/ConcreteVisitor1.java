
public class ConcreteVisitor1 implements AVisitor {
    
    public String visit(AElement e){
        return "Concrete visitor 1 " + e.getName();
    }
    
}
