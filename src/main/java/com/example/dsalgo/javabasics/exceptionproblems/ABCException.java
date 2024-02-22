package com.example.dsalgo.javabasics.exceptionproblems;

/**
 * @author Hardeep Singh
 */

public class ABCException {

    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e){
            try {
                int a = 0 / 5;
                throw new ArithmeticException();
            } catch (ArithmeticException ex){
                System.out.println("Arithmetic exception");
            }
            System.out.println("Caught");
        }

    }
}
