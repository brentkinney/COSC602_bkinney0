/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import collection.*;


/**
 *
 * @author Brent
 */
public class Project1 {
    
    public static void test() {
    MySet primeNumSet = new MySet();
    MySet fibonacciNumSet = new MySet();
    fibonacciNumSet.addFib(30);
    System.out.println("fibonacciNumSet");
    System.out.println(fibonacciNumSet.toString());
    primeNumSet.addPrime(30);
    System.out.println("primeNumSet");
    System.out.println(primeNumSet.toString());
    System.out.println("Intersection of fibonacciNumSet and primeNumSet");
    System.out.println(fibonacciNumSet.intersection(primeNumSet));
    System.out.println("Symmetric difference of fibonacciNumSet and primeNumSet");
    System.out.println(fibonacciNumSet.symmetricDifference(primeNumSet));
    System.out.println("Union of fibonacciNumSet and primeNumSet");
    System.out.println(fibonacciNumSet.union(primeNumSet));
    System.out.println(fibonacciNumSet.subsetOf(primeNumSet));
    
    /**
    testing of all methods written using simpler data sets
    * MySet a = new MySet();
    MySet b = new MySet();
    a.add(1);
    a.add(2);
    a.add(3);
    b.add(2);
    b.add(3);
    b.add(4);
    System.out.println(a.cardinality());
    
    System.out.println(a.complement(b));
    
    System.out.println(a.intersection(b));
    System.out.println(a.subsetOf(b));
    System.out.println("TESTING BELOW PORTION");
    System.out.println(a.symmetricDifference(b));
    System.out.println(a.union(b));
    * */
}
    
}
