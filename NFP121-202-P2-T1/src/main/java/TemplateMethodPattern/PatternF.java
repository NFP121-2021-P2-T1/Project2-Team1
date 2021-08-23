/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemplateMethodPattern;

/**
 *
 * @author Cynthia
 */
public class PatternF  {
    private static PatternF patternFact;
private PatternF(){
    
}
    public static PatternF getInstanceFactory() {
        if (patternFact == null) {
            patternFact = new PatternF();
        }
        return patternFact;
    }
    public  PatternPanelTemplate getPattern(String name) {
        if(name == null) return null;
        else if(name.equals("builderBtn")){
            return BuilderPatternFrame.getInstancFrame();
        }
        else if(name.equals("singletonBtn")){
            return SingletonPatternFrame.getInstancFrame();
        }
        else if(name.equals("compositeBtn")){
            return CompositePatternFrame.getInstancFrame();
        }
        else if(name.equals("decoratorBtn")){
            return DecoratorPatternFrame.getInstancFrame();
        }
        else if(name.equals("mementoBtn")){
            return MementoPatternFrame.getInstancFrame();
        }
        else if(name.equals("visitorBtn")){
            return VisitorPatternFrame.getInstancFrame();
        }
        return null;
    }
}
