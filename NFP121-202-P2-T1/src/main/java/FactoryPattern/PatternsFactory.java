/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

/**
 *
 * @author Cynthia
 */
public class PatternsFactory {

    //private static PatternF patternFact;

    /*private PatternF() {

    }*/

    /*public static PatternF getInstanceFactory() {
        if (patternFact == null) {
            patternFact = new PatternF();
        }
        return patternFact;
    }*/

    public PatternPanelTemplate getPattern(String name) {
        if (name == null) {
            return null;
        } else if (name.equals("Builder Pattern")) {
            return BuilderPatternFrame.getInstancFrame();
        } else if (name.equals("Singleton Pattern")) {
            return SingletonPatternFrame.getInstancFrame();
        } else if (name.equals("Composite Pattern")) {
            return CompositePatternFrame.getInstancFrame();
        } else if (name.equals("Decorator Pattern")) {
            return DecoratorPatternFrame.getInstancFrame();
        } else if (name.equals("Memento Pattern")) {
            return MementoPatternFrame.getInstancFrame();
        } else if (name.equals("Visitor Pattern")) {
            return VisitorPatternFrame.getInstancFrame();
        }
        return null;
    }
}
