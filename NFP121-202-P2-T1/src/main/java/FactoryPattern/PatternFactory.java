/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import FactoryPattern.BuilderPatternFrame;
import FactoryPattern.BuilderPatternFrame;
import FactoryPattern.CompositePatternFrame;
import FactoryPattern.CompositePatternFrame;
import FactoryPattern.DecoratorPatternFrame;
import FactoryPattern.DecoratorPatternFrame;
import FactoryPattern.MementoPatternFrame;
import FactoryPattern.MementoPatternFrame;
import FactoryPattern.PatternPanelTemplate;
import FactoryPattern.PatternPanelTemplate;
import FactoryPattern.SingletonPatternFrame;
import FactoryPattern.SingletonPatternFrame;
import FactoryPattern.VisitorPatternFrame;
import FactoryPattern.VisitorPatternFrame;

/**
 *
 * @author Cynthia
 */
public class PatternFactory {
    
    private PatternPanelTemplate p;
    //p = BuilderPatternFrame.getInstancFrame();
    public PatternPanelTemplate getPattern(){
        switch (p.getTitle()) {
            case "Builder Pattern":
                return (PatternPanelTemplate) BuilderPatternFrame.getInstancFrame();
            case "Singleton Pattern":
                return (PatternPanelTemplate) SingletonPatternFrame.getInstancFrame();
            case "Decorator Pattern":
                return (PatternPanelTemplate) DecoratorPatternFrame.getInstancFrame();
            case "Composite Pattern":
                return (PatternPanelTemplate) CompositePatternFrame.getInstancFrame();
            case "Memento Pattern":
                return (PatternPanelTemplate) MementoPatternFrame.getInstancFrame();
            case "Visitor Pattern":
                return (PatternPanelTemplate) VisitorPatternFrame.getInstancFrame(); 
            default:
                break;
        }
        return null;
}
}
