
public class Singleton1 {
    
    private static Singleton1 only; 
    
    private Singleton1() { } 
    
    public static Singleton1 getOnly() {   
        
    if (only == null)  only = new Singleton1();   
    return only;  
    
    } 

}
