/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.entities;

import java.util.EnumSet;

/**
 *
 * @author siwar
 */
//public enum Type {
    //Single,Double;
    
//}
public class Type {
    public enum Types{
        Single, Double;
    }
    public static Types find(String abbr){
 
    for(Types v :EnumSet.allOf(Type.Types.class)){
        if( v.toString().equals(abbr)){
            return v;
        }
    }
    return null;
}
}
