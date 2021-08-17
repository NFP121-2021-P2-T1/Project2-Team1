/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.SingletonPatternFiles;

/**
 *
 * @author Cynthia
 */
public class Singleton1 {
    
    private static Singleton1 only; 
    
    private Singleton1() { } 
    
    public static Singleton1 getOnly() {   
        
    if (only == null)  only = new Singleton1();   
    return only;  
    
    } 

}
