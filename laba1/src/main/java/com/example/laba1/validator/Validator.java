package com.example.laba1.validator;
import  com.example.laba1.exceptions.InputException;

public class Validator {

     public  Validator() {

     }
     public void CheckString(String position) throws InputException {
         if(position.length() == 0) {
             throw new InputException("Empty string");
         }
         else {
             if(position.charAt(0) == '-') {
                 throw new InputException("Position must be positive");
             }
             for(int i = 0; i < position.length(); i++) {
                 if(position.charAt(i) < '0' || position.charAt(i) > '9') {
                     throw new InputException("Incorrect input");
                 }
             }
         }
     }
}
