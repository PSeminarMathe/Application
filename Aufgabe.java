/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Random;


public class Aufgabe {
    
    private String base;
    
    private final static int border = 20;
    private final static Random rand = new Random();
    
    private static enum Operators {
        PLUS('+'), MINUS('-'), MAL('*');
        
        private char zeichen;
        Operators(char zeichen) {
            this.zeichen = zeichen;
        }
        
        public char getZeichen() {
            return zeichen;
        }
        
        public static Operators getOperator(String s) {
            for(Operators o : Operators.values()) {
                if(String.valueOf(o.getZeichen()).equals(s))
                    return o;
            }
            return null;
        }
    }
    
    public Aufgabe() {
        base = String.valueOf(getNumber()) + " " + Operators.values()[rand.nextInt(Operators.values().length)].getZeichen() + " " + String.valueOf(getNumber());
    }
    
    private int getNumber() {
       return rand.nextInt(border);
    }
    
    public String getExercise() {
        return base;
    }
    
    public int getResul() {
        String[] components = base.split(" ");
        
        int ergebnis = 0;
        Operators currentOp = null;
        
        for(String s: components) {
            if(isNumber(s) >= 0) { //danjn ist es ne nummer
                int zahl = isNumber(s);
                if(currentOp == null)
                  ergebnis = zahl;
              else {
                  switch(currentOp) {
                      case PLUS:
                          ergebnis += zahl;
                          break;
                      case MINUS:
                          ergebnis -= zahl;
                          break;
                      case MAL:
                          ergebnis *= zahl;
                          break;
               
                  }
              }
            } else {
                currentOp = Operators.getOperator(s);
            }
        }
        
        return ergebnis;
    }
    
    private static int isNumber(String s) {
        int result;
        try {
            result = Integer.valueOf(s);
        } catch(Exception e) {
            result = -1;
        }
        
        return result;
    }
    
}
